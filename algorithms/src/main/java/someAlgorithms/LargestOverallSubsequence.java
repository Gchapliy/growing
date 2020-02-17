package someAlgorithms;

import java.util.Arrays;

public class LargestOverallSubsequence {
    public static void main(String[] args) {
        System.out.println(findLargestOverallSubsequence(new int[]{1, 2, 3, 4}, new int[]{3, 1, 4, 5, 3, 1, 4}));
    }

    public static String findLargestOverallSubsequence(int[] a, int[] b) {
        int[][] d = new int[a.length + 1][b.length + 1];
        String subSeq = "";

        for (int i = 0; i <= a.length; i++) {
            d[i][0] = 0;
        }
        for (int j = 0; j <= b.length; j++) {
            d[0][j] = 0;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                if(a[i - 1] == b[j - 1]){
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - 1] + 1);
                }
            }
            subSeq += d[i][b.length] > d[i - 1][b.length] ? a[i - 1] : "";
        }

        return Arrays.deepToString(d) + "\n" + subSeq;
    }
}
