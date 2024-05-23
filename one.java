import java.util.*;

public class one {
    private int vertices;
    private LinkedList<Integer> adjacencyList[];

    public one(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        Iterator<Integer> i = adjacencyList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public boolean isConnected() {
        boolean visited[] = new boolean[vertices];
        DFSUtil(0, visited);
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public int connectedComponents() {
        boolean visited[] = new boolean[vertices];
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        one graph = new one(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: v w):");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("The graph has " + graph.connectedComponents() + " connected components.");
        }
    }
}
