package gui_Thieve;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import ThieveGameLogic.Thieve;
import gui_Thieve.ThieveGui.selectedType;

public class wastePileListener implements MouseListener {

	private ThieveGui GUI;
	@SuppressWarnings("unused")
	private Thieve gameLogic;
	private JLayeredPane Pane;

	public wastePileListener(Thieve gameLogic, ThieveGui gui, JLayeredPane Pane) {
		this.gameLogic = gameLogic;
		this.GUI = gui;
		this.Pane = Pane;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (GUI.isSelected() && GUI.getWhereSelected() == selectedType.WASTE) {
			JLabel topCardLabel = (JLabel) Pane.getComponent(0);
			java.awt.Rectangle original = topCardLabel.getBounds();
			topCardLabel.setBounds(original.x - 10, original.y - 10, original.width, original.height);
			GUI.setSelected(false);
			GUI.setWhereSelected(selectedType.EMPTY);
			topCardLabel.repaint();
		} else if (!GUI.isSelected()) {
			JLabel topCardLabel = (JLabel) Pane.getComponent(0);
			java.awt.Rectangle u = topCardLabel.getBounds();
			topCardLabel.setBounds(u.x + 10, u.y + 10, u.width, u.height);
			GUI.setSelected(true);
			GUI.setWhereSelected(selectedType.WASTE);
			topCardLabel.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Invaild Entry - Could Not Add Card to WASTE PILE");
			GUI.refresh();
		}
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
