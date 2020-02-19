package katas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Write a function
 * <p>
 * TripleDouble(long num1, long num2)
 * which takes numbers num1 and num2 and returns 1 if there is a straight triple
 * of a number at any place in num1 and also a straight double of the same number in num2.
 * <p>
 * If this isn't the case, return 0
 * <p>
 * Examples
 * TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and
 * // num2 has straight double 99s
 * <p>
 * TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2
 * <p>
 * TripleDouble(12345, 12345) == 0
 * <p>
 * TripleDouble(666789, 12345667) == 1
 */
public class TripleTrouble {
    public static void main(String[] args) {

        System.out.println(bestPractices(451999277L, 41177722899L));//1
        System.out.println(bestPractices(1222345L, 12345L));//0
        System.out.println(bestPractices(12345L, 12345L));//0
        System.out.println(bestPractices(666789L, 123456567L));//0
        System.out.println(bestPractices(666789L, 12345667L));//1
        System.out.println(bestPractices(451999277L, 411777228L));//0
        System.out.println(bestPractices(1112L, 122L));//0
        System.out.println(bestPractices(10560002, 100));//1
    }

    public static int TripleDouble(long num1, long num2) {
        Set<String> set = Arrays.stream(Long.toString(num1).split(""))
                .filter(f -> Collections.frequency(Arrays.stream(Long.toString(num1).split(""))
                        .collect(Collectors.toList()), f) > 2)
                .collect(Collectors.toSet());
        if(set.stream()
                .filter(f -> Long.toString(num1).contains(Long.toString(Long.parseLong(f) * 111)))
                .collect(Collectors.toSet()).isEmpty()) return 0;

        set.retainAll(Arrays.stream(Long.toString(num2).split(""))
                .filter(f -> Collections.frequency(Arrays.stream(Long.toString(num2).split(""))
                        .collect(Collectors.toList()), f) == 2)
                .collect(Collectors.toSet()));

        if(set.stream()
                .filter(f -> Long.toString(num2).contains(Long.toString(Long.parseLong(f) * 11)))
                .collect(Collectors.toSet()).isEmpty()) return 0;

        return set.size() > 0 ? 1 : 0;
    }

    public static int bestPractices(long num1, long num2){
        return (num1 +","+ num2).matches("\\d*(\\d)\\1{2}\\d*,\\d*\\1{2}\\d*") ? 1 : 0;
    }
}
