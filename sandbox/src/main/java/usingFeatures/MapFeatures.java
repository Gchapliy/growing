package usingFeatures;

import java.util.HashMap;
import java.util.Map;

public class MapFeatures {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        String val = map.computeIfAbsent(4, (v) -> "ch");
        String val1 = map.computeIfAbsent(4, (v) -> "ch");

        System.out.println(val);
        System.out.println(val1);
        System.out.println(map);
    }
}
