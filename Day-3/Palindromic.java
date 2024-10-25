import java.util.Scanner;

public class Palindromic {

	/**
	* Checks if given string is palindrome or not
	* @param s: given string (can be either word or sentence)
	*/
	public static boolean isPalindrome(String s) {
		for (int i = 0, j = s.length()-1; i <= j; i++, j--) {
			// System.out.printf("Comparing %c and %c\n", s.charAt(i), s.charAt(j));
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		
		return true;
	}
	
	/**
	* Checks if given word list is palindrome or not
	* @param s: given string (can be either word or sentence)
	*/
	public static boolean isPalindrome(String[] wordlist) {
		for (int i = 0, j = wordlist.length-1; i <= j; i++, j--) {
			// System.out.printf("Comparing %s and %s\n", wordlist[i], wordlist[j]);
			if (!(wordlist[i].equalsIgnoreCase(wordlist[j]))) return false;
		}
		
		return true;
	}

	/**
	* Main driver program
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a sentence: ");
		String sentence = sc.nextLine();
		
		String[] wordlist = sentence.split(" ");
		String joinedSentence = String.join("", wordlist);
		
		boolean wordWise = isPalindrome(wordlist), charWise = isPalindrome(joinedSentence);

		if (charWise)
			System.out.println("Character-wise palindrome");
		if (wordWise)
			System.out.println("Word-wise palindrome");
		if (!wordWise && !charWise)
			System.out.println("Not palindrome in any sense");
		
		sc.close();
	}
}
