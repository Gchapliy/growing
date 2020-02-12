package katas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings.
 * All words must have their first letter capitalized without spaces.
 * <p>
 * For instance:
 * <p>
 * camelCase("hello case"); // => "HelloCase"
 * camelCase("camel case word"); // => "CamelCaseWord"
 * Don't forget to rate this kata! Thanks :)
 */
public class CamelCaseMethod {
    public static void main(String[] args) {
        System.out.println(camelCase("hello case"));
        System.out.println(camelCase("camel case word"));
        System.out.println(camelCase(" camel case word"));
        System.out.println(camelCase("say hello "));
        System.out.println(camelCase("z"));
        System.out.println(camelCase("ab  c"));
        System.out.println(camelCase(""));
    }

    public static String camelCase(String str) {
        return str.isEmpty() ? "" : Arrays.stream(str.split(" "))
                .map(String::trim)
                .filter(f -> !f.isEmpty())
                .map(m -> m.substring(0, 1).toUpperCase() + m.substring(1))
                .collect(Collectors.joining());
    }
}
