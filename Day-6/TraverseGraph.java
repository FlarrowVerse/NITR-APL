import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TraverseGraph {

    /**
     * Performs depth first traversal of given graph
     * @param graph
     */
    public static void traverseDepthFirst(List<List<Integer>> graph, int src) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> stack = new ArrayList<>();
        System.out.print(src + "\t");
        stack.add(src);
        visited[src] = true;

        // main loop
        while (!stack.isEmpty()) {

            int curr = stack.get(stack.size() - 1); // fetch the last element
            boolean pushed = false; // check if any connected nodes left unvisited
            for (Integer node : graph.get(curr)) {
                if (!visited[node]) { // first unvisited node
                    pushed = true;
                    System.out.print(node + "\t");
                    stack.add(node);
                    visited[node] = true;
                    break;
                }
            }

            if (!pushed) {
                stack.remove(stack.size() - 1); // if all connections visited remove from stack
            }
        }
    }

    /**
     * Performs breadth first traversal of given graph
     * @param graph
     */
    public static void traverseBreadthFirst(List<List<Integer>> graph, int src) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> queue = new ArrayList<>();

        queue.add(src);

        // main loop
        while (!queue.isEmpty()) {
            int curr = queue.remove(0); // dequeue the first element

            if (visited[curr]) continue;

            // printing next node in queue
            System.out.print(curr + "\t");
            visited[curr] = true;

            // adding all children not visited
            for (Integer node : graph.get(curr)) {
                if (!visited[node]) {
                    queue.add(node);
                }
            }
            
        }
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

        System.out.print("Enter the node number the traversal has to start from: ");
        int src = sc.nextInt();
        if (src >= 0 && src < v) {
            System.out.print("Depth First Traversal: ");
            traverseDepthFirst(graph, src);
            System.out.println();

            System.out.print("Breadth First Traversal: ");
            traverseBreadthFirst(graph, src);
            System.out.println();
        } else {
            System.out.println("Invalid input!");
        }        

        sc.close();
    }
    
}
