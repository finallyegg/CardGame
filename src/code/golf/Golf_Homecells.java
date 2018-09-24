package code.golf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Homecells{
	
	private ArrayList<Card> optionalChoice;
	
	private ArrayList<Card> Homecellstack;
	
	private ArrayList<Card> TableausTopCardlist;
	
	public Golf_Homecells () {
		this.Homecellstack = new ArrayList<Card>();
		optionalChoice = new ArrayList<Card>();
		TableausTopCardlist = new ArrayList<>();
		
	}
	
	public boolean RemoveCard(Card x) {
		return false;
	}
	
	public boolean addCard (Card x) {
		if (!ProGolf.getStockPile().getStockStack().isEmpty()) {
			optionalChoice.add(ProGolf.getStockPile().getStockStack().get(0));
		}
		
		
		
		for (int i = 0; i < 7; i++) {
			if (!ProGolf.getTableaus(i).getTablestack().isEmpty()) {
				TableausTopCardlist.add(ProGolf.getTableaus(i).getTablestack().get(0));
			}
		}
		for (Card i : TableausTopCardlist ) {
			if (this.Homecellstack.isEmpty()) {
				break;
			}
			else if (Math.abs(i.value() - this.Homecellstack.get(0).value()) == 1 || Math.abs(i.value() - this.Homecellstack.get(0).value()) == 12) {
				optionalChoice.add(i);
			}
			
		}
		
		if (optionalChoice.contains(x)) {
			this.Homecellstack.add(x);
			return true;
		}
		
		return false;
	}

	public ArrayList<Card> getHomecellstack() {
		return Homecellstack;
	}
	public ArrayList<Card> getoptionalChoice(){
		return this.optionalChoice;
	}
	public ArrayList<Card> gettableautopCardlist(){
		return this.TableausTopCardlist;
	}

	public void setHomecellstack(ArrayList<Card> homecellstack) {
		Homecellstack = homecellstack;
	}
}
