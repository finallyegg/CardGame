package gui_Thieve;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ThieveGameLogic.Thieve;
import code.Deck.Card;
import code.FinalGolf.GUI.Tools;

/**
 * @author Team 
 * 
 *
 */
public class ThieveStockListener implements MouseListener{
	private Thieve gameLogic;
	private ThieveGUI gui;
	private JLabel Mathew;
	
	/**
	 * @param gameLogic
	 * @param GUI
	 * @param Mathew (Cool easter egg)
	 */
	public ThieveStockListener(Thieve gameLogic, ThieveGUI GUI,JLabel Mathew) {
		this.gameLogic=gameLogic;
		this.gui=GUI;
		this.Mathew = Mathew;
	}
	/**
	 * @param e
	 * @Do set picture
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		gui.getstockpile().repaint();
		gui.getstockpile().revalidate();
		System.out.println(gameLogic.getThieve().getStock().size());
		
		
	}

	/**
	 * @param e
	 * @Do set picture
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.gui.isSelected()) {
			JOptionPane.showMessageDialog(null, "Invaild Entry - Can not add card to Stock");
			this.gui.setSelected(false);
			this.gui.getLowerTableauPanel().repaint();
			this.gui.getLowerTableauPanel().revalidate();
		}else {
		this.Mathew.setIcon(Tools.getMatthewIcon(1));
		Card card = gameLogic.getThieve().getStock().get(0);
		gameLogic.getWaste().add(0, card);
		gameLogic.getThieve().getStock().remove(card);
		gui.getWastePile().repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		this.Mathew.setIcon(Tools.getMatthewIcon(0));
		this.gui.setSelected(false);
	}

	/**
	 * @param e
	 * @Do set picture
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.Mathew.setIcon(Tools.getMatthewIcon(0));
		this.gui.getLowerTableauPanel().setVisible(false);
		this.gui.getHomcellPanel().setVisible(false);
		this.gui.getBigPhoto().setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.Mathew.setIcon(Tools.getEmptyCardIcon(1));
		this.gui.getLowerTableauPanel().setVisible(true);
		this.gui.getHomcellPanel().setVisible(true);
		this.gui.getBigPhoto().setVisible(false);
	}

}
