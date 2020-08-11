package someTasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnionInTwoLists {
    public static void main(String[] args){

        List<A> list1 = Arrays.asList(new A(1, "a"), new A(2, "b"), new A(3, "c"), new A(4, "d"));
        List<A> list2 = Arrays.asList(new A(5, "e"), new A(2, "f"), new A(6, "g"), new A(4, "h"), new A(7, "i"));

        List<A> result = list1.stream().flatMap(x -> list2.stream().filter(y -> y.getId() == x.getId())).collect(Collectors.toList());

        System.out.println(result);
    }

    public static class A{
        String unic;
        int id;

        public A(int id, String unic) {
            this.id = id;
            this.unic = unic;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "unic='" + unic + '\'' +
                    ", id=" + id;
        }
    }
}
