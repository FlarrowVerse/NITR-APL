import java.util.Scanner;

public class EatChocolate {
    /**
     * Eat chocolate function
     */
    public static int eat(int N, int k) {
        if (k == 0) {
            if (N == 0)
                return 1;
            else if (N > 0 || N < 0)
                return 0;
        }
        return eat(N - 1, k - 1) + eat(N - 2, k - 1) + eat(N - 3, k - 1);
    }

    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates to eat: ");
        int N = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of days to eat the chocolates: ");
        int k = sc.nextInt();
        sc.nextLine();
        int count = 0; // count of ways
        count = eat(N - 1, k - 1) + eat(N - 2, k - 1) + eat(N - 3, k - 1);
        System.out.println("Number of ways to eat: " + count);
        sc.close();
    }
}