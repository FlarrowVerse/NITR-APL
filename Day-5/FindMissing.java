import java.util.Scanner;
import java.util.Arrays;

public class FindMissing {

    /**
     * Find missing element from unsorted array
     * @param A
     * @return
     */
    public static int findMissing(int[] A) {
        return ((A.length * (A.length + 1)) / 2) - Arrays.stream(A).sum();
    }

    /**
     * Finds missing element from sorted array
     * @param A
     * @param asc true if it is in ascending order
     * @return
     */
    public static int findMissing(int[] A, boolean asc) {
        int low = 0, high = A.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return A[low] - 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        sc.nextLine();

        System.out.print("Is the array sorted?(Y/N): ");
        if ("yY".indexOf(sc.nextLine().charAt(0)) != -1) {
            System.out.println("Missing number is: " + findMissing(A, true));
        } else {
            System.out.println("Missing number is: " + findMissing(A));
        }

        sc.close();
    }    
}
