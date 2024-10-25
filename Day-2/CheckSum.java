import java.util.Scanner;

public class CheckSum {
    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        sc.nextLine(); // reading till line end to avoid errors
        if (a + b == c)
            System.out.printf("%d + %d = %d\n", a, b, c);
        if (b + c == a)
            System.out.printf("%d + %d = %d\n", b, a, c);
        if (a + c == b)
            System.out.printf("%d + %d = %d\n", a, c, b);
        sc.close();
    }
}