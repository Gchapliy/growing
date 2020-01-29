package katas;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Welcome. In this kata, you are asked to square every digit of a number.
 *
 * For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.
 *
 * Note: The function accepts an integer and returns an integer
 */
public class SquareEveryDigit {
    public static void main(String[] args) {
        System.out.println(squareDigits(9119));
    }

    public static int squareDigits(int n) {

        return Integer.parseInt(Arrays.toString(Stream.of(Integer.toString(n).split(""))
                .mapToInt(i -> Integer.parseInt(i))
                                        .map(i -> i*i)
                                        .boxed()
                                        .toArray()).replaceAll("\\[|\\]|,|\\s", ""));
    }
}
