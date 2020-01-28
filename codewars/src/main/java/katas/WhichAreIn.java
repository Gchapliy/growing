package katas;

import java.util.Arrays;

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings
 * of a1 which are substrings of strings of a2.
 *
 * #Example 1: a1 = ["arp", "live", "strong"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * returns ["arp", "live", "strong"]
 *
 * #Example 2: a1 = ["tarp", "mice", "bull"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * returns []
 *
 * Notes:
 * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
 *
 * In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
 *
 * Beware: r must be without duplicates.
 * Don't mutate the inputs.
 */

public class WhichAreIn {
    public static void main(String[] args) {
        String a[] = new String[]{"live", "arp", "live", "strong"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String a1[] = new String[]{"tarp", "mice", "bull"};
        String b1[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        System.out.println(Arrays.toString(inArray(a, b)));
        System.out.println(Arrays.toString(inArray(a1, b1)));
    }

    public static String[] inArray(String[] a, String[] b) {
        return Arrays.stream(a)
                .filter(f -> (Arrays.stream(b).anyMatch(f1 -> f1.contains(f))))
                .distinct()
                .sorted(String::compareTo)
                .toArray(String[]::new);
    }
}
