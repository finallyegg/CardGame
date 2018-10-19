package code.FinalGolf.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import code.Deck.Card;
import code.FinalGolf.Golf_Homecells;
import code.FinalGolf.Golf_Tableaus;

public class GolfMouseListener implements MouseListener{
	
	private JButton B1;
	private Card topcard;
	private Golf_Tableaus golfTablue;
	private Golf_Homecells golfHomeCell;
	
	public GolfMouseListener(JButton x, Golf_Tableaus b, Golf_Homecells c) {
		B1 = x;
		golfTablue = b;
		golfHomeCell = c;
		topcard = b.getTablestack().get(0);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	if(golfHomeCell.getHomecellstack().add(topcard) == true) {
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
