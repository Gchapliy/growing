package katas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing.
 * The first word within the output should be capitalized only if the original word was capitalized
 * (known as Upper Camel Case, also often referred to as Pascal case).
 *
 * Examples
 * toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"
 *
 * toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
 */
public class ConvertStringToCamelCase {
    public static void main(String[] args) {
        System.out.println(toCamelCase("the-the-stealth-warrior"));
        System.out.println(toCamelCase("The_The-Stealth_Warrior"));
    }

    static String toCamelCase(String s){

        String[] str = s.split("-|_");

        for (int i = 0; i < str.length; i++) {
            if(i > 0) str[i] = str[i].substring(0,1).toUpperCase() + str[i].substring(1);
        }

        return Arrays.stream(str).collect(Collectors.joining());
    }

    static String bestPractices(String s){
        String[] words = s.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(m -> m.substring(0, 1).toUpperCase() + m.substring(1))
                .reduce(words[0], String::concat);
    }
}
