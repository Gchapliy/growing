package katas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * The number 89 is the first integer with more than one digit that fulfills the property partially
 * introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
 *
 * In effect: 89 = 8^1 + 9^2
 *
 * The next number in having this property is 135.
 *
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 *
 * We need a function to collect these numbers, that may receive two integers a, b that defines the range
 * [a, b] (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
 *
 * Let's see some cases:
 *
 * sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 * sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
 * If there are no numbers of this kind in the range [a, b] the function should output an empty list.
 *
 * sum_dig_pow(90, 100) == []
 * Enjoy it!!
 */
public class TakeNumberAndSumItsDigitsRaisedToTheConsecutivePowersAndEureka {
    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 10));
        System.out.println(sumDigPow(1, 100));
        System.out.println(sumDigPow(10, 100));
        System.out.println(sumDigPow(90, 100));
        System.out.println(sumDigPow(90, 150));
        System.out.println(sumDigPow(50, 150));
        System.out.println(sumDigPow(10, 150));
    }

    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.rangeClosed(a, b)
                .filter(f -> LongStream.rangeClosed(1, String.valueOf(f).length())
                        .map(m -> (long) Math.pow(Long.parseLong(String.valueOf(String.valueOf(f).charAt((int) (m - 1)))), m))
                        .sum() == f)
                .boxed()
                .collect(Collectors.toList());
    }
}
