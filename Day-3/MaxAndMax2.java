import java.util.Scanner;

public class MaxAndMax2 {

	/**
	* Main driver program
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of elements: ");
		int N = sc.nextInt(); // reading integer N
		
		int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE + 1; // values to store max and second max

        System.out.print("Enter array elements one by one: ");
		
		while (N-- > 0) {
			int num = sc.nextInt();
			
			if (num > max) {
				max2 = max;
				max = num;
			} else if (num > max2) {
				max2 = num;
			}
		}
		
		System.out.printf("In the given list of integers %d was the largest and %d was the second largest.\n", max, max2);
		
		sc.close();
	}
}
