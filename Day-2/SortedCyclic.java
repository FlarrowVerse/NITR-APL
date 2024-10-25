import java.util.Scanner;

public class SortedCyclic {

    /**
     * Returns maximum element from cyclically right shifted sorted array
     * @param n
     * @param A
     * @return
     */
    public static int findMax(int n, int[] A) {
        int max = -1;

        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (A[mid] > A[(mid + 1) % n]) {
                max = mid;                
                break;
            } else if (A[low] > A[mid]) {
                high = mid - 1;                
            } else {
                low = mid + 1;
            }
        }

        return max;
    }

    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.print("Enter the right shifted array elements one by one: ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();            
        }

        System.out.println("Maximum element of array: " + A[findMax(n, A)]);
        sc.close();
    }
    
}
