
//////////////// FILE HEADER  //////////////////////////
//
// Title:   P01 Piggy Bank
// Files:   PiggyBank, PiggyBankDriver, PiggyBankTester
// Course:  CS300,Spring, 2020
//
// Author:  Meng Tian
// Email:   mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    Yuliang Peng
// Partner Email:   peng68@wisc.edu
// Partner Lecturer's Name: Gary Dahl
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __x_ Write-up states that pair programming is allowed for this assignment.
//   __x_ We have both read and understood the course Pair Programming Policy.
//   __x_ We have registered our team prior to the team registration deadline.
import java.util.Random;

public class PiggyBank {
	public final static int[] COINS_VALUES = { 1, 5, 10, 25 }; // coins values in cents
	public final static String[] COINS_NAMES = { "PENNY", "NICKEL", "DIME", "QUARTER" }; // coins names
	public final static String NO_SUCH_COIN = "N/A"; // N/A string
	private final static Random RAND_GEN = new Random(100); // generator of random integers

	/**
	 * Returns the name of a specified coin value
	 * 
	 * @param coin represents a coin value in cents.
	 * @return the String name of a specified coin value if it is valid and N/A if
	 *         the coin value is not valid
	 */
	public static String getCoinName(int coin) {

		if (coin == COINS_VALUES[3]) {
			return COINS_NAMES[3];
		} else if (coin == COINS_VALUES[2]) {
			return COINS_NAMES[2];
		} else if (coin == COINS_VALUES[1]) {
			return COINS_NAMES[1];
		} else if (coin == COINS_VALUES[0]) {
			return COINS_NAMES[0];
		} else {
			return NO_SUCH_COIN;
		}
	}

	/**
	 * Returns the balance of a piggy bank in cents
	 * 
	 * @param coins an oversize array which contains all the coins held in a piggy
	 *              bank
	 * @param size  the total number of coins stored in coins array
	 * @return the total value of the coins held in a piggy bank in cents
	 */
	public static int getBalance(int[] coins, int size) {
		int totalValue;
		int numQuarters = 0;
		int numDimes = 0;
		int numNickels = 0;
		int numPennys = 0;

		for (int i = 0; i < size; i++) // check all coins stored in the array
		{
			if (coins[i] == 25) {// if the value of the coin is 25
				numQuarters = numQuarters + 1;// the number of quarters will add one
			}
			if (coins[i] == 10) {// if the value of the coin is 10
				numDimes = numDimes + 1;// the number of dimes will add one
			}
			if (coins[i] == 5) {// if the value of the coin is 5
				numNickels = numNickels + 1;// the number of nickels will add one
			}
			if (coins[i] == 1) {// if the value of the coin is 1
				numPennys = numPennys + 1;// the number of pennies will add one
			}
		}
		totalValue = 25 * numQuarters + 10 * numDimes + 5 * numNickels + 1 * numPennys;// compute the balance
		return totalValue;
	}

	/**
	 * Returns the total number of coins of a specific coin value held in a piggy
	 * bank *
	 * 
	 * @param coinValue the value of a specific coin
	 * @param coins     an oversize array which contains all the coins held in a
	 *                  piggy bank
	 * @param size      the total number of coins stored in coins array
	 * @return the number of coins of value coinValue stored in the array coins
	 */
	public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
		int i;
		int num = 0;

