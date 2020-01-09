package usingFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<String> list = Arrays.asList("item1", "item2", "item3", "item4", "item5");
    public static void main(String[] args) {
        list = list.stream().filter(f -> !f.equalsIgnoreCase("item2")).collect(Collectors.toList());

        System.out.println(list);
    }
}
