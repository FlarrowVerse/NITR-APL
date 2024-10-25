import java.util.Scanner;
import java.util.Arrays;

public class TargetSum {

    /**
     * Find a print two numbers with sum <= T which is maximum
     * @param A
     * @param T
     */
    public static void findMaxSum(int[] A, int T) {
        Arrays.sort(A);

        int maxSum = Integer.MIN_VALUE; boolean found = false;
        int a1 = -1, a2 = -1;
        for (int low = 0, high = A.length - 1; low < high; ) {
            int sum = A[low] + A[high];
            if (sum <= T && sum > maxSum) {
                maxSum = sum;
                a1 = A[low]; a2 = A[high];
                found = true;
            } 
            if (sum > T) {
                high--;
            } else {
                low++;
            }
        }
        if (found) {
            System.out.printf("%d + %d = %d <= %d\n", a1, a2, a1+a2, T);
        }
    }
    
    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.print("Enter array elements one by one: ");
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();            
        }

        System.out.print("Enter target sum: ");
        int T = sc.nextInt();

        findMaxSum(A, T);

        sc.close();
    }
}
