package code.littleSpider;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.littleSpider.Tableaus;

public class Homecells {

	/**
	 * Create a new Card that needs to be initiated
	 */
	private Card card = new Card(null, null);

	/**
	 * Creates a new empty ArrayList of Cards
	 */
	private ArrayList<Card> cardStack;

	/**
	 * Initializes the HomeCells class
	 * 
	 * @param s Takes in a Card to add to the Homecell as the first card.
	 */
	public Homecells(Card s) {
		cardStack = new ArrayList<Card>();
		card = s;

		cardStack.add(card);

	}

	/**
	 * Checks if a card has the correct suit
	 * 
	 * @param c The card that needs to be checked against the Homecell's suit
	 * @return Whether the card is the same suit or not
	 */
	public boolean checkSuit(Card c) {

		if (cardStack.get(0).getSuit() == c.getSuit()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Checks if a card is able to be placed on a card on the Homecell
	 * 
	 * @param c The card that needs to be checked against another card already in
	 *          the Homecell
	 * @return Whether the card is valid to be placed on top of another
	 */
	public boolean checkNumber(Card c) {
		if (cardStack.get(0).value() == 14) {
			if (c.value() == 2 && (cardStack.get(0).getSuit() == c.getSuit())) {
				return true;
			} else if (cardStack.get(0).value() + 1 == c.value() && cardStack.get(0).getSuit() == c.getSuit()) {
				System.out.println("lol");
				return true;
			} else if (cardStack.get(0).value() == 13) {
				return false;
			} else
				return false;
		}
		if (cardStack.get(0).value() == 13) {
			if (cardStack.get(0).value() - 1 == c.value() && cardStack.get(0).getSuit() == c.getSuit()) {
				return true;
			} else if (cardStack.get(0).value() == 14) {
				return false;
			} else
				return false;
		}
		if (cardStack.get(0).value() + 1 == c.value() && cardStack.get(0).getSuit() == c.getSuit()) {
			return true;
		}
		if (cardStack.get(0).value() - 1 == c.value() && cardStack.get(0).getSuit() == c.getSuit()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if a Homecell is complete based on the starting card
	 * 
	 * @return Whether or not a Homecell is completed
	 */
	public boolean checkFinished() {
		if (cardStack.get(0).value() == 14) {
			if ((cardStack.get(cardStack.size() - 1).value() == 13)
					&& (cardStack.get(0).getSuit() == cardStack.get(cardStack.size() - 1).getSuit())) {
				return true;
			} else {
				return false;
			}
		} else if (cardStack.get(0).value() == 13) {
			if ((cardStack.get(cardStack.size() - 1).value() == 14)
					&& (cardStack.get(0).getSuit() == cardStack.get(cardStack.size() - 1).getSuit())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Removes a card if there is at least one card in the Homecell
	 */
	public void removeCard() {
		if (cardStack.size() > 1) {
			cardStack.remove(cardStack.size() - 1);
		}
	}

	/**
	 * Checks whether or not a card can be added to the Homecell Can add the card if
	 * it passes both checkNumber and checkSuit
	 * 
	 * @param c The card that needs to be checked if it can be added
	 * @return Whether or not the card can be added to the Homecell
	 */
	public boolean addCard(Card c) {
		if (checkNumber(c) && checkSuit(c)) {
			cardStack.add(c);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Forces a card to be added to a Homecell Primarily used to initialize the
	 * Homecell with the right card Can be used for testing purposes
	 * 
	 * @param c The card that is being forced to the Homecell
	 */
	public void alwaysAddCard(Card c) {
		cardStack.add(c);
	}

	/**
	 * Returns the number of cards in the Homecell
	 * 
	 * @return The number of cards in a homecell
	 */
	public int size() {
		return cardStack.size();
	}

	/**
	 * Get a card at a specified index
	 * 
	 * @param index The index requested
	 * @return The Card located at the specified index
	 */
	public Card getCard(int index) {
		return cardStack.get(index);
	}

	/**
	 * Checks whether or not a Card from the Homecell is able to be moved to a
	 * Tableau
	 * 
	 * @param t The Tableau that the Card is trying to move onto
	 * @return Whether or not the move is legal
	 */
	public boolean checkMoveToTableau(Tableaus t) {
		if (cardStack.size() > 1) {
			if (t.checkNumber(cardStack.get(cardStack.size() - 1))
					|| t.checkNumber(cardStack.get(cardStack.size() + 1))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Returns the ArrayList<Card> cardStack
	 * 
	 * @return cardStack the current list of Cards
	 */
	public ArrayList<Card> getHomecellStack() {
		return cardStack;
	}

	public int getInitialSize() {
		return 1;
	}

}
