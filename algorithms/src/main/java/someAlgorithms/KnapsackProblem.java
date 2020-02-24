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

        for (int i = 0; i < w.length - 1; i++) {
            for (int j = 0; j <= W; j++) {
                if (j + w[i + 1] <= W) {
                    d[i + 1][j + w[i + 1]] = Math.max(d[i + 1][j + w[i + 1]], d[i][j] + w[i + 1]);
                }
                d[i + 1][j] = Math.max(d[i + 1][j], d[i][j]);
            }
        }

        for (int i = 0; i < d.length; i++) {
            System.out.println(Arrays.toString(d[i]));
        }

        return d;
    }
}