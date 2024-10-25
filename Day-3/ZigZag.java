import java.util.Scanner;

public class ZigZag {

	/**
	* Finds index till which it is increasing given a start index
	*/
	public static int isIncreasingTill(int[] list, int startIndex) {
		int endIndex = startIndex + 1;
		while(endIndex < list.length && list[endIndex - 1] < list[endIndex]) {
			endIndex++;
		}
		return (endIndex-1 != startIndex)? endIndex-1: -1;
	}
	
	/**
	* Finds index till which it is decreasing given a start index
	*/
	public static int isDecreasingTill(int[] list, int startIndex) {
		int endIndex = startIndex + 1;
		while(list[endIndex - 1] > list[endIndex]) {
			endIndex++;
		}
		return (endIndex-1 != startIndex)? endIndex-1: -1;
	}

	/**
	* Checks if an array is zigzag or not
	* @param a: array of integers
	*/
	public static boolean isZigZag(int[] a) {
		int i = isIncreasingTill(a, 0);
		// System.out.println(i);
		if (i == -1) return false;
		
		int j = isDecreasingTill(a, i);
		// System.out.println(j);
		if (j == -1) return false;
		
		int k = isIncreasingTill(a, j);
		// System.out.println(k);
		if (k == -1 || k != a.length-1) return false;
		
		return true;
	}

	/**
	* Main driver program
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of array elements: ");
		int n = sc.nextInt(); sc.nextLine(); // number of array elements
		
		System.out.println("Keep entering the array elements one by one: ");
		int[] a = new int[n];		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Given array is " + ((n > 4 && a[0] <= a[1] && isZigZag(a))?"zigzag.":"not zigzag."));
		
		sc.close();
	}
}
