package gui.littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import code.Deck.Card;
import code.littleSpider.Homecells;
import code.littleSpider.Tableaus;

public class LittleSpiderMouseListener implements MouseListener{
	
	private JButton B1;
	private Card topcard;
	private Homecells lsHome;
	private Tableaus lsTab;
	
	public LittleSpiderMouseListener(JButton x, Tableaus t, Homecells h) {
		B1 = x;
		lsTab = t;
		lsHome = h;
		topcard = t.cardAtIndex(0);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

		if(lsHome.addCard(topcard) == true) {
			System.out.println("Card added to Homecell");
		}
		else {
			System.out.println("Not a legal move");
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
