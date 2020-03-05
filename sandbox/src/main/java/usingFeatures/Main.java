package usingFeatures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("String1");
        list.add("String2");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add("String4");

        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}
