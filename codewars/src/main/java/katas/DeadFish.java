package katas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Write a simple parser that will parse and run Deadfish.
 * <p>
 * Deadfish has 4 commands, each 1 character long:
 * <p>
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * Invalid characters should be ignored.
 * <p>
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 */
public class DeadFish {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(parse("iiisdoso"))); // 8, 64
        System.out.println(Arrays.toString(parse("iiisdosodddddiso"))); // 8, 64, 3600
        System.out.println(Arrays.toString(parse("iisidsodddsdsisiiosisoiooioo")));
        System.out.println(Arrays.toString(parse("ssoddososisidoooisidoddoddsisosidiiidsiodoiisiisi")));
        System.out.println(Arrays.toString(parse("ffff")));
    }

    public static int[] parse(String data) {
        data = Arrays.stream(data.split(""))
                .filter(f -> f.matches("[isdo]"))
                .collect(Collectors.joining());
        StringBuilder res = new StringBuilder();

        int target = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 1).equals("i")) target++;
            if (data.substring(i, i + 1).equals("d")) target--;
            if (data.substring(i, i + 1).equals("s")) target = (int) Math.pow(target, 2);
            if (data.substring(i, i + 1).equals("o")) res.append(target).append(" ");
        }

        return res.toString().isEmpty() ? new int[0] : Arrays.stream(res.toString().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}