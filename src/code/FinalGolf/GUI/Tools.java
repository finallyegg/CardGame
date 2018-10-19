package code.FinalGolf.GUI;

import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.*;
import code.Deck.Card;

public class Tools {
	public static JLabel createDisplayImage(String fileNameRelativeToClassFile) {
	    JLabel retVal = new JLabel();
	    java.net.URL imgURL = Tools.class.getResource(fileNameRelativeToClassFile);
	    if (imgURL == null) {
	      throw new IllegalArgumentException("Couldn't find file: " + fileNameRelativeToClassFile);
	    }
	    ImageIcon cardImage = new ImageIcon(imgURL);    
	    retVal.setIcon(cardImage);
	    Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
	    retVal.setSize(d);
	    retVal.setPreferredSize(d);
	    retVal.setMaximumSize(d);
	    retVal.setMinimumSize(d);
	    return retVal;
	  }
	
	public static JLabel getCardLabel (Card x) {
		HashMap<Card,String> cardNameMap = new HashMap<>();

		for (Card.Suits i : Card.Suits.values()) {
			cardNameMap.put(new Card(Card.Ranks.ACE,i), "a"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.TWO,i), "2"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.THREE,i), "3"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.FOUR,i), "4"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.FIVE,i), "5"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.SIX,i), "6"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.SEVEN,i), "7"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.EIGHT,i), "8"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.NINE,i), "9"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.TEN,i), "10"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.JACK,i), "j"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.QUEEN,i), "q"+i.toString().toLowerCase().split("")[0]);
			cardNameMap.put(new Card(Card.Ranks.KING,i), "k"+i.toString().toLowerCase().split("")[0]);
		}
		for (Card i :cardNameMap.keySet()) {
			if(i.getRank().equals(x.getRank())&&i.getSuit().equals(x.getSuit())){
				x=i;
			}
		}
//		System.out.print(cardNameMap);
		String filename = cardNameMap.get(x);
//		Tools.createDisplayImage("/S18SemesterProject/src/IconPack/" + filename + ".gif");
		return Tools.createDisplayImage("/src/IconPack/" + filename + ".gif");
	}
	
	public static void main(String[] args) {
		System.out.print(Tools.getCardLabel(new Card(Card.Ranks.TWO,Card.Suits.HEARTS)));
	}
}
