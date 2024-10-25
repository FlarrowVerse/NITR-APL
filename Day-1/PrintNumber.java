import java.util.Scanner;

public class PrintNumber {

    /**
     * Used to print numbers in the range [10, 19]
     * @param num
     */
    public static void printCustom(int num) {
        switch (num % 10) {
            case 0: System.out.print("Ten"); break;
            case 1: System.out.print("Eleven"); break;
            case 2: System.out.print("Twelve"); break;
            case 3: System.out.print("Thirteen"); break;
            case 4: System.out.print("Fourteen"); break;
            case 5: System.out.print("Fifteen"); break;
            case 6: System.out.print("Sixteen"); break;
            case 7: System.out.print("Seventeen"); break;
            case 8: System.out.print("Eighteen"); break;
            case 9: System.out.print("Nineteen"); break;
        }
    }

    /**
     * Given a digit prints its equivalent in the ten's place
     * @param num
     */
    public static void printTensDigit(int num) {
        switch (num) {
            case 2: System.out.print("Twenty"); break;
            case 3: System.out.print("Thirty"); break;
            case 4: System.out.print("Fourty"); break;
            case 5: System.out.print("Fifty"); break;
            case 6: System.out.print("Sixty"); break;
            case 7: System.out.print("Seventy"); break;        
            case 8: System.out.print("Eighty"); break;
            case 9: System.out.print("Ninety"); break;
        }
    }

    /**
     * Given a digit prints its equivalent in the unit's place
     * @param num
     */
    public static void printUnitsDigit(int num) {
        switch (num) {
            case 1: System.out.print(" one"); break;
            case 2: System.out.print(" two"); break;
            case 3: System.out.print(" three"); break;
            case 4: System.out.print(" four"); break;
            case 5: System.out.print(" five"); break;
            case 6: System.out.print(" six"); break;
            case 7: System.out.print(" seven"); break;
            case 8: System.out.print(" eight"); break;
            case 9: System.out.print(" nine"); break;
        }
    }

    /**
     * Given a number prints it in words
     * @param num
     */
    private static void printNumberInWords(int num) {
        switch (num / 10) {
            case 1: printCustom(num); // print custom words for 10-19              
                break;        
            default: printTensDigit(num / 10);
                printUnitsDigit(num % 10);
                break;
        }
        System.out.println();
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number between 1 and 99 (both inclusive): ");
        int num = sc.nextInt(); // main input

        if (num >= 1 && num <= 99) {
            // valid input case
            printNumberInWords(num);
        } else {
            System.out.println("The number you entered is invalid. Try again.");
        }

        sc.close();
    }

    
}