package code.FinalGolf.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import code.FinalGolf.Golf_Game;

public class HomecellMouseLestner  implements MouseListener{
	private Golf_Game gamelogic;
	private Golf_GUI golfgui;
	
	public HomecellMouseLestner(Golf_Game logic, Golf_GUI golffgui ) {
		gamelogic = logic;
		golfgui = golffgui;
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean popnewjpane = false;
		if(golfgui.isSelected() == popnewjpane) {
			System.out.println("error");
		}
		else {
			gamelogic.getTablueStackSize(golfgui.getSelectedAtTablue_index());
			
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
