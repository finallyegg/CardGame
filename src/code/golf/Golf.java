package code.golf;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
@SuppressWarnings("unused")

public class Golf {
	private Deck d; 
	
	private Golf_Tableaus t1; 
	private Golf_Tableaus t2; 
	private Golf_Tableaus t3; 
	private Golf_Tableaus t4; 
	private Golf_Tableaus t5;
	private Golf_Tableaus t6;
	private Golf_Tableaus t7; 
	private static ArrayList<Card> AllTableausCard;
	
	private Golf_Homecells h1;
	
	private Golf_Stock s1;
	
	public Golf() {
		this.d = new Deck();
		d.shuffle();
		ArrayList<Card> removelist = new ArrayList<>();
		
		this.t1 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.t2 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.t3 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.t4 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.t5 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.t6 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.t7 = new Golf_Tableaus(d.getCards().get(0),d.getCards().get(1),d.getCards().get(2),d.getCards().get(3),d.getCards().get(4));
		for (int i = 0; i <= 5; i++) {
			Golf.AllTableausCard.get(i);
			removelist.add(d.getCards().get(i));
		}
		d.getCards().removeAll(removelist);
		removelist.clear();
		
		this.h1 = new Golf_Homecells();
		
		
		this.s1 = new Golf_Stock(d.getCards());
		
		
	}
	public static ArrayList<Card> getAllTableausCard() {
		return AllTableausCard;
	}

	
	
}
