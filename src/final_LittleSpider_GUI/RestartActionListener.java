package final_LittleSpider_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.littleSpider.LittleSpider;

public class RestartActionListener implements ActionListener{
	
	LittleSpiderGui gui;
	
	public RestartActionListener(LittleSpiderGui gui) {
		this.gui=gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		gui.setGameLogic(new LittleSpider());
		gui.refresh();
	}

}
