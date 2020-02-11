package katas;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * You are given an array strarr of strings and an integer k.
 * Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 * <p>
 * Example:
 * longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 * <p>
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 * <p>
 * Note
 * consecutive strings : follow one after another without an interruption
 */
public class ConsecutiveStrings {
    public static void main(String[] args) {
        System.out.println("abigailtheta -> " + longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
        System.out.println("oocccffuucccjjjkkkjyyyeehh -> " + longestConsec(new String[] {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1)); //oocccffuucccjjjkkkjyyyeehh
        System.out.println(" -> " + longestConsec(new String[] {}, 3));
        System.out.println("wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck -> " + longestConsec(new String[] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2)); //wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck
        System.out.println("wlwsasphmxxowiaxujylentrklctozmymu -> " + longestConsec(new String[] {"wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"}, 2)); //wlwsasphmxxowiaxujylentrklctozmymu
        System.out.println(" -> " + longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas"}, -2)); //""
        System.out.println("ixoyx3452zzzzzzzzzzzz -> " + longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 3)); //ixoyx3452zzzzzzzzzzzz
        System.out.println(" -> " + longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 15)); // ""
        System.out.println(" -> " + longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 0)); //""
    }

    public static String longestConsec(String[] strarr, int k) {

        if(strarr.length == 0 || k > strarr.length || k <= 0) return  "";

        String result = "";
        for (int i = 0; i < strarr.length; i++) {
            if(i + k <= strarr.length){
                String tmp = Arrays.stream(Arrays.copyOfRange(strarr, i, i + k))
                        .collect(Collectors.joining());
                result = result.length() < tmp.length()? tmp : result;
            }
        }

        return result;
    }

    public static String bestPractices(String[] strarr, int k){
        if (k <= 0 || k > strarr.length) {
            return "";
        }

        return IntStream.rangeClosed(0, strarr.length - k)
                .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
