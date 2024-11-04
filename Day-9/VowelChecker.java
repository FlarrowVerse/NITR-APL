import java.util.Scanner;

class NoVowelException extends Exception {

    /**
     * parameterized constructor with custom error message
     * @param message error message
     */
    public NoVowelException(String message) {
        super(message);
    }
}

public class VowelChecker {

    /**
     * The method that throws exceptions
     * @param str string to be checked
     * @throws NoVowelException
     */
    public static void checkVowel(String str) throws NoVowelException {
        if ("aeiouAEIOU".indexOf(str) == -1) {
            throw new NoVowelException(String.format("Exception: %s does not contain any vowel!", str));            
        } else {
            System.out.printf("%s contains vowels.\n", str);
        }
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        try {
            checkVowel(sc.nextLine());
        } catch (NoVowelException e) {
            System.err.println(e.getMessage());
        }

        sc.close();
    }
    
}
