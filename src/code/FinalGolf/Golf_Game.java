package code.FinalGolf;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
/**
 * @author Zeping and Dinana and Jake
 * Special Thanks to Jake for his much efficient constructor!!!
 *
 */
public class Golf_Game {
	
	/* 5 Field, Tableaus array, Homecell, Stock and Deck and a list for all Tableaus Card (since its an array of 7) */
	private Deck d; 
	
	private Golf_Tableaus t[]; 
	private Golf_Homecells h1;
	private Golf_Stock s1;
	private ArrayList<Card> allTableausCard;
	
	/* constructor for initializing   */
	public Golf_Game() {
		this.d = new Deck();
		d.shuffle();
		allTableausCard = new ArrayList<>();
		t = new Golf_Tableaus[7];
		
		/* Distribute Cards for Tableaus, WOW we can use loop! @Jake  */
		for (int tablenum = 0 ; tablenum < 7 ; tablenum++) {
			t[tablenum] = new Golf_Tableaus();
			
			for (int cardnumber = 0 ; cardnumber < 5; cardnumber++) {
				Card tem = d.deal();
				t[tablenum].getTablestack().add(0,tem);
				allTableausCard.add(tem);
			}
			
		}

		/* Homecells have no Cards initially */
		h1 = new Golf_Homecells(this);
		
		/* The rest Card goes to Stock   */
		s1 = new Golf_Stock(d.getCards());
		
		
	}
	
	/**
	 * @return Stock instance
	 */
	public Golf_Stock getStockPile() {
		return s1;
	}
	
	/**
	 * @return Homecell instance
	 */
	public Golf_Homecells getHomeCell() {
		return h1;
	}
	
	/**
	 * @param i
	 * @return which Tableaus you are looking for
	 */
	public Golf_Tableaus getTableaus(int i) {
		return t[i];
	}
	/**
	 * @return total inital Card for Tableaus, may prevent cheating in future
	 */
	public ArrayList<Card> getallTableausCard(){
		return allTableausCard;
	}
	
}
