package consoleJack;

import java.util.Scanner;

/**
 * The Class Player.
 */
public class Player {

	/** The player's name. */
	private String name;
	
	/** The player's bank account. */
	BankAccount bank;
	
	/** The player'shand. */
	Deck hand;
	
	/**
	 * Instantiates a new player (default constructor).
	 */
	public Player (){
		this.name = "";
		bank = new BankAccount(200,0,0);
		hand = new Deck();
	}
	
	/**
	 * Instantiates a new player.
	 *
	 * @param aName the player's name
	 * @param acc the player's account
	 * @param bet the player's bet
	 * @param bowl the betting bowl
	 */
	public Player (String aName, double acc, double bet, double bowl){
		this.name = aName;
		bank = new BankAccount(200,bet,bowl);
		hand = new Deck();
	}

	
	/**
	 * Sets the name.
	 */
	public void setName(){
		Scanner input = new Scanner (System.in);
		String x;
		System.out.println("What is your username: ");
		x = input.next();
		this.name =x;
	}
	
	/**
	 * Gets the player's name.
	 *
	 * @return this.name the player's name
	 */
	public String getName(){
		
		return this.name;
	}
	
	
	/**
	 * Gets the betting amount.
	 *
	 * @return the betting amount
	 */
	public double getBettingAmnt(){
		return bank.getBettingAmnt();
	}
	
	
	
	
}
