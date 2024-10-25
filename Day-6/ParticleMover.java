
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParticleMover {

    /**
     * Calculates the minimum energy required by a particle to reach dest from
     * src
     */
    public static int calculateEnergy(List<List<Integer>> graph, int src, int dest) {
        int[] hops = new int[graph.size()]; // stores the number of hops needed to reach dest
        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < hops.length; i++) {
            hops[i] = Integer.MAX_VALUE; // setting hops to infinite value
        }

        hops[src] = 0; // setting hops to 0 for source
        List<Integer> queue = new ArrayList<>();
        queue.add(src);

        // performing BFS
        while (!queue.isEmpty()) {
            int curr = queue.remove(0); // dequeue
            visited[curr] = true; // current node visited

            for (Integer node : graph.get(curr)) {
                if (hops[node] > hops[curr] + 1) {
                    hops[node] = hops[curr] + 1; // increment of hops by one for all children
                }

                if (!visited[node]) {
                    queue.add(node); // if not visited add it to the queue
                }
            }
        }

        return (int) Math.pow(2, hops[dest]) - 1;
    }

    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        System.out.println("Enter the connections between nodes: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("Number of connections for node #%d: ", i);
            int conns = sc.nextInt();
            graph.add(new ArrayList<>());

            System.out.print("Enter the connections: ");
            for (int j = 0; j < conns; j++) {
                graph.get(i).add(sc.nextInt());
            }
        }

        System.out.print("Enter the source node: ");
        int src = sc.nextInt();
        System.out.print("Enter the destination node: ");
        int dest = sc.nextInt();
        System.out.println("Minimum energy required: " + calculateEnergy(graph, src, dest));

        sc.close();
    }
}