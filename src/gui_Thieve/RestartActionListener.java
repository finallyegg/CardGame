package gui_Thieve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ThieveGameLogic.Thieve;

public class RestartActionListener implements ActionListener{
	
	ThieveGUI gui;
	
	public RestartActionListener(ThieveGUI gui) {
		this.gui=gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		gui.setGameLogic(new Thieve());
		gui.refresh();
		gui.getstockpile().repaint();
		gui.getstockpile().revalidate();
		gui.setSelected(false);
	}

}
