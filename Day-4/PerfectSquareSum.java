import java.util.Scanner;

public class PerfectSquareSum {

    public static String getPerfectSquareSum(int n) {

        int[][] dp = new int[(int)Math.floor(Math.sqrt(n))][n+1]; // tabulization table

        /*
         * dp[i][j] = what is the least number of perfect squares in the range [1^2, i^2] that add upto j
         */

        for (int i = 0; i < dp.length; i++) {
            // solve each row first
            for (int j = 0; j <= n; j++) {
                // solve one cell
                if (j == 0) dp[i][j] = 0; // if the required number is 0
                if (i == 0) { // if first row
                    dp[i][j] = j;
                } else if (j < (int)Math.pow(i+1, 2)) { // if required sum is less than the current perfect square
                    dp[i][j] = dp[i-1][j]; // use the previous row's result
                } else {
                    int currSquare = (i+1)*(i+1);
                    dp[i][j] = Math.min(dp[i-1][j], (j / currSquare) + dp[i-1][j % currSquare]);
                }

            }
        }

        System.out.println(dp[dp.length-1][n]);
        int solution = dp[dp.length-1][n];

        String expression = "";

        int reqSum = n;
        for (int i = dp.length; i > 1; i--) {
            // get possible number of least squares if 
            // case I: we consider i^2
            // case II: do not consider i^2
            int currSq = (i*i);
            int totalSqNum = reqSum / currSq + dp[i-2][reqSum % currSq];

            if (totalSqNum == solution) {
                // include current square in solution
                expression += (reqSum / currSq) + " x " + currSq  + " + ";
                solution -= (reqSum / currSq);
                reqSum %= currSq;
            }
        }

        return expression;
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
            System.out.println("Perfect Square Sum: " + getPerfectSquareSum(n));
        }

        sc.close();
    }
    
}
