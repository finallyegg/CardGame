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
	
	public boolean putWaste(ArrayList<TCards> stok, ArrayList<TCards> wast) {
		waste.add(stok.get(0));
		return true;
	}
	
	public boolean putWaste() {
		return false;
	}
	
	public boolean addStock() {
		return false;
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
