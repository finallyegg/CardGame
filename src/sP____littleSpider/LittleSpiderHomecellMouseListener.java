package sP____littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import code.Deck.Card;
import code.littleSpider.Homecells;
import code.littleSpider.LittleSpider;
import code.littleSpider.Tableaus;

public class LittleSpiderHomecellMouseListener implements MouseListener {

	private LittleSpiderGui gui;
	private JLayeredPane pane;
	private int SelectedIndex;
	private LittleSpider gameLogic;
	private int previousSelectedIndex;

	public LittleSpiderHomecellMouseListener(LittleSpiderGui gui, JLayeredPane Pane, int idx, LittleSpider game) {
		this.gui = gui;
		this.pane = Pane;
		this.SelectedIndex = idx;

		this.gameLogic = game;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.print(gui.isSelected());
		JLabel modified = (JLabel) pane.getComponent(0);
		if (!gui.isSelected()) {
			java.awt.Rectangle unselectedBound = modified.getBounds();
			modified.setBounds(unselectedBound.x + 10, unselectedBound.y - 10, unselectedBound.width,
					unselectedBound.height);
			modified.repaint();
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtIndex(SelectedIndex);
			gui.setSelectedtype(1);
		} else if (gui.isSelected() && gui.getSelectedPanel() == pane) {
			java.awt.Rectangle selectedBound = modified.getBounds();
			modified.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			modified.repaint();
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtIndex(-1);
			gui.setSelectedtype(-1);
		}

		else {
			previousSelectedIndex = gui.getSelectedAtIndex(); // since this passed it will mean that index2 is the index
			// of the second tab selected

			if (gui.getSelectedtype() == 0) {
				Card previousSelectedCard = gameLogic.getTableaus(previousSelectedIndex).getCardStack().get(0);
				System.out.print(previousSelectedCard);
				System.out.print(gameLogic.getHomeCells(this.SelectedIndex).getHomecellStack().get(0));
				System.out.print(gameLogic.getHomeCells(this.SelectedIndex).checkNumber(previousSelectedCard));
				if (gameLogic.getHomeCells(this.SelectedIndex).checkNumber(previousSelectedCard)) { // if this pass it
																									// means it is legal
																									// move the
					// card(idk why its
					// not passing)

					gameLogic.getHomeCells(this.SelectedIndex).getHomecellStack().add(0, previousSelectedCard);
					gameLogic.getTableaus(previousSelectedIndex).getCardStack().remove(previousSelectedCard);
					gui.refresh();
				} else {// if it is illegal it prints this
					JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation_HomeCell");// shows that it
																										// failed
					gui.refresh();
				}
			}
			else {// if it is illegal it prints this
				JOptionPane.showMessageDialog(null, "Invaild Entry - Illegal Operation");// shows that it failed
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
