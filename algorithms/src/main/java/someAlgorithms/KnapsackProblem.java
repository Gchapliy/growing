package someAlgorithms;

import java.util.Arrays;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = new int[]{0, 2, 3, 4};
        int[] c = new int[]{0, 10, 20, 30};

        int W = 8;

        solve(W, c, w);
    }

    public static int[][] solve(int W, int[] c, int[] w) {
        int[][] d = new int[w.length][W + 1];
        int[] p = new int[W];
        int position = 0;
        for (int i = 0; i < w.length - 1; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.println("check: " + (j + w[i + 1]) + " < " + W);
                if (j + w[i + 1] <= W){
                    System.out.println("max: " + "d[" + (i + 1) + "][" + (j + w[i + 1]) + "] = " + d[i + 1][j + w[i + 1]] + ", d[" + i + "][" + j + "] +  c[" + (i + 1) + "] = " + (d[i][j] + c[i + 1]));

                    d[i + 1][j + w[i + 1]] = Math.max(d[i + 1][j + w[i + 1]], d[i][j] + c[i + 1]);
                    if (j + w[i + 1] == W){
                        //TODO: path is wrong
                        p[position] = w[i + 1];
                        position++;
                    }
                }
                System.out.println("max: " + "d[" + (i + 1) + "][" + j + "] = " + d[i + 1][j] + ", " + "d[" + i + "][" + j + "] = " + d[i][j]);
                System.out.println("next step-------------------------------------------------");
                d[i + 1][j] = Math.max(d[i + 1][j], d[i][j]);

            }
        }

        for (int i = 0; i < d.length; i++) {
            System.out.println(Arrays.toString(d[i]));
        }

        System.out.println("Things in knapsack: " + Arrays.toString(Arrays.stream(p).filter(f -> f > 0).toArray()));
        System.out.println("weight: " + Arrays.stream(p).sum());

        return d;
    }
}