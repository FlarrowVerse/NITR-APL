import java.util.Scanner;

public class Divisibility {

    /**
     * Given a number returns number of integers less than or equal to num that are divisble by
     * exactly one of 4, 6, 10
     * @param num
     * @return count
     */
    public static int getDivisibles(int num) {
        int count = 0;

        count += (Math.round(num / 4.0)) + (Math.round(num / 6.0)) + (Math.round(num / 10.0));
        count -= (Math.round(num / 12.0)) + (Math.round(num / 30.0)) + (Math.round(num / 20.0));
        count += (Math.round(num / 60.0));
        return count;
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n > 0) {
            System.out.printf("Number of integers in [1, %d] divisible by exactly one of 4, 6, 10 is %d\n", n, getDivisibles(n));
        } else {
            System.out.println("The number you entered is invalid.");
        }


        sc.close();
    }
}
