package code.FinalGolf.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import com.sun.javafx.geom.Rectangle;

import code.FinalGolf.Golf_Game;

public class GolfTablueauMouseListener implements MouseListener {

	private Golf_GUI gui;
	private JLayeredPane pane;
	private Golf_Game gameLogic;
	private int index;

	public GolfTablueauMouseListener(Golf_Game gameLogic, Golf_GUI gui, JLayeredPane Pane, int tablue_index) {
		this.gameLogic = gameLogic;
		this.gui = gui;
		this.pane = Pane;
		this.index = tablue_index;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel modified = (JLabel) pane.getComponent(0);
		if (!gui.isSelected()) {
			java.awt.Rectangle unselectedBound = modified.getBounds();
			modified.setBounds(unselectedBound.x + 10, unselectedBound.y - 10, unselectedBound.width,
					unselectedBound.height);
			modified.repaint();
			gui.setSelected(true);
			gui.setSelectedPanel(pane);
			gui.setSelectedAtTablue_index(index);
		} else if (gui.isSelected() && gui.getSelectedPanel() == pane) {
			java.awt.Rectangle selectedBound = modified.getBounds();
			modified.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			modified.repaint();
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtTablue_index(-1);
		}

		else if (gui.isSelected() && gui.getSelectedPanel() != pane) {
			JLayeredPane selectedpane = (JLayeredPane) gui.getSelectedPanel();
			modified = (JLabel) selectedpane.getComponent(0);
			java.awt.Rectangle selectedBound = modified.getBounds();
			modified.setBounds(selectedBound.x - 10, selectedBound.y + 10, selectedBound.width, selectedBound.height);
			modified.repaint();
			JOptionPane.showMessageDialog(null, "Invaild Entry - Cannot add card to tabluepile");
			gui.setSelected(false);
			gui.setSelectedPanel(null);
			gui.setSelectedAtTablue_index(-1);
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
