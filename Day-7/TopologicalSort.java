import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TopologicalSort {
    
    /**
     * Performs topological sort of a given DAG
     * @param dag
     * @param indegree
     */
    public static void topoSort(List<List<Integer>> dag, int[] indegree) {
        int visited = dag.size();
        while (visited > 0) {
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    // found sources
                    System.out.print(i + "\t");
                    visited--;
                    indegree[i] = -1;
    
                    // reduce the indegree count for children
                    for (Integer c : dag.get(i)) {
                        indegree[c]--;
                    }
                }
            }
        }    
        System.out.println();    
    }
    
    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> dag = new ArrayList<List<Integer>>();

        System.out.print("Enter number of nodes: ");
        int nodes = sc.nextInt();
        for (int i = 0; i < nodes; i++) {
            dag.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        int[] indegree = new int[nodes];

        
        for (int i = 0; i < edges; i++) {
            System.out.printf("Enter edge #%d as 'source destination': ", i);
            int src = sc.nextInt();
            int dest = sc.nextInt();

            indegree[dest]++;
            dag.get(src).add(dest);
        }

        topoSort(dag, indegree);

        sc.close();
    }

}
