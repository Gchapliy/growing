package someAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = new int[1_000_000];
        fillRandomValues(a);
        int result;

        long startTime = System.nanoTime(), endTime;
        result = quadraticTwoSum(a);
        endTime = System.nanoTime();

        System.out.println("result:" + result + "; time: " + (endTime - startTime) / 1000000);

        startTime = System.nanoTime();
        result = fastTwoSum(a);
        endTime = System.nanoTime();

        System.out.println("result:" + result + "; time: " + (endTime - startTime) / 1000000);

    }

    private static void fillRandomValues(int[] a){
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100 + 100) - 100;
        }
    }

    public static int quadraticTwoSum(int[] a){
        int counter = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if(a[i] + a[j] == 0)
                    counter++;
            }
        }

        return counter;
    }

    public static int fastTwoSum(int[] a){
        int counter = 0;

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            if(Arrays.binarySearch(a, -a[i]) > i)
                counter++;
        }

        return counter;
    }
}
