package usingFeatures;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StreamFeatures {
    public static void main(String[] args) {
        List<BigDecimal> list = new ArrayList<>();
        list.add(new BigDecimal("1"));
        list.add(new BigDecimal("2"));
        list.add(new BigDecimal("3"));
        list.add(new BigDecimal("4"));
        list.add(new BigDecimal("5"));

        System.out.println(list.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
