import java.util.Scanner;

public class Pentagon {
    
    /**
     * returns the number of points in the n-th pentagon considering all the previous ones as well.
     * @param n
     * @return
     */
    public static int pentagonal(int n) {
        if (n == 1) return 1; // base case
        else {
            return (3 * n - 2) + pentagonal(n-1);
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

        if (n < 1) {
            System.out.println("Enter a valid number greater than equal to 1.");
        } else {
            System.out.println("Total number of points in all pentagons of P_n: " + pentagonal(n));
        }

        sc.close();
    }
    
}
