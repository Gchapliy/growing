package katas;

import java.math.BigInteger;
import java.util.*;

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
       System.out.println(hamming(2000));
    }

    private static BigInteger THREE = BigInteger.valueOf(3);
    private static BigInteger FIVE = BigInteger.valueOf(5);

    private static void updateFrontier(BigInteger x,
                                       PriorityQueue<BigInteger> pq) {
        pq.offer(x.shiftLeft(1));
        pq.offer(x.multiply(THREE));
        pq.offer(x.multiply(FIVE));
    }

    public static BigInteger hamming(int n) {
        PriorityQueue<BigInteger> frontier = new PriorityQueue<>();
        updateFrontier(BigInteger.ONE, frontier);
        BigInteger lowest = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            lowest = frontier.poll();
            while (frontier.peek().equals(lowest))
                frontier.poll();
            updateFrontier(lowest, frontier);
        }
        return lowest;
    }
}
