package code.golf;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;

public class Gulf_Stock {

	private static ArrayList<Card> stock;

	public Gulf_Stock() {
		Deck deck = new Deck();
		ArrayList<Card> allcards = deck.getCards();

		ArrayList<Card> list = new ArrayList<>();
		for (Card i : list ) {
			
		}


	}
	public void RemoveCard () {
		stock.remove(0);
	}

	public boolean addCard () {
		return false;
	}
}





/*
Initial setup
The stock pile contains all of the cards except those dealt to a tableau pile.
Removing a Card
Only the card which is currently at the top of the stock pile can be removed.
 Once a card is removed, the card following it in the pile becomes the top card and would be legal to remove.
Adding a Card
Once the initial setup is complete, cards cannot be added to a tableau pile

 */