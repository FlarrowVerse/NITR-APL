import java.util.Scanner;

public class Arrange {
    
    /**
     * Arrange the array such that positive and negative numbers are alternating
     * @param A
     */
    public static void arrangeAlternate(int[] A) {
        int posIdx = 0, negIdx = 1; // points to current pair being compared
        int i = 0, j = 0; // searches ahead i = positive, j = negative

        while (posIdx < A.length-1 && negIdx < A.length && i < A.length && j < A.length) {
            if (A[posIdx] >= 0) {
                posIdx += 2; // if current pair already has positive number at correct place, move the pointer
                i = posIdx;
            } else {
                if (A[i] >= 0) {
                    int temp = A[i];
                    A[i] = A[posIdx];
                    A[posIdx] = temp;
                } else {
                    i++; // look for next occuring positive number
                }
            }

            if (A[negIdx] < 0) {
                negIdx += 2; // if current pair already has positive number at correct place, move the pointer
                j = negIdx-1;
            } else {
                if (A[j] < 0) {
                    int temp = A[j];
                    A[j] = A[negIdx];
                    A[negIdx] = temp;
                } else {
                    j++; // look for next occuring negative number
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

        // size input
        System.out.print("n: ");
        int n = sc.nextInt();

        // array input
        System.out.print("A: ");
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        arrangeAlternate(A);

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        sc.close();
    }
    
}
