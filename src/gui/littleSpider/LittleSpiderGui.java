package gui.littleSpider;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.tools.Tool;

import code.Deck.Card;
import code.FinalGolf.GUI.Tools;
import code.littleSpider.LittleSpider;

public class LittleSpiderGui implements MouseListener {
	private LittleSpider ls;
	private JPanel tab;
	private JPanel home;
	private static JFrame game;
	private Card checker = new Card(null,null);
	private int tabPressed;
	private JLayeredPane[] la = new JLayeredPane[8]; //for Tab cards

	
	
	
	public LittleSpiderGui(LittleSpider idk) {
		ls = idk;
		tab = new JPanel();
		home = new JPanel();
	
		
	   game.add(home);
	   game.add(tab);
		

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
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
	public void setTableaus() {
		
	}
	
	public JPanel getTableaus() {
		return tab;
		
	}
	
	public void setHome() {
		
	}
	public JPanel getHome() {
		return home;
	}
	
	
	
	}
	
	
