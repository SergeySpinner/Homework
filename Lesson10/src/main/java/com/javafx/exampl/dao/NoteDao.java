package com.javafx.exampl.dao;

import com.javafx.exampl.entity.Note;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {

    public static final String INSERT_QUERY = "INSERT INTO note(description, \"createdTime\") VALUES (?, ?)";
    public static final String DELETE_QUERY = "DELETE FROM note where id = ?";
    public static final String SELECT_ALL = "SELECT * FROM NOTE";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0000";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public Note create(Note note) throws DaoException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, note.getDescription());
            Timestamp timestamp = Timestamp.valueOf(note.getCreatedTime());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            int id = generatedKeys.getInt(1);
            note.setId(id);
            return note;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException("Failed to connect");
        }
    }

    public void delete(Note note) throws DaoException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)
        ) {
            preparedStatement.setInt(1, note.getId());

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException("Failed to connect");
        }
    }

    public List<Note> findAll() throws DaoException {
        List<Note> notes = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

            while (resultSet.next()) {
                Note note = new Note(
                        resultSet.getInt("id"),
                        resultSet.getString("description"),
                        LocalDateTime.parse(resultSet.getString("createdTime"), formatter)
                );
                notes.add(note);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return notes;
    }
}
