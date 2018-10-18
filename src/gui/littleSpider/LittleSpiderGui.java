package gui.littleSpider;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.littleSpider.LittleSpider;

public class LittleSpiderGui {
	private LittleSpider ls;
	private static JFrame game;
	
	public LittleSpiderGui() {
		ls = new LittleSpider();
		JFrame frame = new JFrame("Little Spider");
	    frame.setSize(1000, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	
	}
	private JLabel createDisplayImage(String fileNameRelativeToClassFile) {
	    JLabel retVal = new JLabel();
	    java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
	    if (imgURL == null) {
	      throw new IllegalArgumentException("Couldn't find file: " + "path");
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
	
	
	public static JFrame startGame() {
		
		return game;
	}
	
	
	
	  
	
	
	public static void main(String[] args){
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	LittleSpider qwe = new LittleSpider();
	        	LittleSpiderGui game = new	LittleSpiderGui();
	        	startGame();
	        
	        }
	    });
	}
}
