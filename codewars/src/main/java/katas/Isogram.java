package katas;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines
 * whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.
 *
 * isIsogram "Dermatoglyphics" == true
 * isIsogram "aba" == false
 * isIsogram "moOse" == false -- ignore letter case
 */
public class Isogram {
    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics"));
        System.out.println(isIsogram("aba"));
        System.out.println(isIsogram("moose"));
        System.out.println(isIsogram("isogram"));
        System.out.println(isIsogram("isIsogram"));
        System.out.println(isIsogram("moOse"));
        System.out.println(isIsogram("thumbscrewjapingly"));
        System.out.println(isIsogram(""));
    }

    public static boolean isIsogram(String str){
        return str.chars()
                .mapToObj(e -> (char) e)
                .map(Character::toLowerCase)
                .filter(i -> Collections.frequency(str.chars()
                        .mapToObj(e -> (char) e)
                        .map(Character::toLowerCase)
                        .collect(Collectors.toList()), i) > 1)
                .collect(Collectors.toSet()).size() == 0;
    }
}
