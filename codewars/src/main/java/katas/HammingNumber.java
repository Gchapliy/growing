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
    public static void main(String[] args) {
        long strt = System.nanoTime();
        for (int i = 1; i < 1000; i++) {
            System.out.println(hamming(i));
        }
        long fin = System.nanoTime();

        System.out.println("time: " + (double)(fin - strt) / 1_000_000_000); //~0.5sec
    }

    public static long hamming(int n) {
        int i = 0;
        int j = 0;

        System.out.print("for " + n + " is: ");
        int[] isHamm = new int[n * 2];
        int[] notHamm = new int[n * 2];

        int isHammPointer = 0, notHammPointer = 0;
        while (j < n){
            i++;

            if(isHamming(i, isHamm, notHamm, isHammPointer, notHammPointer)){
                isHamm[isHammPointer] = i;
                isHammPointer++;
                j++;
                if(isHamm.length - 1 < isHammPointer){
                    isHamm = Arrays.copyOf(isHamm, isHamm.length * 2);
                }
            } else {
                notHamm[notHammPointer] = i;
                notHammPointer++;
                if(notHamm.length - 1 < notHammPointer){
                    notHamm = Arrays.copyOf(notHamm, notHamm.length * 2);
                }
            }
            /*if(isHamming(i, isHamm, notHamm)){
                isHamm[isHammPointer] = i;
                isHammPointer++;
                j++;
            } else {
                notHamm[notHammPointer] = i;
                notHammPointer++;
            }
*/
        }

        return i;
    }

    public static boolean isHamming(int n, int[] notHamm) {
        if(Arrays.binarySearch(notHamm, n) > -1) return false;
        if (n == 1) return true;
        if (n % 2 == 0) return isHamming(n / 2, notHamm);
        if (n % 3 == 0) return isHamming( n / 3, notHamm);
        if(n % 5 == 0) return isHamming( n / 5,  notHamm);

        return false;
    }

    public static boolean isHamming(int n, int[] isHamm, int[] notHamm, int isP, int nP) {
        if (n == 1) return true;

        if(n < isHamm[isP - 1])
            if(Arrays.binarySearch(isHamm, n) > -1) return true;
        if(n < notHamm[nP - 1])
            if(Arrays.binarySearch(notHamm, n) > -1) return false;

        if (n % 2 == 0) return isHamming(n / 2, isHamm, notHamm, isP, nP);
        if (n % 3 == 0) return isHamming( n / 3, isHamm, notHamm, isP, nP);
        if(n % 5 == 0) return isHamming( n / 5, isHamm, notHamm, isP, nP);

        return false;
    }
}
