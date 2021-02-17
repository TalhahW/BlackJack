package consoleJack;

/**
 * The Card Class.
 */
public class Card {

	/** The Value. */
	values Value;
	
	/** The Suit. */
	suits Suit;
	
	
	/**
	 * Instantiates a new card.
	 *
	 * @param aValue the value of the card
	 * @param aSuit the suit of the card
	 */
	public Card(values aValue, suits aSuit){
		this.Suit = aSuit;
		this.Value = aValue;
	}
	
	
	/** 
	 * Returns the card in String form (suit + value)
	 * 
	 *@return str the card (Suit + Value)
	 */
	public String toString(){
		String str;
		
		str = this.Suit.toString() + "-" + this.Value.toString();
		
		
		return str;
		
	}
	
	/**
	 * Gets the value of the card.
	 *
	 * @return numVal the value
	 */
	public values getValue (){
		values numVal;
		
		numVal = this.Value; 
		
		
		return numVal; 
	}
	
	
}