import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CycleCheck {

    /**
     * Performs depth first traversal of given graph
     * @param graph
     */
    public static boolean hasCycle(List<List<Integer>> graph, int parent, int child, boolean[] visited) {
        for (Integer node : graph.get(child)) {
            if (visited[node] == true && node != parent) {
                return true;                
            } else if(node != parent) {
                visited[node] = true;
                hasCycle(graph, child, node, visited);
            }
        }
        return false;
    }

    /**
     * Performs depth first traversal of given graph
     * @param graph
     */
    public static boolean hasCycle(List<List<Integer>> graph, int src) {
        boolean[] visited = new boolean[graph.size()];

        for (Integer node : graph.get(src)) {
            if (visited[node] == true && node != src) {
                return true;                
            } else if (src != node) {
                visited[node] = true;
                hasCycle(graph, src, node, visited);
            }
        }
        return false;
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("|V|: ");
        int v = sc.nextInt();

        // input using adjacency list
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < v; i++) {
            System.out.print("Enter number of nodes connected to Node #" + i + ": ");
            int n = sc.nextInt();
            graph.add(new ArrayList<Integer>());

            if (n <= 0) continue;
            System.out.print("Enter connected nodes: ");

            for (int j = 0; j < n; j++) {
                graph.get(i).add(sc.nextInt());
            }
        }

        if (hasCycle(graph, 0)) {
            System.out.println("The given graph has a cycle");
        } else {
            System.out.println("The given graph does not have a cycle");
        }

        sc.close();
    }
    
}
