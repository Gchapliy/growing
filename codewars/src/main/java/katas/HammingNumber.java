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
        /*System.out.println(hamming(1));
        System.out.println(hamming(2));
        System.out.println(hamming(3));
        System.out.println(hamming(4));
        System.out.println(hamming(5));
        System.out.println(hamming(6));
        System.out.println(hamming(7));
        System.out.println(hamming(8));
        System.out.println(hamming(9));
        System.out.println(hamming(10));
        System.out.println(hamming(11));
        System.out.println(hamming(12));
        System.out.println(hamming(13));
        System.out.println(hamming(14));
        System.out.println(hamming(15));
        System.out.println(hamming(16));
        System.out.println(hamming(17));
        System.out.println(hamming(18));
        System.out.println(hamming(19));*/
        long strt = System.nanoTime();
        for (int i = 1; i < 400; i++) {
            System.out.println(hamming(i));
        }
        long fin = System.nanoTime();

        System.out.println("time: " + (double)(fin - strt) / 1_000_000_000); //~0.5sec
    }

    public static long hamming(int n) {
        int i = 0;
        int j = 0;

        System.out.print("for " + n + " is: ");

        while (j < n){
            i++;

            if(isHamming(i))j++;

        }

        return i;
    }

    public static boolean isHamming(int n) {
        if (n == 1) return true;
        if (n % 2 == 0) return isHamming(n / 2);
        if (n % 3 == 0) return isHamming( n / 3);
        if(n % 5 == 0) return isHamming( n / 5);

        return false;
    }
}
