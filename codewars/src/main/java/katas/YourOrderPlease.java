package katas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Your task is to sort a given string. Each word in the string will contain a single number.
 * This number is the position the word should have in the result.
 *
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 *
 * If the input string is empty, return an empty string. The words in the input String
 * will only contain valid consecutive numbers.
 *
 * Examples
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */
public class YourOrderPlease {
    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
        System.out.println(order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    public static String order(String words) {
        return words.isEmpty() ? "" : Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.parseInt(Arrays.stream(s.split(""))
                        .filter(f -> !f.replaceAll("\\D*", "").isEmpty())
                        .collect(Collectors.joining(""))), Integer::compare))
                .collect(Collectors.joining(" "));
    }
}
