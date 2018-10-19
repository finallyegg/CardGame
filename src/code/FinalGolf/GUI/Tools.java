package code.FinalGolf.GUI;

import java.awt.Dimension;

import javax.swing.*;

public class Tools {
	private JLabel createDisplayImage(String fileNameRelativeToClassFile) {
	    JLabel retVal = new JLabel();
	    java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
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
}
