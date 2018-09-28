package code.littleSpider;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;

public class LittleSpider {
	
	/**
	 * Creates a new Deck that will be used for the game
	 */
	private Deck d = new Deck();
	
	/**
	 * ArrayLists of Card that will be put into the Tableaus
	 */
	private ArrayList<Card> a1 = new ArrayList<Card>();;
	private ArrayList<Card> b2 = new ArrayList<Card>();;
	private ArrayList<Card> c3 = new ArrayList<Card>();;
	private ArrayList<Card> d4 = new ArrayList<Card>();;
	private ArrayList<Card> e5 = new ArrayList<Card>();;
	private ArrayList<Card> f6 = new ArrayList<Card>();;
	private ArrayList<Card> g7 = new ArrayList<Card>();;
	private ArrayList<Card> h8 = new ArrayList<Card>();;
	
	/**
	 * Creates the 8 Tableaus needed for a LittleSpider game
	 * Initialized later on
	 */
	private Tableaus t1;
	private Tableaus t2;
	private Tableaus t3;
	private Tableaus t4;
	private Tableaus t5;
	private Tableaus t6;
	private Tableaus t7;
	private Tableaus t8;
	
	/**
	 * Creates the 4 Homecells needed for a LittleSpider game
	 */
	private Homecells h1 = new Homecells(null);
	private Homecells h2 = new Homecells(null);
	private Homecells h3 = new Homecells(null);
	private Homecells h4 = new Homecells(null);
	
	/**
	 * Creates the Cards that need to be removed from deck to initialize
	 * the homecells
	 */
	private Card ah = new Card(Ranks.ACE, Suits.HEARTS);
	private Card ad = new Card(Ranks.ACE, Suits.DIAMONDS);
	private Card ks = new Card(Ranks.KING, Suits.SPADES);
	private Card kc = new Card(Ranks.KING, Suits.CLUBS);
	
	/**
	 * Initializes all the Homecells with the appropriate starting card
	 * h1 has the Ace of Hearts
	 * h2 has the Ace of Diamonds
	 * h3 has the King of Spades
	 * h4 has the King of Clubs
	 * 
	 * The Deck should now have 48 cards left
	 */
	public LittleSpider() {
		h1.alwaysAddCard(d.removeCard(ah));
		h2.alwaysAddCard(d.removeCard(ad));
		h3.alwaysAddCard(d.removeCard(ks));
		h4.alwaysAddCard(d.removeCard(kc));
	}
	
	/**
	 * Deals out the remaining 48 cards, 6 each, to the 8 tableaus
	 * and initializes them
	 */
	public void dealGame() {
		t1 = new Tableaus(a1, d);
		t2 = new Tableaus(b2, d);
		t3 = new Tableaus(c3, d);
		t4 = new Tableaus(d4, d);
		t5 = new Tableaus(e5, d);
		t6 = new Tableaus(f6, d);
		t7 = new Tableaus(g7, d);
		t8 = new Tableaus(h8, d);
	}
	
	/**
	 * Moves a card based on whether or not the move is legal
	 * 
	 * @param s The card that is trying to move
	 * @param t The tableau that the card is being removed from
	 * @param v The tableau that the card is being put on
	 */
	public void moveCard(Card s, Tableaus t, Tableaus v) {
		v.addCard(s, t, v);
	}
	
	/**
	 * Moves a card from the tableau to a homecell if legal
	 * 
	 * @param s The card that is trying to move
	 */
	public void moveToHomecell(Card s, Homecells h) {
		if(h.addCard(s)) {
			h.addCard(s);
		}
	}

	/**
	 * Checks whether the game has been won or not
	 * 
	 * @return Whether or not the game has been won
	 */
	public boolean checkWin() {
		int a = 0;
		if(h1.checkFinished() == true) {
			a = a + 1;
		}
		if(h2.checkFinished() == true) {
			a = a + 1;
		}
		if(h3.checkFinished() == true) {
			a = a + 1;
		}
		if(h4.checkFinished() == true) {
			a = a + 1;
		}
		if(a == 4) {
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Restarts the game
	 */
	public void restart() {
		if(checkWin() == true) {
			new LittleSpider();
		}
	}
}
