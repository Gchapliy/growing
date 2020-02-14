package katas;

import java.util.stream.IntStream;

/**
 * Find the number with the most digits.
 * <p>
 * If two numbers in the argument array have the same number of digits, return the first one in the array.
 */
public class MostDigits {
    public static void main(String[] args) {
        System.out.println(findLongest(new int[]{8, 900, 500}));
        System.out.println(findLongest(new int[]{1, 10, 100}));
        System.out.println(findLongest(new int[]{9000, 8, 800}));
        System.out.println(findLongest(new int[]{3, 40000, 100}));
        System.out.println(findLongest(new int[]{1, 200, 100000}));
        System.out.println(findLongest(new int[]{-10, 1, 0, 1, 10}));
    }

    public static int findLongest(int[] numbers) {
        int mostDigits = 0;
        int maxCounter = 0;
        for (int i : numbers) {
            int counter = 0;
            int tmp = i > 0 ? i : i * -1;
            while (tmp > 0) {
                tmp /= 10;
                counter++;
            }
            if (counter > maxCounter) {
                mostDigits = i;
                maxCounter = counter;
            }
        }

        return mostDigits;
    }

    public static int bestPractices(int[] numbers) {
        return IntStream.of(numbers)
                .reduce(0, (a, b) -> String.valueOf(Math.abs(a)).length()
                        >= String.valueOf(Math.abs(b)).length() ? a : b);
    }
}
