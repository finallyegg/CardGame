package gui.littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class LittleSpiderTableauMouseListener implements MouseListener{

	private LittleSpiderGui gui;
	private JLayeredPane pane;
	private int index;
	
	public LittleSpiderTableauMouseListener(LittleSpiderGui g, JLayeredPane p, int idx) {
		this.gui = g;
		this.pane = p;
		this.index = idx;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel mod = (JLabel) pane.getComponent(0);
		if(!gui.isSelected()) {
			java.awt.Rectangle uB = mod.getBounds();
			mod.setBounds(uB.x + 10, uB.y - 10, uB.width, uB.height);
			mod.repaint();
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtTableauIndex(index);
		} else if (gui.isSelected() && gui.getSelectedPanel() == pane) {
			java.awt.Rectangle selectedBound = mod.getBounds();
			mod.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			mod.repaint();
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtTableauIndex(-1);
		}
		
		else if (gui.isSelected() && gui.getSelectedPanel() != pane) { 
			
			JOptionPane.showMessageDialog(null, "Invaild Entry - Cannot add card to tabluepile");
			
			
			gui.refresh();
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
