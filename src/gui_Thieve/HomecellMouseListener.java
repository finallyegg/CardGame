package gui_Thieve;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JOptionPane;

import ThieveGameLogic.Thieve;
import code.Deck.Card;
import gui_Thieve.ThieveGUI.selectedType;

/**
 * @author
 * @DO LittleSpiderHomeCell Listener
 */
public class HomecellMouseListener implements MouseListener {

	private ThieveGUI gui;
	private Thieve gameLogic;
	private int SelectedIndex;

	/**
	 * @param gameLogic
	 * @param gui
	 * @param i
	 */
	public HomecellMouseListener(Thieve gameLogic, ThieveGUI gui, int i) {
		this.gui = gui;
		this.gameLogic = gameLogic;
		this.SelectedIndex = i;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) { // check if the previous selected card is legal to add the current select panel
		if (gui.isSelected()&&gui.getWhereSelected()==selectedType.TABLEAU ) {
				Card previousSelectedCard = gameLogic.getTableaus(gui.getSelectedAtIndex()).getCardStack().get(0);
				if (gameLogic.getHomeCells(SelectedIndex).checkNumber(previousSelectedCard)) { 
					gameLogic.getHomeCells(this.SelectedIndex).getHomecellStack().add(0, previousSelectedCard);
					gameLogic.getTableaus(gui.getSelectedAtIndex()).getCardStack().remove(previousSelectedCard);
					gui.refresh();
				} else {// if it is illegal it prints this
					JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation_HomeCell");
					gui.refresh();
				}
			}else if (gui.isSelected()&&gui.getWhereSelected()==selectedType.WASTE){// if it is illegal it prints this
				Card previousSelectedCard = gameLogic.getWaste().get(0);
				if(gameLogic.getHomeCells(SelectedIndex).checkNumber(previousSelectedCard)) { 
					gameLogic.getHomeCells(this.SelectedIndex).getHomecellStack().add(0, previousSelectedCard);
					gameLogic.getWaste().remove(previousSelectedCard);
					gui.refresh();
				}else {
				JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation");
				gui.refresh();
				}
			}
		}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
//		Card card = gameLogic.getTableaus(gui.getSelectedAtTablue_index()).cardAtIndex(0);
//		if(gameLogic.moveToHomecell(card, gameLogic.getHomeCells(gui.getSelectedAtHomecellIndex()))){
//			gameLogic.getTableaus(gui.getSelectedAtTablue_index());
//		}
//		
//

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
