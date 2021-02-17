package consoleJack;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck Class.
 */
public class Deck {
	
	/** The deck. */
	private ArrayList<Card> deck;
	
	/**
	 * Instantiates a new deck.
	 */
	public Deck(){
	 deck = new ArrayList <Card> ();
}
	
	/**
	 * Makes a deck of 52 cards.
	 */
	public void makeDeck(){
		
		for(suits s: suits.values()){
			for(values v: values.values()){
				deck.add(new Card(v,s));
			}
		}
		
	}
	
	/**
	 * Draw card.
	 *
	 * @param playingDeck the playing deck
	 * @param Hand the player's hand
	 * @return Hand the new player hand
	 */
	public Deck drawCard(Deck playingDeck, Deck Hand){
		 this.deck.add(playingDeck.deck.get(0));
		 playingDeck.deck.remove(0);
		 Hand.deck = this.deck;
		return Hand;	
	}
	
	
	//public void addCard(Card added){
	//	this.deck.add(added);
	//}
	
	
	/**
	 * Removes a card.
	 *
	 * @param num the index of the card to be removed
	 */
	public void removeCard(int num){
		this.deck.remove(num);
	}
	
	/**
	 * Shuffles deck.
	 */
	public void shuffleDeck(){
	Random random = new Random();
	ArrayList<Card> Temp = new ArrayList <Card>();
	
	int rand = 0;
	for(int i =0; i < 52; i++){
		
		rand = random.nextInt((this.deck.size()-1 -0)+1) + 0;
		Temp.add(this.deck.get(rand));
		this.deck.remove(rand);
	}
	
	this.deck = Temp;
		
	}
	
	/** 
	 * Returns the entire deck with each card object in it
	 * 
	 *@return str the deck
	 */
	public String toString (){
		String str = "";
		for (Card c : this.deck){
		str += c.toString() + "\n";
		}
	
		return str;
	}
	
	/**
	 * Assigns an integer value to each card, and adds them to get hand value.
	 *
	 * @return total the value in the deck(hand)
	 */
	public int cardVal(){
		int total = 0;
		
		for(Card val: this.deck){
		
			switch(val.getValue()){
			
			case TWO: total += 2; break;
			case THREE: total += 3; break;
			case FOUR: total += 4; break;
			case FIVE: total += 5; break;
			case SIX: total += 6; break;
			case SEVEN: total += 7; break;
			case EIGHT: total += 8; break;
			case NINE: total += 9; break;
			case TEN: total +=10; break;
			case JACK: total += 10; break;
			case QUEEN: total += 10; break;
			case KING: total += 10; break;
			case ACE: total += 1; break;
		}
		}
		
		
		return total;
	}
	
	/**
	 * Gets the size of the deck.
	 *
	 * @return size the deck size
	 */
	public int getSize(){
		int size = 0;
		
		size = this.deck.size();
		
		return size;
	}
	
	
}


