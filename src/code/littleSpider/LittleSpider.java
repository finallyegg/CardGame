package code.littleSpider;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;

public class LittleSpider {
	
	private Deck d = new Deck();
	private ArrayList<Card> a1 ;
	private ArrayList<Card> b2 ;
	private ArrayList<Card> c3 ;
	private ArrayList<Card> d4 ;
	private ArrayList<Card> e5;
	private ArrayList<Card> f6 ;
	private ArrayList<Card> g7;
	private ArrayList<Card> h8 ;
	private Tableaus t1 = new Tableaus(null,null);
	private Tableaus t2 = new Tableaus(null, null);
	private Tableaus t3 = new Tableaus(null,null);
	private Tableaus t4 = new Tableaus(null,null);
	private Tableaus t5 = new Tableaus(null,null);
	private Tableaus t6 = new Tableaus(null,null);
	private Tableaus t7 = new Tableaus(null,null);
	private Tableaus t8 = new Tableaus(null,null);
	private Homecells h1 = new Homecells(null);
	private Homecells h2 = new Homecells(null);
	private Homecells h3 = new Homecells(null);
	private Homecells h4 = new Homecells(null);
	
	public LittleSpider() {
		a1  = new ArrayList<Card>();
		b2 = new ArrayList<Card>();
		c3  = new ArrayList<Card>();
		d4 = new ArrayList<Card>();
		e5  = new ArrayList<Card>();
		f6  = new ArrayList<Card>();
		g7 = new ArrayList<Card>();
		h8  = new ArrayList<Card>();
	}
	
	public void dealGame() {
		  t1 = new Tableaus(a1,d);
		  t2 = new Tableaus(b2, d);
		  t3 = new Tableaus(c3,d);
		  t4 = new Tableaus(d4,d);
		  t5 = new Tableaus(e5,d);
		  t6 = new Tableaus(f6,d);
		  t7 = new Tableaus(g7,d);
		  t8 = new Tableaus(h8,d);
		
	}
	//move a card from one tableaus to another
	public void moveCard(Card s, Tableaus t, Tableaus v) {
		v.addCard(s, t, v);
	}
	public void moveToHomecell(Card s) {
		
	}
	//check to see if homecells are done
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
	else return false;
	}
	
	public void restart() {
		if(checkWin() == true) {
			dealGame();
		}
	}

}
