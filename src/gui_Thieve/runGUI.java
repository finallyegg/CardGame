package gui_Thieve;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ThieveGameLogic.Thieve;

/**
 * @author TEAM
 * Run GUI
 */
public class runGUI {
	
	public static void runGame(){
		JFrame frame = new JFrame("Thieve");
		Thieve gameLogic = new Thieve();
		ThieveGui gameGUI = new ThieveGui(gameLogic);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(0, 128, 1));
		JPanel homcellpile = gameGUI.getHomcellPanel();
		homcellpile.setBounds(330, 10, 850, 500);
		frame.getContentPane().add(homcellpile);
		
		JPanel stockpile = gameGUI.getstockpile();
		stockpile.setBounds(155, 10, 73, 97);
		
		JLayeredPane wastePanel = gameGUI.getWastePile();
		wastePanel.setBounds(155, 127, 103, 107);
		wastePanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 5));
		
		JPanel tableauPile = gameGUI.getLowerTableauPanel();
		tableauPile.setBounds(0, 520, 1500, 250);
		
		JPanel restart = gameGUI.getMiddle_S_W_Panel();
		restart.setBounds(1400, 10, 70, 25);
		
		frame.getContentPane().add(gameGUI.getLowerTableauPanel());
		frame.getContentPane().add(stockpile);
		frame.getContentPane().add(wastePanel);
		frame.getContentPane().add(tableauPile);
		frame.getContentPane().add(restart);
		frame.setSize(1500, 800);
 	   
    	
    	   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    	   
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
	        public void run() {
	        	
				runGame();
	        
			}
		});
	}
}

