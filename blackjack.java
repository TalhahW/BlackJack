package consoleJack;

import java.util.ArrayList;
import java.util.Scanner;

public class blackjack {
	
	
	/*
	 * METHOD NAME: setInfo
	 * PURPOSE: 	to set various info about the player such as the name, and betting amount
	 * PARAMETERS:	p - Player - the player
	 * 				Account - double - the amount of money the player has in their account
	 * RETURN: 		nothing - void
	 */
	public static void setInfo(Player p, double Account){
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n" + p.getName() + "'s bank account: $" + Account +"\n");
		
		p.bank.setBettingAmnt(p.getName());
		
		double Bet = p.getBettingAmnt();
		
		while(Bet > Account){
				System.out.println("You cant bet more than you have. Try again.");
				Bet = input.nextDouble();
				}
		
	}
	
	/*
	 * METHOD NAME: HitOrStand
	 * PURPOSE: 	to check whether the player wants to hit (add a card to their hand) or stand (leave their hand unchanged)
	 * PARAMETERS:	none
	 * RETURN: 		boolean - true/false - return true if user hits; false if user stands
	 */
	public static boolean HitOrStand(){
		
		
		Scanner input = new Scanner(System.in);
		int choice;
		System.out.println("Do you want to hit(1) or stand(2)");
		choice = input.nextInt();
		
		if(choice ==1){
			return true;
			
		}
		else
			return false;
			
			
		
	}
	
	/*
	 * METHOD NAME: Round
	 * PURPOSE: 	runs the functions for a players turn
	 * PARAMETERS:	name - String - the player's name
	 * 				p - Player - the player
	 * 				d - deck - the player's hand
	 * 				stand - int - 0 until player decides to stand.
	 * 				score - int - the player's current score
	 * 				bust - int - 0 until player busts (gets over 21)
	 * RETURN: 		returns 0 if player doesn't bust
	 * 				returns 1 if player busts
	 */
	public static int Round (String name, Player p, Deck d, int stand, int score, int bust){

		bust =0;
		
		for (int i=0; i<p.hand.getSize();i++){
					p.hand.removeCard(i);
					}
		
		p.hand.drawCard(d, p.hand);
		p.hand.drawCard(d, p.hand);

		System.out.println(name + ": your turn.");
		
		
		score = p.hand.cardVal();
		

		
		System.out.println(p.hand.toString());
		
		System.out.println(name+ " SCORE:" + score);
		
		while(stand == 0 && bust == 0){
			
			
			if(p.hand.cardVal()>21){
				System.out.println("YOU BUST"+"\n*********************************\n");
				return 1;
			}
			
			if(HitOrStand() == true){
				p.hand.drawCard(d, p.hand);
				System.out.println(p.hand.toString());
				score =  p.hand.cardVal();
				System.out.println(name + " score:" + score);
			}
			else{
				System.out.println(name + " stands with a score of: " + score);
				stand =1;
			}
			
				System.out.println();
				
				}
		
		return 0;
	}
	
