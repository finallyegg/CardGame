package code.FinalGolf.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import code.Deck.Card;
import code.FinalGolf.Golf_Homecells;
import code.FinalGolf.Golf_Tableaus;

/**
 * @author TEAM
 *  
 * Just for testing--- please do not grade
 *
 */
public class TEST1 implements MouseListener{

	private JButton B1;
	private Card topcard;
	private Golf_Tableaus golfTablue;
	private Golf_Homecells golfHomeCell;

	public TEST1(JButton x, Golf_Tableaus b, Golf_Homecells c) {
		setB1(x);
		setGolfTablue(b);
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

	public JButton getB1() {
		return B1;
	}

	public void setB1(JButton b1) {
		B1 = b1;
	}

	public Golf_Tableaus getGolfTablue() {
		return golfTablue;
	}

	public void setGolfTablue(Golf_Tableaus golfTablue) {
		this.golfTablue = golfTablue;
	}

}
