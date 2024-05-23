import java.util.*;

public class five {
    private int vertices;
    private List<Integer>[] adjacencyList;

    public five(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    public boolean isBipartite() {
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1); // -1 indicates that no color has been assigned yet

        for (int start = 0; start < vertices; start++) {
            if (colors[start] == -1) { // Not colored
                if (!isBipartiteUtil(start, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int v, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        colors[v] = 1; // Start coloring with 1

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjacencyList[current]) {
                if (colors[neighbor] == -1) { // If not colored
                    colors[neighbor] = 1 - colors[current]; // Assign alternate color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[current]) { // If same color as current
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        five graph = new five(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
