package katas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James.
 * Since James doesn't know how to make this happen, he needs your help.
 * <p>
 * Task
 * You need to return a string that looks like a diamond shape when printed on the screen,
 * using asterisk (*) characters. Trailing spaces should be removed, and every line must be
 * terminated with a newline character (\n).
 * <p>
 * Return null/nil/None/... if the input is an even number or negative, as it is not possible to print
 * a diamond of even or negative size.
 * <p>
 * Examples
 * A size 3 diamond:
 * <p>
 *  *
 * ***
 *  *
 * ...which would appear as a string of " *\n***\n *\n"
 * <p>
 * A size 5 diamond:
 * <p>
 *   *
 *  ***
 * *****
 *  ***
 *   *
 * ...that is: " *\n ***\n*****\n ***\n *\n"
 */
public class GiveMeADiamond {
    public static void main(String[] args) {
        System.out.println(print(1));
    }

    public static String print(int n) {
        if (n % 2 == 0 || n < 1) return null;

        String[] diamond = new String[n];
        Arrays.fill(diamond, "");

        for (int i = 0, j = 1, k = diamond.length / 2; i < (diamond.length / 2) + 1; i++, j += 2, k--) {
            for (int m = 0; m < k; m++) {
                diamond[i] += " ";
                diamond[n - 1 - i] += n - 1 - i == i ? "" : " ";
            }
            for (int l = 0; l < j; l++) {
                diamond[i] += "*";
                diamond[n - 1 - i] += n - 1 - i == i ? "" : "*";
            }
            diamond[i] += "\n";
            diamond[n - 1 - i] += n - 1 - i == i ? "" : "\n";
        }

        return Arrays.stream(diamond).collect(Collectors.joining(""));
    }
}
