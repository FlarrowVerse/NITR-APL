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
        boolean contains = false;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                contains = true;
                break;
            }
        }
        if (!contains)
            throw new NoVowelException(String.format("Exception: %s does not contain any vowel!", str));            
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
            System.out.println("String contains vowels");
        } catch (NoVowelException e) {
            System.err.println(e.getMessage());
        }

        sc.close();
    }
    
}
