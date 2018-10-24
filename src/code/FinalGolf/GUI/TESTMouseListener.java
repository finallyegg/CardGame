package code.FinalGolf.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import code.Deck.Card;
import code.FinalGolf.Golf_Game;

public class TESTMouseListener implements MouseListener {
	
	private Golf_Game gameLogic;
	private Golf_GUI gui;
	
	public TESTMouseListener(Golf_Game gameLogic, Golf_GUI gui) {
		this.gameLogic=gameLogic;
		this.gui=gui;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (!gui.isSelected()) {
			JOptionPane.showMessageDialog(null, "Invaild Entry - Cannot select from HomeCell Pile");
		}else {
			Card selectedCard = gameLogic.getTableaus(gui.getSelectedAtTablue_index()).getTablestack().get(0);
			if (gameLogic.getHomeCell().addCard(selectedCard)) {
				gameLogic.getTableaus(gui.getSelectedAtTablue_index()).RemoveCard(selectedCard);
				gui.setSelected(false);
				gui.setSelectedPanel(null);
				gui.setSelectedAtTablue_index(-1);
				gui.refresh();
			}
			else {
				JOptionPane.showMessageDialog(null, "Invaild Entry - Failed");
				gui.refresh();
			}
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
