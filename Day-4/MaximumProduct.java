import java.util.Scanner;

public class MaximumProduct {

    public static String getMaximumProduct(int n) {

        int[] dp = new int[n+1]; // tabulization table
        String[] expressions = new String[n+1];

        /*
         * dp[i] = what is the maximum product attained by breaking i into parts
         */
        dp[0] = 1; dp[1] = 1;
        expressions[0] = " 0 "; expressions[1] = " 1 ";

        for (int i = 2; i <= n; i++) {
            // finding max product for each i based on all the products till i-1
            for (int j = 1; j < i; j++) {
                // for each j either
                // case I: break i into j and (i-j)                
                // case II: break i into j and parts of(i-j)
                if (dp[i] > Math.max(j * (i-j), j * dp[i-j])) {
                    continue;
                } else {
                    if ((j * (i-j)) >= (j * dp[i-j])) {
                        expressions[i] = " " + j + " + " + (i-j) + " ";
                    } else {
                        expressions[i] = " " + j + " +" + expressions[i-j];
                    }
                }

                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
            }            
        }

        System.out.println(dp[n]);

        // for (String string : expressions) {
        //     System.out.println(string);            
        // }
        
        return expressions[n];
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
            System.out.println("Sum with Maximum Product: " + getMaximumProduct(n));
        }

        sc.close();
    }
    
}

