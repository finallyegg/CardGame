package ThieveGameLogic;



import java.util.ArrayList;

import ThieveGameLogic.Decks;
import code.Deck.Card;


public class thievePile {
	ArrayList<Card> stock = new ArrayList<Card>();
	Decks d = new Decks();
	ArrayList<Card> waste = new ArrayList<Card>();

	public thievePile(Decks a) {
		for(int i = 0; i< 57; i++) {
			stock.add(0,d.deal());
		}
	}
	
	public Card getCard(thievePile a) {
		return stock.get(0);
	}
	
	public boolean removeStockCard(thievePile a) {
		if(!stock.isEmpty()) {
			Card c = stock.remove(stock.size() - 1);
			putWaste(waste, c);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeWasteCard(thievePile a) {
		if(!waste.isEmpty()) {
			waste.remove(waste.size() - 1);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void putWaste(ArrayList<Card> wast, Card c) {
		waste.add(0,c);
	}
	
	public boolean putWaste() {
		return false;
	}
	
	public boolean addStock() {
		return false;
	}
	
	/*
	 * Only used for testing purposes
	 */
	public void forceAddStock(Card c) {
		stock.add(c);
	}
	
	public ArrayList<Card> getStock(){
		return stock;
	}
	
	public ArrayList<Card> getWaste(){
		return waste;
	}
	
	public int getStockSize() {
		return stock.size();
	}

}
