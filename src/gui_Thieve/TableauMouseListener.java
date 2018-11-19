package gui_Thieve;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import ThieveGameLogic.Thieve;
import code.Deck.Card;
import gui_Thieve.ThieveGui.selectedType;

/**
 * @author TableauMouseListner
 *
 */
public class TableauMouseListener implements MouseListener {

	private ThieveGui gui;
	private JLayeredPane pane;
	private int SelectedIndex;
	private int previousSelectedIndex;
	private Thieve gameLogic;

	public TableauMouseListener(Thieve GameLogic, ThieveGui g, JLayeredPane p,int i) {
		this.gameLogic = GameLogic;
		this.gui = g;
		this.pane = p;
		this.SelectedIndex = i;

	}

	@Override
	public void mouseClicked(MouseEvent e) { // check if the previous selected card is legal to add the current select panel
		JLabel topCardLabel = (JLabel) pane.getComponent(0);
		if (!gui.isSelected()) {
			java.awt.Rectangle uB = topCardLabel.getBounds();
			topCardLabel.setBounds(uB.x + 10, uB.y - 10, uB.width, uB.height);
			topCardLabel.repaint();
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtIndex(SelectedIndex);
			gui.setWhereSelected(selectedType.TABLEAU);
			gui.setSelectedAtIndex(SelectedIndex);

		} else if (gui.isSelected() && gui.getSelectedPanel() == pane) {

			java.awt.Rectangle selectedBound = topCardLabel.getBounds();
			topCardLabel.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width,
					selectedBound.height);
			topCardLabel.repaint();
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setWhereSelected(selectedType.EMPTY);
			gui.setSelectedAtIndex(-1);
			
		} // added check logic
		else { // if this runs it means that there is already something clicked
			previousSelectedIndex = gui.getSelectedAtIndex(); 
			if (gui.getWhereSelected() == selectedType.TABLEAU) {
				Card previousSelectedCard = gameLogic.getTableaus(previousSelectedIndex).cardAtIndex(0);
				if (gameLogic.getTableaus(this.SelectedIndex).checkNumber(previousSelectedCard)) { // if this pass it means it is legal move the
					gameLogic.getTableaus(this.SelectedIndex).add(previousSelectedCard, 0);
					gameLogic.getTableaus(previousSelectedIndex).getCardStack().remove(previousSelectedCard);
					gui.refresh();
				} else {// if it is illegal it prints this
					JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation1");// shows that it failed
					gui.refresh();
				}
			}else {
				Card previousSelectedCard = gameLogic.getWaste().get(0);
				if (gameLogic.getTableaus(this.SelectedIndex).checkNumber(previousSelectedCard)) { // if this pass it means it is legal move the
					gameLogic.getTableaus(this.SelectedIndex).add(previousSelectedCard, 0);
					gameLogic.getWaste().remove(previousSelectedCard);
					gui.refresh();
				} else {// if it is illegal it prints this
					JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation2");// shows that it failed
					gui.refresh();
				}
			}
			
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
