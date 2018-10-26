package gui.littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import code.Deck.Card;
import code.littleSpider.Homecells;
import code.littleSpider.LittleSpider;
import code.littleSpider.Tableaus;

public class LittleSpiderHomecellMouseListener implements MouseListener{
	
	private LittleSpiderGui gui;
	private JLayeredPane pane;
	
	private int index; 
	
	private LittleSpider gameLogic;

	public LittleSpiderHomecellMouseListener(LittleSpiderGui gui, JLayeredPane Pane, int idx, LittleSpider game) {
		this.gui = gui;
		this.pane = Pane;
		this.index = idx;
	
		this.gameLogic = game;
	
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel modified = (JLabel) pane.getComponent(0);
		if (!gui.isSelected2()) { 
			java.awt.Rectangle unselectedBound = modified.getBounds();
			modified.setBounds(unselectedBound.x + 10, unselectedBound.y - 10, unselectedBound.width,
					unselectedBound.height);
			modified.repaint();
			gui.setSelected2(true);
			gui.setSelectedPanel2(pane);
			gui.setSelectedAtHomecellIndex(index);
		} else if (gui.isSelected2() && gui.getSelectedPanel2() == pane) {
			java.awt.Rectangle selectedBound = modified.getBounds();
			modified.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			modified.repaint();
			gui.setSelected2(false);
			gui.setSelectedPanel2(null);
			gui.setSelectedAtHomecellIndex(-1);
		}
		
		
		
		else if (gui.isSelected2() && gui.getSelectedPanel2() != pane) {
			JOptionPane.showMessageDialog(null, "Invaild Entry - Cannot add card to Homecell");
			
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
		Card card = gameLogic.getTableaus(gui.getSelectedAtTablue_index()).cardAtIndex(0);
		if(gameLogic.moveToHomecell(card, gameLogic.getHomeCells(gui.getSelectedAtHomecellIndex()))){
			gameLogic.getTableaus(gui.getSelectedAtTablue_index());
		}
		


	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
