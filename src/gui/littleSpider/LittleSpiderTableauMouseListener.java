package gui.littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import code.Deck.Card;
import code.FinalGolf.GUI.Tools;
import code.littleSpider.LittleSpider;

public class LittleSpiderTableauMouseListener implements MouseListener{

	private LittleSpiderGui gui;
	private JLayeredPane pane;
	private int index;
	private JLayeredPane pane2;
	private int index2;
	private LittleSpider gameLogic = new LittleSpider();
	private boolean mover = false;
	
	
	public LittleSpiderTableauMouseListener(LittleSpiderGui g, JLayeredPane p, int idx) {
		this.gui = g;
		this.pane = p;
		this.index = idx;
		pane2 = new JLayeredPane();
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel mod = (JLabel) pane.getComponent(0);
		mover = true;
		if(!gui.isSelected()) {
			java.awt.Rectangle uB = mod.getBounds();
			mod.setBounds(uB.x + 10, uB.y - 10, uB.width, uB.height);
			mod.repaint();
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtTableauIndex(index);
		} 
		else if (gui.isSelected() && gui.getSelectedPanel() == pane) {
			
			java.awt.Rectangle selectedBound = mod.getBounds();
			mod.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			mod.repaint();
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtTableauIndex(-1);
		}
		
		//added check logic
		else if(mover) { // if this runs it means that there is already something clicked
			index2 = gui.getSelectedAtTablue_index();	//since this passed it will mean that index2 is the index of the second tab selected
			Card selectedCard = new Card(gameLogic.getTableaus(index).cardAtIndex(0).getRank(),gameLogic.getTableaus(index).cardAtIndex(0).getSuit());
			//selectedCard is the card value of mod(for some reason this gives an error)
			if(gameLogic.getTableaus(index2).checkNumber(selectedCard)) { // if this pass it means it is legal to move the card(idk why its not passing)
				pane2.add(mod);// add the JLabel if its card value is legal to move
				pane.remove(mod);// remove that JLabel from the first pane selected
				JOptionPane.showMessageDialog(null, "Valid Entry - Pass"); // shows that it works
				gui.getTableaus().repaint();
			}
			else {//if it is illegal it prints this
				JOptionPane.showMessageDialog(null, "Invaild Entry - Failed");//shows that it failed
				
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
