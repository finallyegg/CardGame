package code.FinalGolf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Homecells{
	
//	HomeCell Card List
	private ArrayList<Card> Homecellstack;
	
	
	public Golf_Homecells () {
		this.Homecellstack = new ArrayList<Card>();
		
		
	}
	
	/**
	 * @param x
	 * @return Nope, you cannot
	 */
	public boolean RemoveCard(Card x) {
		return false;
	}
	
	/**
	 * @param x;   It is only legal to add a card of any suit from the tableau pile to the homecell pile if the tableau pile's card has a rank just above or just below the homecell's top card
	 * @return
	 */
	public boolean addCard (Card x) {
//		some container that have card from other piles as the possible choice to meet the Homecell critira. 
		ArrayList<Card> optionalChoice = new ArrayList<Card>();
		ArrayList<Card> TableausTopCardlist = new ArrayList<>();
		if (!Golf_Main.getStockPile().getStockStack().isEmpty()) {
			optionalChoice.add(Golf_Main.getStockPile().getStockStack().get(0));
		}
		
		
		
		for (int i = 0; i < 7; i++) {
			if (!Golf_Main.getTableaus(i).getTablestack().isEmpty()) {
				TableausTopCardlist.add(Golf_Main.getTableaus(i).getTablestack().get(0));
			}
		}
		for (Card i : TableausTopCardlist ) {
			if (this.Homecellstack.isEmpty()) {
				break;
			}
//			Because of the round Ranking properties of Golf, 2 is bigger than Ace, so the different between two and Ace is 12
			else if (Math.abs(i.value() - this.Homecellstack.get(0).value()) == 1 || Math.abs(i.value() - this.Homecellstack.get(0).value()) == 12) {
				optionalChoice.add(i);
			}
			
		}
		
		if (optionalChoice.contains(x)) {
			this.Homecellstack.add(x);
			return true;
		}
		optionalChoice.clear();
		TableausTopCardlist.clear();
		return false;
	}
//get method
	public ArrayList<Card> getHomecellstack() {
		return Homecellstack;
	}
}