	/*
	 * METHOD NAME: checkResult
	 * PURPOSE: 	to check the result of the round and its winner
	 * PARAMETERS:	p1 - Player - player 1
	 * 				p2 - Player - player 2
	 * 				bust1 - int - the result of method 'Round' which determines whether player 1 busted or not
	 * 				bust2 - int - the result of method 'Round' which determines whether player 2 busted or not
	 * RETURN: 		result - int - the result of the round
	 */
	public static int checkResult(Player p1, Player p2,int bust1, int bust2){
		int result = 0;
		 
		if((p1.hand.cardVal() == p2.hand.cardVal()) ){
			System.out.println("Push.");
			return result =3;
		}
		
		else if((p1.hand.cardVal()> p2.hand.cardVal()) && (bust1 ==0)){
			System.out.println(p1.getName() + " wins the round"+"\n");
			return result =1;
		}
		
		else if ((p2.hand.cardVal()>p1.hand.cardVal())&& bust2 ==1){
			System.out.println(p1.getName() + " wins the round"+"\n");
			return result =1;
		}
		
		else if ((p2.hand.cardVal()>p1.hand.cardVal())&& bust2 ==0){
			System.out.println(p2.getName() + " wins the round"+"\n");
			return result =2;
		}
		
		else if((p1.hand.cardVal()> p2.hand.cardVal()) && (bust1 ==1)){
			System.out.println(p2.getName()+" wins the round" +"\n");
			return result =2;
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		System.out.println("\t"+"Welcome to BLACKJACK!");
		System.out.println("Created by: Arshad Mohamed and Talhah Wahab");
		System.out.println("********************************************");
		System.out.println("Rules: Closest player to 21 points wins!"+"\n"+"But make sure you dont go over or else you BUST!"+"\n");
		
		System.out.println("	POINTS SYSTEM");
		System.out.println("	*************");
		System.out.println("\t"+"ACE - 1 point");
		System.out.println("\t"+"TWO - 2 points");
		System.out.println("\t"+"THREE - 3 points");
		System.out.println("\t"+"FOUR - 4 points");
		System.out.println("\t"+"FIVE - 5 points");
		System.out.println("\t"+"SIX - 6 points");
		System.out.println("\t"+"SEVEN - 7 points");
		System.out.println("\t"+"EIGHT - 8 points");
		System.out.println("\t"+"NINE - 9 points");
		System.out.println("\t"+"TEN - 10 points");
		System.out.println("\t"+"JACK - 10 points");
		System.out.println("\t"+"QUEEN - 10 points");
		System.out.println("\t"+"KING - 10 points"+"\n");
		
		Scanner input = new Scanner(System.in);
		
		//String p1Name, p2Name;
		
		Player player1 = new Player();

		Player player2 = new Player();
		
		
		Deck playingDeck = new Deck();
		
		int score1 =0, score2 =0;
		
		double Account1= player1.bank.getAccount();
		double Account2= player2.bank.getAccount();
		
		System.out.println("PLAYER 1: ");
		player1.setName();
		
		System.out.println("PLAYER 2: ");
		player2.setName();
		
	
		while((Account1 > 0) && (Account2 > 0)){
			int stand1 = 0;
			int stand2 = 0;
			int bust1= 0;
			int bust2=0;
			int result = 0;
			
			
			playingDeck.makeDeck();
			playingDeck.shuffleDeck();
			
			
			setInfo(player1, Account1);
			
			setInfo(player2, Account2);
			
			for (int i=0; i<player1.hand.getSize();i++){
				player1.hand.removeCard(i);
				}
			
			for (int j=0; j<player2.hand.getSize();j++){
				player2.hand.removeCard(j);
				}
			
			bust1 = Round(player1.getName(),player1, playingDeck, stand1, score1, bust1);
			
			bust2 = Round(player2.getName(),player2, playingDeck, stand2, score2, bust2);
			
			result = checkResult(player1, player2, bust1, bust2);
			
			System.out.println("**********************************" + "\n"+ "***********ROUND OVER*************" + "\n" +"**********************************");
			
			
			if(result ==1){
				Account1 += player2.getBettingAmnt();
				Account2 -= player2.getBettingAmnt();
			}
			else if (result == 2){
				Account2 += player1.getBettingAmnt();
				Account1 -= player1.getBettingAmnt();
			}
			else if (result == 3 ){
			}
			
			
			for (int m=0; m<player1.hand.getSize();m++){
				player1.hand.removeCard(m);
				}
			
			for (int n=0; n<player2.hand.getSize();n++){
				player2.hand.removeCard(n);
				}
			
			
	}
		
		if(Account1 <= 0){
			System.out.println("\n"+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n"+"GAME OVER!!!!!" +player1.getName()+ " is bankrupt :(((" +"\n"+player2.getName()+ " is the winner!!!!!!!!!!!"+"\n"+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		else if (Account2 <=0 ){
			System.out.println("\n"+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n"+"GAME OVER!!!!!" +player2.getName()+ " is bankrupt :(((" +"\n"+player1.getName()+ " is the winner!!!!!!!!!!!"+"\n"+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		}
}
