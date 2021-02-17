package consoleJack;

import java.util.Scanner;

/**
 * The BankAccount Class.
 */
public class BankAccount {

	/** The Account. */
	private double Account;
	
	/** The Bet. */
	private double Bet;
	
	/** The Bowl. */
	private double Bowl;
	
	/**
	 * Instantiates a new bank account.
	 *
	 * @param a the account
	 * @param b the bet amount
	 * @param c the betting bowl (both player's bets)
	 */
	public BankAccount(double a, double b, double c){
		this.Account = a;
		this.Bet = b;
		this.Bowl = c;
		
	}
	
	/**
	 * Sets the betting amount. Asks the user for the betting amount in the method
	 *
	 * @param name the name of the player
	 * 
	 */
	public void setBettingAmnt(String name){
		Scanner input = new Scanner (System.in);
		System.out.println("How much will you like to bet " + name + "(min. $50):");
		Bet = input.nextDouble();
		
	}
	
	/**
	 * Gets the betting amount.
	 *
	 * @return Bet the betting amount
	 */
	public double getBettingAmnt(){
		return Bet;
	}
	
	/**
	 * Gets the players bank account.
	 *
	 * @return Account the bank account
	 */
	public double getAccount(){
		return Account;
	}
	
	
	/**
	 * Adds the betting bowl to the account.
	 *
	 * @return Account the updated account
	 */
	public double addAccount(){
		return Account + Bowl;
	}
	
	/**
	 * Subtract the betting bowl from the account.
	 *
	 * @return Account the updated account
	 */
	public double subtractAccount(){
		return Account - Bet;
	}
	
}
