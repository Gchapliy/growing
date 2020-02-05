package katas;

/**
 * A *Hamming number* is a positive integer of the form 2i3j5k, for some non-negative integers i, j, and k.
 *
 * Write a function that computes the nth smallest Hamming number.
 *
 * Specifically:
 *
 * The first smallest Hamming number is 1 = 203050
 * The second smallest Hamming number is 2 = 213050
 * The third smallest Hamming number is 3 = 203150
 * The fourth smallest Hamming number is 4 = 223050
 * The fifth smallest Hamming number is 5 = 203051
 * The 20 smallest Hamming numbers are given in example test fixture.
 *
 * Your code should be able to compute all of the smallest 5,000 (Clojure: 2000) Hamming numbers without timing out.
 */
public class HammingNumber {
    public static void main(String[] args) {
        System.out.println(hamming(1));
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
        System.out.println(hamming(19));
    }

    public static long hamming(int n){
        int i = 0, j = 0, k = 0;
        int a = 2, b = 3, c = 5;


        return 0;
    }
}
