package sP____littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import code.Deck.Card;
import code.littleSpider.LittleSpider;

public class LittleSpiderTableauMouseListener implements MouseListener {

	private LittleSpiderGui gui;
	private JLayeredPane pane;
	private int SelectedIndex;
	private int previousSelectedIndex;
	private LittleSpider gameLogic;

	public LittleSpiderTableauMouseListener(LittleSpider GameLogic, LittleSpiderGui g, JLayeredPane p, int idx) {
		this.gameLogic = GameLogic;
		this.gui = g;
		this.pane = p;
		this.SelectedIndex = idx;
		this.previousSelectedIndex = -1;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel topCardLabel = (JLabel) pane.getComponent(0);
		if (!gui.isSelected()) {
			java.awt.Rectangle uB = topCardLabel.getBounds();
			topCardLabel.setBounds(uB.x + 10, uB.y - 10, uB.width, uB.height);
			topCardLabel.repaint();
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtIndex(SelectedIndex);
			gui.setSelectedtype(0);

		} else if (gui.isSelected() && gui.getSelectedPanel() == pane) {

			java.awt.Rectangle selectedBound = topCardLabel.getBounds();
			topCardLabel.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width,
					selectedBound.height);
			topCardLabel.repaint();
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtIndex(-1);
			gui.setSelectedtype(-1);
			;
		} // added check logic
		else { // if this runs it means that there is already something clicked
			previousSelectedIndex = gui.getSelectedAtIndex(); // since this passed it will mean that index2 is the index
																// of the second tab selected

			if (gui.getSelectedtype() == 0) {
				Card previousSelectedCard = gameLogic.getTableaus(previousSelectedIndex).cardAtIndex(0);
				if (gameLogic.getTableaus(this.SelectedIndex).checkNumber(previousSelectedCard)) { // if this pass it means it is legal move the
																									// card(idk why its
																									// not passing)

					gameLogic.getTableaus(this.SelectedIndex).add(previousSelectedCard, 0);
					gameLogic.getTableaus(previousSelectedIndex).getCardStack().remove(previousSelectedCard);
					gui.refresh();
				} else {// if it is illegal it prints this
					JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation");// shows that it failed

				}
			}
			if (gui.getSelectedtype() == 1) {
				Card previousSelectedCard = gameLogic.getHomeCells(previousSelectedIndex).getCard(0);
				if (gameLogic.getTableaus(this.SelectedIndex).checkNumber(previousSelectedCard)) { // if this pass it means it is legal move the
																									// card(idk why its
																									// not passing)

					gameLogic.getTableaus(this.SelectedIndex).add(previousSelectedCard, 0);
					gameLogic.getHomeCells(previousSelectedIndex).getHomecellStack().remove(previousSelectedCard);
					gui.refresh();
				}
				else {// if it is illegal it prints this
					JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation");// shows that it failed
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