		for (i = 0; i < size; i++) {// check all coins stored in the array
			if (coins[i] == coinValue) {// check if there is a matched coin value
				num = num + 1;// if there is, then the number of that coin will add one
			}
		}
		return num;
	}

	/**
	 * Displays information about the content of a piggy bank
	 *
	 * @param coins an oversize array storing the coins held in a piggy bank
	 * @param size  number of coin held array coins
	 */
	public static void printPiggyBank(int[] coins, int size) {
		System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
		System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
		System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
		System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
		System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
	}

	/**
	 * Adds a given coin to a piggy bank. This operation can terminate successfully
	 * or unsuccessfully. For either cases, this method displays a descriptive
	 * message for either cases.
	 *
	 * @param coin  the coin value in cents to be added to the array coins
	 * @param coins an oversize array storing the coins held in a piggy bank
	 * @param size  the total number of coins contained in the array coins before
	 *              this addCoin method is called.
	 * @return the new size of the coins array after trying to add coin.
	 */
	public static int addCoin(int coin, int[] coins, int size) {
		String newCoin = "";
		newCoin = getCoinName(coin);

		if (newCoin == NO_SUCH_COIN) {// check if the input value is valid
			System.out.print("" + coin + " cents is not a valid US currency coin.\n");// if not, print a warning message

		} else if (coins.length <= size) {// check if the array is full
			System.out.print("" + "Tried to add a " + newCoin + ", but could not because the piggy bank is full.\n");// if
																														// it
																														// is,
																														// print
																														// a
																														// warning
																														// message
		} else {
			coins[size] = coin;// otherwise, the new coin is added in the following site of the previous stored
								// coin, which is the spot "size - 1"
			size = size + 1;// the total number of the coins stored will add one more
			System.out.print("" + "Added a " + newCoin + ".\n");// print out a message to notify the user

		}
		return size;
	}

	/**
	 * Removes an arbitrary coin from a piggy bank. This method may terminate
	 * successfully or unsuccessfully. In either cases, a descriptive message is
	 * displayed.
	 *
	 * @param coins an oversize array which contains the coins held in a piggy bank
	 *              *
	 * @param size  the number of coins held in the coins array before this method
	 *              is called
	 * @return the size of coins array after this method returns successfully
	 */
	public static int removeCoin(int[] coins, int size) {
		int r;
		int i;
		boolean target;
		int remCoinValue;
		String remCoinName;
		if (size == 0) {// check if there is any coin stored
			System.out.print("Tried to remove a coin, but could not because the piggy bank is empty.\n");// if it is
																											// empty,
																											// print out
																											// a warning
																											// message
		} else {
			r = RAND_GEN.nextInt(size);// generate a random site of the array
			remCoinValue = coins[r];// find the value of that coin
			remCoinName = getCoinName(remCoinValue);// find the name of that coin
			coins[r] = 0;// assign the coin value to 0
			// refill the empty spot
			target = false;// set the signal to false first
			for (i = 0; i < size; i++) {// go over all coins stored in the array
				if (target) {// check if the signal is true
					for (int index2 = i; index2 < size; index2++)// check where is the next nonzero elements
					{
						if (coins[index2] != 0)// if the nonzero elements is founded
						{
							// change the spot of these two elements
							int sub = coins[i - 1];
							coins[i - 1] = coins[index2];
							coins[index2] = sub;
						}
					} // if it is, then the following coins move one step forward
				}
				if (coins[i] == 0) {// check if the coin value is 0
					target = true;// if it is, then the target changes to true
				}
			}
			size = size - 1;// the number of coins held decreases 1
			System.out.print("Removed a " + remCoinName + ".\n");// print out a notice
		}
		return size;
	}

	/**
	 * Removes all the coins in a piggy bank. It also displays the total value of
	 * the removed coins
	 *
	 * @param coins an oversize array storing the coins held in a piggy bank
	 *              application * @param size number of coins held in coins array
	 *              before this method is called
	 * @return the new size of the piggy bank after removing all its coins.
	 */

	public static int emptyPiggyBank(int[] coins, int size) {
		int sumRemoved;
		if (size == 0) {// check if there is any coins stored
			System.out.print("Zero coin removed. The piggy bank is already empty.\n");// if it is empty, print out a
																						// warning message
		} else {// if it is not empty
			sumRemoved = getBalance(coins, size);// calculate the sum of all coins
			coins = null;// empty the array
			size = 0;// the size is reset to 0
			System.out.print("All done. " + sumRemoved + " cents removed.\n");// print out a message to notify the user
		}
		return size;
	}

	/**
	 * Removes the least number of coins needed to fulfill a withdrawal request
	 *
	 * @param amount amount to withdraw given in cents
	 * @param coins  an oversize array storing the coins held in a piggy bank
	 * @param size   number of coins stored in coins array before this method is
	 *               called
	 * @return perfect size array of 5 elements, index 0 stores the new size of the
	 *         piggy bank after this method returns. Indexes 1, 2, 3, and 4 store
	 *         respectively the number of removed quarters, dimes, nickels, and
	 *         pennies.
	 */
	public static int[] withdraw(int amount, int[] coins, int size) {
		int currentCoins = getBalance(coins, size);
		int a = 0;
		int[] numQuarters = new int[1000];
		int[] numDimes = new int[1000];
		int[] numNickels = new int[1000];
		int[] numPennies = new int[1000];
		int numQuarters2 = getSpecificCoinCount(25, coins, size);
		int numDimes2 = getSpecificCoinCount(10, coins, size);
		int numNickels2 = getSpecificCoinCount(5, coins, size);
		int numPennies2 = getSpecificCoinCount(1, coins, size);
		int size2 = 0;
		int[] array = new int[1000];
		int[] output2 = { size, 0, 0, 0, 0 };

		if (currentCoins < amount) {// check if there is enough money to withdraw
			System.out.print("Unable to withdraw " + amount + " cents. NOT enough money in the piggy bank.\n");
			return output2;// if there is not enough money, print out a warning message
		} else {
			for (int i = numQuarters2; i >= 0; i--) {
				for (int j = numDimes2; j >= 0; j--) {
					for (int k = numNickels2; k >= 0; k--) {
						for (int m = numPennies2; m >= 0; m--) {
							array[size2] = i * 25 + j * 10 + k * 5 + m;// find all possible combinations of the coins
																		// stored and calculate the sum
							// size2 counts the number of combinations
							if (amount == array[size2]) {// compare the sum with the given amount
								numQuarters[a] = i;// if it is matched, store the number of quarters in the numQuarters
													// array
								numDimes[a] = j;// store the number of dimes in the numDimes array
								numNickels[a] = k;// store the number of nickels in the numNickels array
								numPennies[a] = m;// store the number of pennies in the numPennies array
								a++;// the stored spot adds one each time, which counts the number of matched
									// combinations
							}
							++size2;// the number of possible combinations adds one each time
						}
					}
				}
			}
// if all possible combination cannot match the exact amount the user inputed
			boolean target = false;// set a signal first
			if (a == 0) {
				while (target != true) {
					amount = amount + 1;// increase the amount at one each time to withdraw the least amount of money
					for (int i = numQuarters2; i >= 0; i--) {// find the all possible combinations match the new amount
						for (int j = numDimes2; j >= 0; j--) {
							for (int k = numNickels2; k >= 0; k--) {
								for (int m = numPennies2; m >= 0; m--) {
									array[size2] = i * 25 + j * 10 + k * 5 + m;
									if (amount == array[size2]) {
										numQuarters[a] = i;
										numDimes[a] = j;
										numNickels[a] = k;
										numPennies[a] = m;
										a++;// the stored spot adds one each time, which counts the number of matched
											// combinations
										target = true;
									}
									++size2;// the number of possible combinations adds one each time
								}
							}
						}
					}
				}
			}
			// find the combination that has the least number of coins
			int minSum = 10000;// set the initial least number of coins to 10000
			int e;
			int[] coinNum = new int[10000];
			int resultQ = 0;
			int resultD = 0;
			int resultN = 0;
			int resultP = 0;
			for (e = a - 1; e >= 0; e--) {
				coinNum[e] = numQuarters[e] + numDimes[e] + numNickels[e] + numPennies[e];
				if (coinNum[e] <= minSum) {// check if the combination has smaller number of coins than the minimum we
											// have so far
					minSum = coinNum[e];// if yes, replace the old minimum to the new one
					resultQ = numQuarters[e];// store the number of quarters it needed
					resultD = numDimes[e];// store the number of dimes it needed
					resultN = numNickels[e];// store the number of nickels it needed
					resultP = numPennies[e];// store the number of pennies it needed

				}
			}
			int originResultQ = resultQ;// store the original result of number of quarters
			int originResultD = resultD;// store the original result of number of dimes
			int originResultN = resultN;// store the original result of number of nickels
			int originResultP = resultP;// store the original result of number of pennies

			// print out the message to notify how much money they got
			while (resultQ != 0) {// the number of needed quarters equals the number of message needed to print
				System.out.print("Removed a QUARTER.\n");
				resultQ--;// number of needed quarters decreases one each time
			}
			while (resultD != 0) {// the number of needed dimes equals the number of message needed to print
				System.out.print("Removed a DIME.\n");
				resultD--;// number of needed dimes decreases one each time
			}
			while (resultN != 0) {// the number of needed nickels equals the number of message needed to print
				System.out.print("Removed a NICKEL.\n");
				resultN--;// number of needed nickels decreases one each time
			}
			while (resultP != 0) {// the number of needed pennies equals the number of message needed to print
				System.out.print("Removed a PENNY.\n");
				resultP--;// number of needed pennies decreases one each time
			}

			// replace all withdrawn coins by setting them to 0
			int b = originResultQ;
			for (int index = size - 1; index >= 0; index--) {// check all coins stored in the array
				if (b > 0) {// check if there is more quarters needed to be withdrew
					if (coins[index] == 25) {// check if the coins in the array is quarter
						coins[index] = 0;// if it is, set it to 0
						b--;// the number of needed quarters decreases one each time
					}

				}
			}

			b = originResultD;
			for (int index = size - 1; index >= 0; index--) {// check all coins stored in the array
				if (b > 0) {// check if there is more dimes needed to be withdrew
					if (coins[index] == 10) {// check if the coins in the array is dime
						coins[index] = 0;// if it is, set it to 0
						b--;// the number of needed dimes decreases one each time
					}

				}
			}

			b = originResultN;
			for (int index = size - 1; index >= 0; index--) {// check all coins stored in the array
				if (b > 0) {// check if there is more nickels needed to be withdrew
					if (coins[index] == 5) {// check if the coins in the array is nickel
						coins[index] = 0;// if it is, set it to 0
						b--;// the number of needed nickels decreases one each time
					}

				}
			}

			b = originResultP;
			for (int index = size - 1; index >= 0; index--) {// check all coins stored in the array
				if (b > 0) {// check if there is more pennies needed to be withdrew
					if (coins[index] == 1) {// check if the coins in the array is penny
						coins[index] = 0;// if it is, set it to 0
						b--;// the number of needed pennies decreases one each time

					}

				}
			}

			// move all 0 in the coins-array to the back and all existing coins forward
			target = false;// set the signal as false first
			for (int index2 = 0; index2 < size; index2++) {// check all coins in the array
				if (target == true) {// if the signal is true
					for (int index3 = index2; index3 < size; index3++)// check where is the next nonzero elements
					{
						if (coins[index3] != 0)// if the nonzero elements is founded
						{
							// change the spot of these two elements
							int sub = coins[index2 - 1];
							coins[index2 - 1] = coins[index3];
							coins[index3] = sub;
						}
					}
					target = false;// then set the signal back to zero again
				}
				if (coins[index2] == 0) {// if there is a 0 founded
					target = true;// set the signal to true
				}
			}

			size = size - originResultQ - originResultD - originResultN - originResultP;// the size of array will
																						// decrease as much as the
																						// number of coins withdrew
			int[] output = { size, originResultQ, originResultD, originResultN, originResultP };// return the output
			return output;
		}

	}
}
