package someAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Kraskal algorithm
 */
public class MinimumSpanningTree {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(getMinimumSpanningTree(new String[]{"ab", "ae", "bc", "be", "cd", "ed", "ec"}, new int[]{3, 1, 5, 4, 2, 7, 6})));
    }

    public static String[] getMinimumSpanningTree(String[] edges, int[] weights) {
        //Sort graph by weights
        mergeSort(weights, edges, 0, weights.length);

        String[] result = new String[edges.length];
        Arrays.fill(result, "");

        for (int i = 0; i < edges.length; i++) {
            String a = edges[i].split("")[0];
            String b = edges[i].split("")[1];

            List<String> connectors = new ArrayList<>();
            findConnectors(edges, i - 1, a, connectors);
            findConnectors(edges, i - 1, b, connectors);

            if (connectors.stream()
                    .filter(f -> Collections.frequency(connectors, f) > 1)
                    .collect(Collectors.toSet()).isEmpty())
                result[i] = edges[i];
        }

        return Arrays.stream(result).filter(f -> !f.isEmpty()).toArray(String[]::new);
    }

    private static void mergeSort(int[] weights, String[] edges, int low, int high) {
        if (high - low < 2) return;
        int mid = (low + high) >>> 1;
        mergeSort(weights, edges, low, mid);
        mergeSort(weights, edges, mid, high);
        int[] b = Arrays.copyOfRange(weights, low, mid);
        String[] c = Arrays.copyOfRange(edges, low, mid);
        for (int i = low, j = mid, k = 0; k < b.length; i++) {
            if (j == high || b[k] <= weights[j]) {
                int m = k++;
                weights[i] = b[m];
                edges[i] = c[m];
            } else {
                int p = j++;
                weights[i] = weights[p];
                edges[i] = edges[p];
            }
        }
    }

    private static void findConnectors(String[] edges, int position, String target, List<String> connectors) {
        if (position < 0) return;
        if (edges[position].contains(target)) {
            String a = edges[position].split("")[0];
            String b = edges[position].split("")[1];
            if (a.equals(target)) {
                connectors.add(b);
                findConnectors(edges, position - 1, b, connectors);
            }
            if (b.equals(target)) {
                connectors.add(a);
                findConnectors(edges, position - 1, a, connectors);
            }
        } else {
            findConnectors(edges, position - 1, target, connectors);
        }
    }
}