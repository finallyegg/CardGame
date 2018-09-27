package code.FinalGolf;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
/**
 * @author Zeping and Dinana and Jake
 * Special Thanks to Jake for his much efficient constructor!!!
 *
 */
public class Golf_Main {
	
	/* 5 Field, Tableaus array, Homecell, Stock and Deck and a list for all Tableaus Card (since its an array of 7) */
	private Deck d; 
	
	private static Golf_Tableaus t[]; 
	private static Golf_Homecells h1;
	private static Golf_Stock s1;
	private static ArrayList<Card> allTableausCard;
	
	/* constructor for initializing   */
	public Golf_Main() {
		this.d = new Deck();
		d.shuffle();
		allTableausCard = new ArrayList<>();
		t = new Golf_Tableaus[7];
		
		/* Distribute Cards for Tableaus, WOW we can use loop! @Jake  */
		for (int tablenum = 0 ; tablenum < 7 ; tablenum++) {
			t[tablenum] = new Golf_Tableaus();
			
			for (int cardnumber = 0 ; cardnumber < 5; cardnumber++) {
				Card tem = d.deal();
				t[tablenum].getTablestack().add(tem);
				allTableausCard.add(tem);
			}
			
		}

		/* Homecells have no Cards initially */
		h1 = new Golf_Homecells();
		
		/* The rest Card goes to Stock   */
		s1 = new Golf_Stock(d.getCards());
		
		
	}
	
	/**
	 * @return Stock instance
	 */
	public static Golf_Stock getStockPile() {
		return s1;
	}
	
	/**
	 * @return Homecell instance
	 */
	public static Golf_Homecells getHomeCell() {
		return h1;
	}
	
	/**
	 * @param i
	 * @return which Tableaus you are looking for
	 */
	public static Golf_Tableaus getTableaus(int i) {
		return t[i];
	}
	/**
	 * @return total inital Card for Tableaus, may prevent cheating in future
	 */
	public static ArrayList<Card> getallTableausCard(){
		return allTableausCard;
	}
	
}
