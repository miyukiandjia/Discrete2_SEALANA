import java.util.*;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];
        Map<String, Integer> edgeCount = new LinkedHashMap<>();

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Processing the adjacency matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = "Edge " + i + "-" + j;
                    edgeCount.put(edge, adjacencyMatrix[i][j]);
                }
            }
        }

        // Output the edges and their counts
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + " appears " + entry.getValue() + " times.");
        }
    }
}
