import java.util.*;

public class eight {
    private static int[][] readGraph(Scanner scanner, int vertices) {
        int[][] adjacencyMatrix = new int[vertices][vertices];
        System.out.println("Enter adjacency matrix for the graph:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        return adjacencyMatrix;
    }

    private static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        if (graph1.length != graph2.length)
            return false;

        int vertices = graph1.length;
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            permutation.add(i);

        do {
            if (checkPermutation(graph1, graph2, permutation)) {
                return true;
            }
        } while (nextPermutation(permutation));
        return false;
    }

    private static boolean checkPermutation(int[][] graph1, int[][] graph2, List<Integer> permutation) {
        int vertices = graph1.length;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (graph1[i][j] != graph2[permutation.get(i)][permutation.get(j)]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean nextPermutation(List<Integer> permutation) {
        int k = permutation.size() - 2;
        while (k >= 0 && permutation.get(k) >= permutation.get(k + 1)) {
            k--;
        }
        if (k == -1)
            return false;

        int l = permutation.size() - 1;
        while (permutation.get(k) >= permutation.get(l)) {
            l--;
        }
        Collections.swap(permutation, k, l);
        Collections.reverse(permutation.subList(k + 1, permutation.size()));
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices for the graphs: ");
        int vertices = scanner.nextInt();

        System.out.println("Graph 1:");
        int[][] graph1 = readGraph(scanner, vertices);

        System.out.println("Graph 2:");
        int[][] graph2 = readGraph(scanner, vertices);

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}
