package code.FinalGolf.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import code.Deck.Card;
import code.FinalGolf.Golf_Game;

public class GolfStockMouseListener implements MouseListener {

	private Golf_GUI gui;
	private JLabel pane;
	private Golf_Game gameLogic;

	public GolfStockMouseListener(Golf_Game game, Golf_GUI gui, JLabel panel) {
		this.gui = gui;
		this.pane = panel;
		gameLogic = game;
	}
		// we use Hertz's photo as Card's Back
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		pane.setIcon(Tools.getMatthewIcon(0));

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		pane.setIcon(Tools.getMatthewIcon(1));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		pane.setIcon(Tools.getMatthewIcon(0));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// do the operation
		pane.setIcon(Tools.getMatthewIcon(1));
		Card card = gameLogic.getStockPile().getStockStack().get(0);
		gameLogic.getHomeCell().addCard(card);
		gameLogic.getStockPile().RemoveCard(card);
		gui.refresh();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		pane.setIcon(Tools.getMatthewIcon(1));

	}

}
