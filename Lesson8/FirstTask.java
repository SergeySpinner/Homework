package Lesson8;

import java.util.Random;

public class FirstTask {
    public static void main(String[] args) throws exc {
        Random random = new Random();
        Integer[] f = new Integer[15];
        for (int i = 0; i < 15; i++) {
            int tempNumber = random.nextInt(15) + 15;
            int position = tempNumber % 15, startPosition = position;
            boolean visited;

            while (position < 15) {
                if (f[position] == null) {
                    f[position] = tempNumber;
                    break;
                } else {
                    position += 3;
                    if (position >= 15)
                        position -= 15;
                    visited = true;
                }
                if (position == startPosition && visited)
                    throw new exc("Looped");
            }
        }
        for (Integer temp : f)
            System.out.println(temp);
    }

    static class exc extends Exception {
        public exc(String e) {
            System.out.println(e);
        }
    }
}
