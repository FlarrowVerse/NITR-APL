import java.util.Scanner;

public class StockTrade {

	/**
	* Get maximum possible profit
	* @param stockPrices: list of stock prices
	* @param minPriceTill: stores the minimum price till an index
	*/
	public static int getProfit(int[] stocks, int[] minPriceTill) {
		int sellIndex = stocks.length - 1, buyPrice = minPriceTill[sellIndex-1];
		int maxProfit = stocks[sellIndex] - buyPrice; // init
		
		while (sellIndex > 1) {
			if (maxProfit < (stocks[sellIndex] - buyPrice)) {
				maxProfit = stocks[sellIndex] - buyPrice;
			}
			sellIndex--;
			buyPrice = minPriceTill[sellIndex - 1];
		}
		return maxProfit;
	}

	/**
	* Main driver program
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of stock prices to consider: ");
		int stocks = sc.nextInt(); sc.nextLine(); // reading number of stock prices
		
		System.out.println("Keep entering the stock prices one by one: ");
		int[] stockPrices = new int[stocks]; // stock prices
		int[] minPriceTill = new int[stocks]; // minimum stock price till an index for all indices

		for (int i = 0; i < stocks; i++) {
			stockPrices[i] = sc.nextInt();
			
			// maintaining a list of min stock prices till current index
			if (i == 0) minPriceTill[i] = stockPrices[i];
			else if (minPriceTill[i-1] > stockPrices[i]) {
				minPriceTill[i] = stockPrices[i];
			} else {
				minPriceTill[i] = minPriceTill[i-1];
			}
		}
		
		int profit = getProfit(stockPrices, minPriceTill);
		
		System.out.println(((profit < 0)?"Loss: Rs.": "Profit: Rs.")+ Math.abs(profit));
		
		sc.close();
	}
}
