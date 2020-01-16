package katas;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "("
 * if that character appears only once in the original string, or ")" if that character appears more than once in
 * the original string. Ignore capitalization when determining if a character is a duplicate.
 * <p>
 * Examples
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 * Notes
 * <p>
 * Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX",
 * the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("din").equals("((("));
        System.out.println(encode("recede").equals("()()()"));
        System.out.println(encode("Success").equals(")())())"));
        System.out.println(encode("(( @").equals("))(("));
    }

    public static String encode(String word) {
    return word.chars()
                .mapToObj(e -> (char) e)
                .map(Character::toLowerCase)
                .map(m -> Collections.frequency(word.chars()
                        .mapToObj(e -> (char) e)
                        .map(Character::toLowerCase)
                        .collect(Collectors.toList()), m) > 1 ? ")" : "(")
                .collect(Collectors.joining());
    }
}
