import java.util.Scanner;

public class TargetSum {

    /**
     * Recursively tries to add all the parts and equate to T
     * @param T target sum
     * @param n cuurent size of A
     * @param A
     * @param sum current sum
     * @param expr cuurent expression
     */
    public static void buildExpression(int T, int n, int[] A, int sum, String expr) {
        if (n == 1) {
            if (sum + A[A.length-n] == T) { // if T == sum + A[n-1]
                System.out.println(expr + "+" + A[A.length-n]);
            } else if (sum - A[A.length-n] == T) { // if T == sum - A[n-1]
                System.out.println(expr + "-" + A[A.length-n]);
            }
        } else {
            buildExpression(T, n - 1, A, sum + A[A.length - n], expr + "+" + A[A.length - n]);  // T == sum + A[n-i]
            buildExpression(T, n - 1, A, sum - A[A.length - n], expr + "-" + A[A.length - n]);  // T == sum - A[n-i]
        }
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("T: ");
        int T = sc.nextInt();

        buildExpression(T, n, A, 0, "");

        sc.close();
    }    
}
