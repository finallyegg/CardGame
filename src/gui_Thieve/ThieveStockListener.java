package gui_Thieve;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import ThieveGameLogic.Thieve;
import code.Deck.Card;
import code.FinalGolf.GUI.Tools;

public class ThieveStockListener implements MouseListener{
	private Thieve gameLogic;
	private ThieveGui gui;
	private JLabel Mathew;
	
	public ThieveStockListener(Thieve gameLogic, ThieveGui GUI,JLabel Mathew) {
		this.gameLogic=gameLogic;
		this.gui=GUI;
		this.Mathew = Mathew;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gui.getstockpile().repaint();
		gui.getstockpile().revalidate();
		System.out.println(gameLogic.getThieve().getStock().size());
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.Mathew.setIcon(Tools.getMatthewIcon(1));
		Card card = gameLogic.getThieve().getStock().get(0);
		gameLogic.getWaste().add(0, card);
		gameLogic.getThieve().getStock().remove(card);
		gui.getWastePile().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		this.Mathew.setIcon(Tools.getMatthewIcon(0));
		this.gui.setSelected(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.Mathew.setIcon(Tools.getMatthewIcon(0));
		this.gui.getLowerTableauPanel().setVisible(false);
		this.gui.getHomcellPanel().setVisible(false);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.Mathew.setIcon(Tools.getEmptyCardIcon(1));
		this.gui.getLowerTableauPanel().setVisible(true);
		this.gui.getHomcellPanel().setVisible(true);
		
	}

}
