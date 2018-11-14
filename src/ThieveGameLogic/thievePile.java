package ThieveGameLogic;



import java.util.ArrayList;

import ThieveGameLogic.TCards;
import ThieveGameLogic.Decks;


public class thievePile {
	ArrayList<TCards> stock = new ArrayList<TCards>();
	Decks d = new Decks();
	ArrayList<TCards> waste = new ArrayList<TCards>();

	public thievePile(Decks a) {
		for(int i = 0; i< 57; i++) {
			stock.add(d.deal());
		}
	}
	
	public TCards getCard(thievePile a) {
		return stock.get(0);
	}
	
	public boolean removeStockCard(thievePile a) {
		if(!stock.isEmpty()) {
			TCards c = stock.remove(stock.size() - 1);
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
	
	public void putWaste(ArrayList<TCards> wast, TCards c) {
		waste.add(c);
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
	public void forceAddStock(TCards c) {
		stock.add(c);
	}
	
	public ArrayList<TCards> getStock(){
		return stock;
	}
	
	public ArrayList<TCards> getWaste(){
		return waste;
	}
	
	public int getStockSize() {
		return stock.size();
	}

}
