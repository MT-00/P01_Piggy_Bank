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
import java.util.Arrays;

public class PiggyBankTester {
	/**
	 * Checks whether PiggyBank.getCoinName() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean getCoinNameTestMethod() {
		// change some coin values and names
		PiggyBank.COINS_NAMES[1] = "Two cents";
		PiggyBank.COINS_NAMES[3] = "Fifty Cents";
		PiggyBank.COINS_VALUES[1] = 2;
		PiggyBank.COINS_VALUES[3] = 50;
		// consider all coin values as input arguments
		for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
			if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
				return false;
		// consider input argument which does not correspond to a coin value
		if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
			return false;
		if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
			return false;
		return true;
	}

	/**
	 * Checks whether PiggyBank.getBalance() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean getBalanceTestMethod() {
		// scenario 1 - empty piggy bank
		int[] coins = new int[10]; // array storing the coins held in a piggy bank
		int size1 = 0; // number of coins held in coins array
		if (PiggyBank.getBalance(coins, size1) != 0) {// print out a warning if the two results are not matched
			System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
					+ "return the expected output when passed an empty piggy bank.");
			return false;
		}
		// scenario 2 - non empty piggy bank
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		size1 = 5;
		if (PiggyBank.getBalance(coins, size1) != 42) {
			System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
					+ "return the expected output when passed an piggy bank that holds "
					+ "two pennies, a nickel, a dime, and a quarter.");
			return false;
		}
		// scenario 3 - another non empty piggy bank
		coins = new int[] { 10, 1, 5, 25, 1, 0 };
		size1 = 3;
		if (PiggyBank.getBalance(coins, size1) != 16) {
			System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
					+ "return the expected output when passed an piggy bank that holds "
					+ "a penny, a nickel, and a dime, only.");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether PiggyBank.getSpecificCoinCount() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean getSpecificCoinCountTestMethod() {
		// scenario 1 - empty piggy bank
		int coinValue = 10;// count the number of dimes in the array
		int[] coins = new int[10]; // array storing the coins held in a piggy bank
		int size2 = 0; // number of coins held in coins array
		if (PiggyBank.getSpecificCoinCount(coinValue, coins, size2) != 0) {// print out a warning if the two results are
																			// not matched
			System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCountTestMethod() did not "
					+ "return the expected output when passed an empty piggy bank.");
			return false;
		}
		// scenario 2 - non empty piggy bank
		coinValue = 1;
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		size2 = 5;
		if (PiggyBank.getSpecificCoinCount(coinValue, coins, size2) != 2) {
			System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCountTestMethod() did not "
					+ "return the expected output when passed an piggy bank that holds "
					+ "two pennies, a nickel, a dime, and a quarter.");
			return false;
		}
		// scenario 3 - another non empty piggy bank
		coinValue = 1;
		coins = new int[] { 10, 1, 5, 25, 1, 0 };
		size2 = 3;// ignore the elements following the third elements in the array
		if (PiggyBank.getSpecificCoinCount(coinValue, coins, size2) != 1) {
			System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCountTestMethod() did not "
					+ "return the expected output when passed an piggy bank that holds "
					+ "a penny, a nickel, and a dime, only.");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether PiggyBank.addCoin() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean addCoinTestMethod() {

		// scenario 1 - wrong coin
		int[] coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };// set the initial coins array
		int size3 = 2;// set the size
		int coin = 3;// set the input coin
		if (PiggyBank.addCoin(coin, coins, size3) != 2) {// check if the result matches the correct answer
			System.out.println("Problem detected. PiggyBank.addCoin() did not return expected output.");// if not, print
																										// out a warning
																										// message
			return false;
		}

		// scenario 2 - full array
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		coin = 5;
		size3 = 7;
		if (PiggyBank.addCoin(coin, coins, size3) != 7) {
			System.out.println("Problem detected. PiggyBank.addCoin() did not return expected output.");
			return false;
		}

		// scenario 3 - added successfully
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		size3 = 3;
		if (PiggyBank.addCoin(coin, coins, size3) != 4) {
			System.out.println("Problem detected. PiggyBank.addCoin() did not return expected output.");
			return false;
		}

		// scenario 4 - added successfully
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		size3 = 5;
		if (PiggyBank.addCoin(coin, coins, size3) != 6) {
			System.out.println("Problem detected. PiggyBank.addCoin() did not return expected output.");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether PiggyBank.removeCoin() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean removeCoinTestMethod() {
		// scenario 1 - empty array
		int[] coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };// set a coins array
		int size4 = 0;// set the size
		if (PiggyBank.removeCoin(coins, size4) != 0) {// check if the method works well
			System.out.println("Problem detected. PiggyBank.removeCoin() did not return expected output.");// if not, print
																										// out a warning
																										// message
			return false;
		}
		// scenario 2 - removed successfully
		size4 = 7;
		coins = new int[] { 10, 1, 5, 25, 1, 1,5};
		size4 = PiggyBank.removeCoin(coins, size4);
		if (size4 != 6) {
			System.out.println("Problem detected. PiggyBank.removeCoin() did not return expected output.");
			return false;
		}
		// scenario 3 - removed successfully
		size4 = 3;
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		size4 = PiggyBank.removeCoin(coins, size4);
		if (size4 != 2) {
			System.out.println("Problem detected. PiggyBank.removeCoin() did not return expected output.");
			return false;
		}
		return true;

	}

	/**
	 * Checks whether PiggyBank.emptyPiggyBank() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean emptyPiggyBankTestMethod() {
		// scenario 1 - empty array
		int[] coins = new int[10];// set a coins array
		int size5 = 0;// set the size
		if (PiggyBank.emptyPiggyBank(coins, size5) != 0) {// check if the method works well
			System.out.println("Problem detected. PiggyBank.emptyPiggyBank() did not return expected output.");// if
																												// not,
																												// print
																												// our a
																												// warning
																												// message
			return false;
		}
		// scenario 2 - array with coins
		coins = new int[] { 10, 1, 5, 25, 1, 0, 0 };
		size5 = 5;
		if (PiggyBank.emptyPiggyBank(coins, size5) != 0) {
			System.out.println("Problem detected. PiggyBank.emptyPiggyBank() did not return expected output.");
			return false;
		}
		// scenario 3 - array with coins
		coins = new int[] { 10, 5, 1, 25, 25, 25, 5};
		size5 = 7;
		if (PiggyBank.emptyPiggyBank(coins, size5) != 0) {
			System.out.println("Problem detected. PiggyBank.emptyPiggyBank() did not return expected output.");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether PiggyBank.emptyPiggyBank() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean withdrawTestMethod() {

		// scenario 1 - exceeds amount
		int[] coins = new int[] { 25, 1, 5, 10, 1, 5, 25, 0, 0 };// set the initial coins array
		int size6 = 7;// set the size
		int amount = 80;// set the amount
		int[] expected = new int[] { 7, 0, 0, 0, 0 };// set the expected return
		if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size6), expected)) {// check if the method returns the
																					// correct result
			System.out.println("Problem detected. PiggyBank.withdraw() did not return expected output.");// if not,
																												// print
																												// out a
																												// warning
																												// message
			return false;
		}

		// scenario 2 - withdraw the entire amount
		coins = new int[] { 25, 1, 5, 10, 1, 5, 25, 0, 0 };
		amount = 72;
		expected = new int[] { 0, 2, 1, 2, 2 };
		if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size6), expected)) {
			System.out.println("Problem detected. PiggyBank.withdraw() did not return expected output.");
			return false;
		}

		// scenario 3 - exact change
		coins = new int[] { 25, 1, 5, 10, 1, 5, 25, 0, 0 };
		amount = 35;
		expected = new int[] { 5, 1, 1, 0, 0 };
		if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size6), expected)) {
			System.out.println("Problem detected. PiggyBank.withdraw() did not return expected output.");
			return false;
		}

		// scenario 4 - no exact change available
		coins = new int[] { 25, 1, 5, 10, 1, 5, 25, 0, 0 };
		amount = 69;
		expected = new int[] { 2, 2, 1, 2, 0 };
		if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size6), expected)) {
			System.out.println("Problem detected. PiggyBank.withdraw() did not return expected output.");
			return false;
		}
		return true;
	}

	/**
	 * Calls the test methods implemented in this class and displays their output
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
		System.out.println("getBalanceTest(): " + getBalanceTestMethod());
		System.out.println("getSpecificCoinCountTest(): " + getSpecificCoinCountTestMethod());
		System.out.println("removeCoinTest(): " + removeCoinTestMethod());
		System.out.println("emptyPiggyBankTest(): " + emptyPiggyBankTestMethod());
		System.out.println("withdrawTest(): " + withdrawTestMethod());

	}
}
