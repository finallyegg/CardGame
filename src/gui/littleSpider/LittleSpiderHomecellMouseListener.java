package gui.littleSpider;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import code.Deck.Card;
import code.littleSpider.Homecells;
import code.littleSpider.LittleSpider;
import code.littleSpider.Tableaus;

public class LittleSpiderHomecellMouseListener implements MouseListener{
	
	private LittleSpiderGui gui;
	private JLabel pane;
	private LittleSpider gameLogic;
	private Homecells homecell;
	
	public LittleSpiderHomecellMouseListener(LittleSpider game, LittleSpiderGui gui, JLabel panel) {
		this.gui = gui;
		this.pane = panel;
		gameLogic = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
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
		Card card = gameLogic.getHomeCells(0).getCard(0);
		if(gameLogic.moveToHomecell(card, gameLogic.getHomeCells(0));)


	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
