package ThieveGameLogic;

import java.util.ArrayList;

import ThieveGameLogic.TCards.TRanks;
import ThieveGameLogic.TCards.TSuits;
import code.Deck.Card;

import code.littleSpider.LittleSpider;
import code.littleSpider.Tableaus;




public class Thieve {
	/**
	 * Creates a new Deck that will be used for the game
	 */
	private Decks d = new Decks();
	
	/**
	 * ArrayLists of Card that will be put into the Tableaus
	 */
	private ArrayList<TCards> a1 = new ArrayList<TCards>();;
	private ArrayList<TCards> b2 = new ArrayList<TCards>();;
	private ArrayList<TCards> c3 = new ArrayList<TCards>();;
	private ArrayList<TCards> d4 = new ArrayList<TCards>();;
	private ArrayList<TCards> e5 = new ArrayList<TCards>();;
	private ArrayList<TCards> f6 = new ArrayList<TCards>();;
	private ArrayList<TCards> g7 = new ArrayList<TCards>();;
	private ArrayList<TCards> h7 = new ArrayList<TCards>();;
	private ArrayList<TCards> i8 = new ArrayList<TCards>();;
	private ArrayList<TCards> j9 = new ArrayList<TCards>();;
	private ArrayList<TCards> k10 = new ArrayList<TCards>();;
	private ArrayList<TCards> l11= new ArrayList<TCards>();;
	private ArrayList<TCards> m12= new ArrayList<TCards>();;
	
	private thievePile stock;
	
	
	
	
	
	/**
	 * Creates the 13 Tableaus needed for a Thieve game
	 * Initialized later on
	 */
	private Tablaeus t1;
	private Tablaeus t2;
	private Tablaeus t3;
	private Tablaeus t4;
	private Tablaeus t5;
	private Tablaeus t6;
	private Tablaeus t7;
	private Tablaeus t8;
	private Tablaeus t9;
	
	private Tablaeus t10;
	
	private Tablaeus t11;
	
	private Tablaeus t12;
	private Tablaeus t13;
	
	
	
	/**
	 * Creates the 8 Homecells needed for a thieve game
	 */
	private thieveCells h1 = new thieveCells(null);
	private thieveCells h2 = new thieveCells(null);
	private thieveCells h3 = new thieveCells(null);
	private thieveCells h4 = new thieveCells(null);
	private thieveCells h5 = new thieveCells(null);
	private thieveCells h6 = new thieveCells(null);
	private thieveCells p7 = new thieveCells(null);
	private thieveCells p8 = new thieveCells(null);
	
	
	/**
	 * Creates the Cards that need to be removed from deck to initialize
	 * the homecells
	 */
	
	private TCards ah = new TCards(TRanks.ACE, TSuits.HEARTS);
	private TCards ad = new TCards(TRanks.ACE, TSuits.DIAMONDS);
	private TCards ks = new TCards(TRanks.ACE, TSuits.SPADES);
	private TCards kc = new TCards(TRanks.ACE, TSuits.CLUBS);
	private TCards a = new TCards(TRanks.ACE, TSuits.HEARTS);
	private TCards b = new TCards(TRanks.ACE, TSuits.DIAMONDS);
	private TCards c = new TCards(TRanks.ACE, TSuits.SPADES);
	private TCards e = new TCards(TRanks.ACE, TSuits.CLUBS);
	
	/**
	 * Initializes all the Homecells with the appropriate starting card
	 * h1 has the Ace of Hearts
	 * h2 has the Ace of Diamonds
	 * h3 has the King of Spades
	 * h4 has the King of Clubs
	 * same for h5,h6,p7,p8
	 * 
	 * The Deck should now have 96 cards left
	 */
	public Thieve() {
		
		h1 = new thieveCells(ah);
		h2 = new thieveCells(ad);
		h3 = new thieveCells(ks);
		h4 = new thieveCells(kc);
		h5 = new thieveCells(a);
		h6 = new thieveCells(b);
		p7 = new thieveCells(c);
		p8 = new thieveCells(e);
		
		//remove added cards
		d.removeCard(ah);
		d.removeCard(ad);
		d.removeCard(ks);
		d.removeCard(kc);
		d.removeCard(a);
		d.removeCard(b);
		d.removeCard(c);
		d.removeCard(e);
		
		stock = new thievePile(d);
	
	//dealing removes the card
		t1 = new Tablaeus(a1,d);
		t2 = new Tablaeus(b2,d);
		t3 = new Tablaeus(c3,d);
		t4 = new Tablaeus(d4,d);
		t5 = new Tablaeus(e5,d);
		t6 = new Tablaeus(f6,d);
		t7 = new Tablaeus(g7,d);
		t8 = new Tablaeus(h7,d);
		t9 = new Tablaeus(i8, d);
		t10 = new Tablaeus(j9,d);
		t11 = new Tablaeus(k10,d);
		t12 = new Tablaeus(l11, d);
		t13 = new Tablaeus(m12, d);
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
	public boolean moveToHomecell(TCards s, thieveCells h) {
		thieveCells gs = h;
		if(gs.addCard(s)) {
			h.addCard(s);
			return true;
		}
		return false;
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
		if(h5.checkFinished() == true) {
			a = a + 1;
		}
		if(h6.checkFinished() == true) {
			a = a +1;
		}
		if(p7.checkFinished() == true) {
			a = a + 1;
		}
		if(p8.checkFinished() == true) {
			a = a + 1;
		}
		if(a == 8) {
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
	
	/**
	 * For access to the homecells for the GUI
	 * 
	 * @param which Which homecell you want to get
	 * @return The requested homecell
	 */
	public thieveCells getHomeCells(int which) {
		if(which == 0) {
			return h1;
		}
		else if(which == 1) {
			return h2;
		}
		else if(which == 2) {
			return h3;
		}
		else if(which == 3) {
			return h4;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * For access to the tableau for the GUI
	 * 
	 * @param which Which tableau you want to get
	 * @return The requested tableau
	 */
	public Tablaeus getTableaus(int which) {
		if(which == 0) {
			return t1;
		}
		else if(which == 1) {
			return t2;
		}
		else if(which == 2) {
			return t3;
		}
		else if(which == 3) {
			return t4;
		}
		else if(which == 4) {
			return t5;
		}
		else if(which == 5) {
			return t6;
		}
		else if(which == 6) {
			return t7;
		}
		else if(which == 7) {
			return t8;
		}
		else if(which == 8) {
			return t9;
		}
		else if(which == 9) {
			return t10;
		}
		else if(which == 10) {
			return t11;
		}
		else if(which == 11) {
			return t12;
		}
		else if (which == 12) {
			return t13;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	public thievePile getThieve() {
		return stock;
	}
	public ArrayList<TCards> getWaste(){
		return stock.getWaste();
	}
}
