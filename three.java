import java.util.*;

public class three {
    private LinkedList<Integer>[] adjacencyList;
    private boolean[] visited;
    private int vertices;

    public three(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        this.visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v); // Since the graph is undirected
    }

    private boolean isCyclicUtil(int v, int parent) {
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adjacencyList[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, v)) {
                    return true;
                }
            }
            // If an adjacent is visited and not parent of current vertex, then there is a
            // cycle.
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclic() {
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < vertices; u++) {
            if (!visited[u]) { // Don't recur for u if it is already visited
                if (isCyclicUtil(u, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        three graph = new three(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        if (graph.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
        }
    }
}
