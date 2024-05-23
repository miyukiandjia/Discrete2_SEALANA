import java.util.*;

public class four {
    private Map<Integer, Integer> vertexDegrees;

    public four() {
        this.vertexDegrees = new HashMap<>();
    }

    public void addEdge(int v, int w) {
        vertexDegrees.put(v, vertexDegrees.getOrDefault(v, 0) + 1);
        vertexDegrees.put(w, vertexDegrees.getOrDefault(w, 0) + 1);
    }

    public void displayDegrees() {
        for (Map.Entry<Integer, Integer> entry : vertexDegrees.entrySet()) {
            System.out.println("Degree of vertex " + entry.getKey() + " is " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        four graph = new four();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        graph.displayDegrees();
    }
}
