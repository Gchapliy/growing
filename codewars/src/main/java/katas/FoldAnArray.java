package katas;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * In this kata you have to write a method that folds a given array of integers by the middle x-times.
 * <p>
 * An example says more than thousand words:
 * <p>
 * Fold 1-times:
 * [1,2,3,4,5] -> [6,6,3]
 * <p>
 * A little visualization (NOT for the algorithm but for the idea of folding):
 * <p>
 * Step 1         Step 2        Step 3       Step 4       Step5
 * 5/           5|         5\
 * 4/            4|          4\
 * 1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
 * ----*----      ----*          ----*        ----*        ----*
 * <p>
 * <p>
 * Fold 2-times:
 * [1,2,3,4,5] -> [9,6]
 * As you see, if the count of numbers is odd, the middle number will stay.
 * Otherwise the fold-point is between the middle-numbers, so all numbers would be added in a way.
 * <p>
 * The array will always contain numbers and will never be null.
 * The parameter runs will always be a positive integer greater than 0 and says how many runs of folding your method has to do.
 * <p>
 * If an array with one element is folded, it stays as the same array.
 * <p>
 * The input array should not be modified!
 * <p>
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 * <p>
 * I have created other katas. Have a look if you like coding and challenges.
 */
public class FoldAnArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(foldArray(new int[]{1, 2, 3, 4, 5}, 1)));
        System.out.println(Arrays.toString(foldArray(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(foldArray(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(foldArray(new int[]{-9, 9, -8, 8, 66, 23}, 1)));
    }

    public static int[] foldArray(int[] array, int runs) {
        int[] tmp = Arrays.copyOfRange(array, 0, array.length);

        for (int i = 0; i < runs; i++) {
            if (tmp.length < 2) return tmp;
            int middle = tmp.length / 2;

            for (int j = 0; j < middle; j++) {
                tmp[j] += tmp[tmp.length - 1 - j];
            }

            tmp = Arrays.copyOfRange(tmp, 0, (tmp.length % 2 == 0 ? tmp.length / 2 : (tmp.length / 2) + 1));
        }

        return tmp;
    }

    public static int[] bestPractices(int[] array, int runs){
        final int[] result = Arrays.copyOfRange(array, 0, Math.round(array.length / 2.0f));

        IntStream.range(0, array.length / 2)
                .forEach(i -> result[i] = array[i] + array[array.length - 1 - i]);

        return runs > 1 ? foldArray(result, --runs) : result;
    }
}
