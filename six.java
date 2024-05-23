import java.util.*;

public class six {
    private int[][] adjacencyMatrix;
    private int vertices;

    public six(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int from, int to) {
        adjacencyMatrix[from][to] += 1; // Increment the value to handle multiple edges and loops
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        six graph = new six(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to);
        }

        graph.printAdjacencyMatrix();
    }
}
