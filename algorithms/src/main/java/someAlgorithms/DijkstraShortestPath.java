package someAlgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Dijkstra's algorithm (or Dijkstra's Shortest Path First algorithm, SPF algorithm) is an algorithm for finding
 * the shortest paths between nodes in a graph, which may represent, for example, road networks. It was conceived
 * by computer scientist Edsger W. Dijkstra in 1956 and published three years later.
 */
public class DijkstraShortestPath {
    public static void main(String[] args) {
        int[][] graph = new int[4][4];
        fillGraphRandom(graph);
        displayGraph(graph);
        int[][] dijkstra = dijkstra(graph);
        displayGraph(dijkstra);

        int[] path = new int[10];
        path[0] = dijkstra[0][0];

        System.out.println("Shortest path -> " + Arrays.toString(findPath(path, 1, dijkstra, 0, 0)));
    }

    private static void fillGraphRandom(int[][] graph) {
        Random rand = new Random();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (i == 0 && j == 0) continue;
                graph[i][j] = rand.nextInt(15);
            }
        }
    }

    private static void displayGraph(int[][] graph) {
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public static int[][] dijkstra(int[][] graph) {
        int[][] result = new int[graph.length][graph[0].length];
        initResultGraph(result);

        findVertices(graph, result, 0, 0, 0, 0);

        return result;
    }

    private static void initResultGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (i == 0 && j == 0) continue;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static void findVertices(int[][] graph, int[][] result, int x, int y, int xp, int yp) {
        if (y == graph.length) return;
        if (x == graph.length) return;

        result[x][y] = Math.min(result[xp][yp] + graph[x][y], result[x][y]);

        findVertices(graph, result, x, y + 1, x, y);
        findVertices(graph, result, x + 1, y, x, y);
    }

    //TODO: ArrayIndexOutOfBoundsException
    private static int[] findPath(int[] path, int position, int[][] graph, int x, int y) {
        if (y == graph.length) return path;
        if (x == graph.length) return path;

        if(x < graph.length - 1 && y < graph.length - 1){
            x = graph[x][y + 1] < graph[x + 1][y] ? x : x + 1;
            y = graph[x][y + 1] < graph[x + 1][y] ? y + 1 : y;

            path[position] = graph[x][y];
            findPath(path, position + 1, graph, x, y);
        } else if(x < graph.length - 1 && y == graph.length - 1) {
            x = graph[x][y] < graph[x + 1][y] ? x : x + 1;
            path[position] = graph[x][y];
            findPath(path, position + 1, graph, x, y);
        } else if(y < graph.length - 1 && x == graph.length - 1) {
            y = graph[x][y + 1];
            path[position] = graph[x][y];
            findPath(path, position + 1, graph, x, y);
        }

        return path;
    }
}
