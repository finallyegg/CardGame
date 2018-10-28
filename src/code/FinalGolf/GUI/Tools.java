package code.FinalGolf.GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.*;
import code.Deck.Card;

/**
 * @author TEAM
 * 
 * Some useful tools for GUI
 */
public class Tools {
	/**
	 * @param fileNameRelativeToClassFile
	 * @return Java JLabel
	 */
	public static JLabel createDisplayImage(String fileNameRelativeToClassFile) {
	    JLabel retVal = new JLabel();
	    java.net.URL imgURL = Tools.class.getResource(fileNameRelativeToClassFile);
	    if (imgURL == null) {
	      throw new IllegalArgumentException("Couldn't find file: " + fileNameRelativeToClassFile);
	    }
	    ImageIcon cardImage = new ImageIcon(imgURL);    
	    retVal.setIcon(cardImage);
	    Dimension d = new Dimension(cardImage.getIconWidth() , cardImage.getIconHeight());
	    retVal.setSize(d);
	    retVal.setPreferredSize(d);
	    retVal.setMaximumSize(d);
	    retVal.setMinimumSize(d);
	    return retVal;
	  }
	
	/**
	 * @param Card instance
	 * @return JLabel contains Card image
	 */
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
			if(i.getRank()==(x.getRank())&&i.getSuit()==(x.getSuit())){
				x=i;
			}
		}
		
		String filename = cardNameMap.get(x);
		return Tools.createDisplayImage("/IconPack/" + filename + ".gif");
	}
	
	/**
	 * @param int 0/1
	 * @return pure green or red image
	 */
	public static JLabel getEmptyCardLabel (int x) {
		if(x==0) {
			return Tools.createDisplayImage("/IconPack/" + "green" + ".gif");
		}
		return Tools.createDisplayImage("/IconPack/" + "gold" + ".gif");
	}
	
	/**
	 * @return Hertz's photo
	 */
	public static JLabel getMatthewPhoto() {
	    JLabel retVal = new JLabel();
	    java.net.URL imgURL = Tools.class.getResource("/IconPack/" + "MatthewPhoto" + ".jpg");
	    if (imgURL == null) {
	      throw new IllegalArgumentException("Couldn't find file: " + "/IconPack/" + "MatthewPhoto" + ".jpg");
	    }
	    ImageIcon cardImage = new ImageIcon(imgURL);
	    Image img = cardImage.getImage().getScaledInstance(73, 100, Image.SCALE_DEFAULT);
	    ImageIcon newCard = new ImageIcon(img);
	    retVal.setIcon(newCard);
	    Dimension d = new Dimension(73 , 97);
	    retVal.setSize(d);
	    retVal.setPreferredSize(d);
	    retVal.setMaximumSize(d);
	    retVal.setMinimumSize(d);
	    return retVal;
	  }
	
	/**
	 * @param int 0/1
	 * @return Hertz's icon
	 */
	public static ImageIcon getMatthewIcon(int x) {
	    JLabel retVal = new JLabel();
	    java.net.URL imgURL;
	    if (x==0) {
	    	imgURL = Tools.class.getResource("/IconPack/" + "MatthewPhoto" + ".jpg");
	    }
	    else {
	    	imgURL = Tools.class.getResource("/IconPack/" + "MatthewSimpson" + ".png");
	    }
	    if (imgURL == null) {
	      throw new IllegalArgumentException("Couldn't find file: " + "/IconPack/" + "MatthewPhoto" + ".jpg");
	    }
	    ImageIcon cardImage = new ImageIcon(imgURL);
	    Image img = cardImage.getImage().getScaledInstance(73, 97, Image.SCALE_FAST);
	    ImageIcon newCard = new ImageIcon(img);
	    retVal.setIcon(newCard);
	    Dimension d = new Dimension(73 , 97);
	    retVal.setSize(d);
	    retVal.setPreferredSize(d);
	    retVal.setMaximumSize(d);
	    retVal.setMinimumSize(d);
	    return newCard;
	  }
}
