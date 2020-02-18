package someAlgorithms;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


        String[] graph = new String[edges.length];
        Arrays.fill(graph, "");

        graph[0] = edges[0];
        int minWeight = weights[0];
        int graphPosition = 1;

        //Creating min span tree
        for (int i = 1; i < edges.length; i++) {
            String connectors = "";
            boolean isCycle = false;
            for (int j = 0; j < graphPosition; j++) {
                if(edges[i].contains(graph[j].split("")[0])){
                    if(connectors.contains(graph[j].split("")[1])){
                        isCycle = true;
                        break;
                    }
                    connectors += graph[j].split("")[0];
                }
                if(edges[i].contains(graph[j].split("")[1])){
                    if(connectors.contains(graph[j].split("")[0])){
                        isCycle = true;
                        break;
                    }
                    connectors += graph[j].split("")[1];
                }
            }
            if(!isCycle) {
                graph[graphPosition] = edges[i];
                minWeight += weights[i];
                graphPosition++;
            }
        }

        System.out.println(Arrays.toString(edges));
        System.out.println(Arrays.toString(weights));
        return null;
    }
}