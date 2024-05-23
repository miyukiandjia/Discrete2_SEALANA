import java.util.*;

public class seven {
    private List<Map.Entry<Integer, Integer>> edges;
    private int vertices;

    public seven(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int from, int to, int count) {
        for (int i = 0; i < count; i++) {
            this.edges.add(new AbstractMap.SimpleEntry<>(from, to));
        }
    }

    public void printIncidenceMatrix() {
        int[][] incidenceMatrix = new int[vertices][edges.size()];

        for (int i = 0; i < edges.size(); i++) {
            Map.Entry<Integer, Integer> edge = edges.get(i);
            incidenceMatrix[edge.getKey()][i] = 1;
            incidenceMatrix[edge.getValue()][i] = 1;
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        seven graph = new seven(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter each edge with the number of times it appears (format: from to count):");
        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int count = scanner.nextInt();
            graph.addEdge(from, to, count);
        }

        graph.printIncidenceMatrix();
    }
}
