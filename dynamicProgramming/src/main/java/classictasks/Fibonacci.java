package classictasks;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(6)));
    }

    public static int[] fib(int n){
        int[] f = new int[n];
        f[0] = f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }
}
