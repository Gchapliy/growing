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

        String[] result = new String[edges.length];
        Arrays.fill(result, "");

        for (int i = 0; i < edges.length; i++) {
            String a = edges[i].split("")[0];
            String b = edges[i].split("")[1];

            List<String> connectors = new ArrayList<>();
            findConnectors(edges, i - 1, a, connectors);
            findConnectors(edges, i - 1, b, connectors);

            if(connectors.stream()
                    .filter(f -> Collections.frequency(connectors, f) > 1)
                    .collect(Collectors.toSet()).isEmpty())
                result[i] = edges[i];
        }

        return Arrays.stream(result).filter(f -> !f.isEmpty()).toArray(String[]::new);
    }

    private static void findConnectors(String[] edges, int position, String target, List<String> connectors){
        if(position < 0) return;
        if(edges[position].contains(target)){
            String a = edges[position].split("")[0];
            String b = edges[position].split("")[1];
            if(a.equals(target)){
                connectors.add(b);
                findConnectors(edges, position - 1, b, connectors);
            }
            if(b.equals(target)){
                connectors.add(a);
                findConnectors(edges, position - 1, a, connectors);
            }
        } else {
            findConnectors(edges, position - 1, target, connectors);
        }
    }
}