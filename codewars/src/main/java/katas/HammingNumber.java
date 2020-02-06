package katas;

import java.util.Arrays;

/**
 * A *Hamming number* is a positive integer of the form 2i3j5k, for some non-negative integers i, j, and k.
 * <p>
 * Write a function that computes the nth smallest Hamming number.
 * <p>
 * Specifically:
 * <p>
 * The first smallest Hamming number is 1 = 203050
 * The second smallest Hamming number is 2 = 213050
 * The third smallest Hamming number is 3 = 203150
 * The fourth smallest Hamming number is 4 = 223050
 * The fifth smallest Hamming number is 5 = 203051
 * The 20 smallest Hamming numbers are given in example test fixture.
 * <p>
 * Your code should be able to compute all of the smallest 5,000 (Clojure: 2000) Hamming numbers without timing out.
 */
public class HammingNumber {
    private static boolean[] isRight = new boolean[2_000_000_000];
    private static int pointer = 0;
    private static int previousResult = 0;
    private static int previousValue = 0;

    public static void main(String[] args) {
        long strt = System.nanoTime();
        for (int i = 1; i < 5000; i++) {
            System.out.println(hamming(i));
        }
        long fin = System.nanoTime();

        System.out.println("time: " + (double) (fin - strt) / 1_000_000_000); //~7sec
    }

    public static long hamming(int n) {
        int i = n > pointer ? 0 : previousResult;
        int j = n > pointer ? 0 : previousValue;
        previousValue = n;

        System.out.print("for " + n + " is: ");

        while (j < n) {
            i++;

            if (i <= pointer) {
                if (isRight[i - 1]) {
                    j++;
                }
                continue;
            }else if(isHamming(i, i, isRight)) {
                j++;
                isRight[pointer] = true;
            }

            if (i > pointer) {
                pointer++;
                /*if (pointer > isRight.length - 1) {
                    isRight = Arrays.copyOf(isRight, (int)(isRight.length *  1.2));
                }*/
            }
        }

        previousResult = i;
        return i;
    }

    public static boolean isHamming(int n, int target, boolean[] isRight) {
        if (n == 1) return true;

        if (n < target) return isRight[n - 1];

        if (n % 2 == 0) return isHamming(n / 2, target, isRight);
        if (n % 3 == 0) return isHamming(n / 3, target, isRight);
        if (n % 5 == 0) return isHamming(n / 5, target, isRight);

        return false;
    }
}