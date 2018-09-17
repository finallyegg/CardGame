package code.littleSpider;
import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
//I extended the Deck class since I wanted to use the deal() method
public class Tableaus extends Deck{
	
	private ArrayList<Card> cardStack;
	private int cardsInStack;

	//everytime you deal a would be equal to that card delt
	public Tableaus(Card a, Card b, Card c, Card d, Card e, Card f) {
		cardStack.add(a);
		cardStack.add(b);
		cardStack.add(c);
		cardStack.add(d);
		cardStack.add(e);
		cardStack.add(f);	
		cardsInStack = cardStack.size();
	}
		
	
	/*this method checks the card numbers to see if the delt card is either greater than the Tableaus first card by one or less than the Tableaus first card 
	* by one. If it is then it will take that card a and put it into the Tableaus and become the first card.(I don't think we need a add card or remove
	* card since a = deal() which returns a card which means it removes a card from a deck and returns a card and this method checks that card and adds
	* it into the Tableaus. it would deal a new card and Card a would be that new value
	*/
	public boolean checkNumber() {
		if(cardStack.get(0).value() - 1 == a.value()  || cardStack.get(0).value() + 1 == a.value()) {
			cardStack.add(a);
			a = deal();
			return true;
		}
		else {
		return false;
		}
	}
	
	public boolean checkEmpty() {
		
		return false;
	}
	
	public void removeCard() {
		
		
	}
	public void addCard() {
		
	}

}


