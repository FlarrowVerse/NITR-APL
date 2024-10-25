import java.util.Scanner;

public class GardenGrid {

    /**
     * Recursive call for searching the solution space
     * @param nGardens
     * @param nFlowers
     * @param graph
     * @param garden
     * @param flowerType
     * @param answers
     */
    public static boolean plant(int nGardens, int nFlowers, boolean[][] graph, int garden, int flowerType, int[] answers) {
        
        answers[garden] = flowerType; // planting

        if (garden + 1 == nGardens) {
            // all gardens planted, check solution
            return checkSolution(graph, answers);
        } else {
            for (int i = 1; i <= nFlowers; i++) {
                if (graph[garden][garden + 1] && i != flowerType && plant(nGardens, nFlowers, graph, garden+1, i, answers)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the current solution is at all feasible
     * @param graph
     * @param answers
     * @return
     */
    public static boolean checkSolution(boolean[][] graph, int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (i != j && answers[i] == answers[j] && graph[i][j]) {
                    // if two adjacent gardens have same flower type planted
                    return false;                    
                }
            }
        }
        return true;
    }

    /**
     * Computes the solution for given graph
     * @param nFlowers number of flower types to plant
     * @param nGardens number of gardens
     * @param graph adjacency matrix for gardens
     * @param answers solution
     */
    public static boolean plantFlowers(int nGardens, int nFlowers, boolean[][] graph, int[] answers) {
        if (nFlowers < nGardens) return false;

        // starting with the first garden and recursively calculating other possibilities
        for (int i = 1; i <= nFlowers; i++) {
            if (plant(nGardens, nFlowers, graph, 0, i, answers)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // flowers and gardens input
        System.out.print("Enter number of gardens: ");
        int nGardens = sc.nextInt();
        System.out.print("Enter number of flower types: ");
        int nFlowers = sc.nextInt();

        System.out.print("Enter number of existing paths:");
        int nPaths = sc.nextInt();
        int[][] paths = new int[nPaths][2];
        boolean[][] graph = new boolean[nGardens][nGardens]; // adjacency matrix

        System.out.println("Enter the paths one by one: ");
        for (int i = 0; i < nPaths; i++) {
            paths[i][0] = sc.nextInt(); // garden_i
            paths[i][1] = sc.nextInt(); // garden_j

            // bi-directional path in graph
            graph[paths[i][0] - 1][paths[i][1] - 1] = true;
            graph[paths[i][1] - 1][paths[i][0] - 1] = true;
        }

        int[] answers = new int[nGardens]; // answer

        if (plantFlowers(nGardens, nFlowers, graph, answers)) {
            // solution found- graph 4 colorable
            for (int i = 0; i < answers.length; i++) {
                System.out.printf("Garden %d has flower type %d planted in it.\n", (i+1), answers[i]);
            }
        } else {
            System.out.println("Solution does not exist for this pattern of gardens and paths.");
        }

        sc.close();
    }
}
