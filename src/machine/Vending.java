package machine;

import java.util.ArrayList;
import java.util.List;

public class Vending {
	public static void main(String[] args) {
		System.out.println("Calculating Appropriate Change");
		List<Double> enteredCoins = new ArrayList<Double>();
		enteredCoins.add(4.0);
		List<Integer> numOfCoins = makeChange(3.83, enteredCoins);
		System.out.println(numOfCoins.toString());
		System.out.println("# of Quarters:" + numOfCoins.get(3));
		System.out.println("# of Dimes:" + numOfCoins.get(2));
		System.out.println("# of Nickels:" + numOfCoins.get(1));
		System.out.println("# of Pennies:" + numOfCoins.get(0));
	}
	
	public static List<Integer> makeChange(double price, List<Double> coins) {
		List<Integer> returnChange = new ArrayList<Integer>();
		
		double totalAmount = 0;
		for (int i = 0; i < coins.size(); i++) {
			totalAmount += coins.get(i);
		}
		double change = totalAmount - price;

		int numOfQuarters = (int)(change / .25);
		double remainder = change - (numOfQuarters * .25);

		int numOfDimes = (int)((Math.round(remainder * 100.0) /100.0) / .10);
		remainder = remainder - (numOfDimes * .1);


		int numOfNickels = (int)((Math.round(remainder * 100.0) /100.0) / .05);
		remainder = remainder- (numOfNickels * .05);

		//Now Pennies
		int numOfPennies = (int)((Math.round(remainder * 100.0) /100.0) / .01);
		
		returnChange.add(numOfPennies);
		returnChange.add(numOfNickels);
		returnChange.add(numOfDimes);
		returnChange.add(numOfQuarters);
	
		return returnChange;
	}
}
