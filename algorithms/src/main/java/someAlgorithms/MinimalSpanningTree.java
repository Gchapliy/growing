package someAlgorithms;

/**
 * Kraskal algorithm
 */
public class MinimalSpanningTree {
    public static void main(String[] args) {

        getMinimalSpanningTree(new String[]{"ab", "ae", "bc", "be", "cd", "ed", "ec"}, new int[]{3, 1, 5, 4, 2, 7, 6});
    }

    public static String[] getMinimalSpanningTree(String[] edges, int[] weights) {
        //Sort graph by weights
        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                if (weights[j] < weights[i]) {
                    int tmp = weights[i];
                    weights[i] = weights[j];
                    weights[j] = tmp;
                    String sTmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = sTmp;
                }
            }
        }


        return null;
    }
}