package Lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
            numbers.add(random.nextInt(25));

        System.out.println((double) numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce((summa, number) -> summa + number * number)
                .getAsInt()
                / numbers
                .stream()
                .count());
    }
}
