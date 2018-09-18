package code.golf;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
@SuppressWarnings("unused")

public class ProGolf {
	private Deck d; 
	
	private Golf_Tableaus t[]; 
	private Golf_Homecells h1;
	private Golf_Stock s1;
	
	public ProGolf() {
		this.d = new Deck();
		d.shuffle();
		
		t = new Golf_Tableaus[7];
		
		for (int tablenum = 0 ; tablenum < 7 ; tablenum++) {
			t[tablenum] = new Golf_Tableaus();
			
			for (int cardnumber = 0 ; cardnumber < 5; cardnumber++) {
				t[tablenum].addCard(d.deal());
			}
			
		}

	
		this.h1 = new Golf_Homecells();
		
		
		this.s1 = new Golf_Stock(d.getCards());
		
		
	}

	public Golf_Stock getStockPile() {
		return s1;
	}
	
	public Golf_Homecells getHomeCell() {
		return h1;
	}
	
}
