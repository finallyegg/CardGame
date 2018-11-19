package code.FinalGolf.GUI;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class GolfTableauMouseListener implements MouseListener {

	private Golf_GUI gui;
	private JLayeredPane pane; // by which panel you clicked
	private int index; // index is for tableau index 

	public GolfTableauMouseListener(Golf_GUI gui, JLayeredPane Pane, int tablue_index) {
		this.gui = gui;
		this.pane = Pane;
		this.index = tablue_index;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel modified = (JLabel) pane.getComponent(0);
		// see if Golf_GUI have any selected cards
		if (!gui.isSelected()) {  // if no card been selected yet
			// make first card "pop up" by change its bounds
			java.awt.Rectangle unselectedBound = modified.getBounds();
			modified.setBounds(unselectedBound.x + 10, unselectedBound.y - 10, unselectedBound.width,
					unselectedBound.height);
			System.out.print(pane.getComponent(0).getBounds());
			modified.repaint();
			// set GUI fields property
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtTablue_index(index);
		} else if (gui.isSelected() && gui.getSelectedPanel() == pane) { // if has card been selected, and clicked on the same selected panel,unselected it
			// make first card de-"pop up" by change its bounds
			java.awt.Rectangle selectedBound = modified.getBounds();
			modified.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			modified.repaint();
			System.out.print(pane.getComponent(0).getBounds());
			// set GUI fields property
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtTablue_index(-1);
		}

		else if (gui.isSelected() && gui.getSelectedPanel() != pane) { // if has card been selected, we select a different panel, it will be illegal to add cards to tableau 
			
			JOptionPane.showMessageDialog(null, "Invaild Entry - Cannot add card to tabluepile");
			
			// set GUI fields property
			gui.refresh();
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
