package Lesson8;

public class SecondTask {

    public static void main(String[] args) {
        int[][] x = get(8);
        for (int[] ints : x) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
        }
    }

    public static int[][] get(int n) {
        int[][] resultArray = new int[n][n];

        if (n % 2 == 1) {
            int x = n / 2 - 1, y = 1, number = 1;
            while (number != n * n + 1) {
                x++;
                y--;
                if (x > n - 1)
                    x -= n;
                if (y < 0)
                    y += n;
                if (resultArray[y][x] != 0) {
                    x--;
                    y += 2;
                    if (x > n - 1)
                        x -= n;
                    if (x < 0)
                        x += n;
                    if (y < 0)
                        y += n;
                    if (y > n - 1)
                        y -= n;
                }
                resultArray[y][x] = number;
                number++;
            }
        }

        if (n % 4 == 0) {
            int numberIncrease = 0, numberDecrease = n * n + 1;
            int x = 0, y = 0;
            final int cubeSize = n / 4 - 1;

            try {
                while (y != n) {
                    numberIncrease++;
                    numberDecrease--;
                    final boolean b = (x >= 0 && x <= cubeSize) || (x >= n - cubeSize - 1 && x <= n - 1);
                    if ((b && (y >= 0 && y <= cubeSize)) ||
                            (b && (y >= n - cubeSize - 1 && y <= n - 1))
                            || ((x > cubeSize && x < n - cubeSize - 1) && (y > cubeSize && y < n - cubeSize - 1)))
                        resultArray[y][x] = numberIncrease;
                    else
                        resultArray[y][x] = numberDecrease;

                    x++;
                    if (x == n) {
                        y++;
                        x = 0;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                int a = 0;
            }
        }

        return resultArray;
    }
}
