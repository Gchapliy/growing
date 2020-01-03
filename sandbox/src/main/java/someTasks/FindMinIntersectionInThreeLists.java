package someTasks;

import java.util.Arrays;
import java.util.List;

public class FindMinIntersectionInThreeLists {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> b = Arrays.asList(2, 3, 6, 7, 1, 8, 9);
        List<Integer> c = Arrays.asList(1, 2, 3, 10, 11, 12);

        System.out.println(a.stream().filter(f -> b.contains(f)).filter(f -> c.contains(f)).min(Integer::compare).get());
    }
}
