package code.FinalGolf.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import code.FinalGolf.Golf_Game;

public class GUI_Main {
	public static void runGUI(){
		JFrame frame = new JFrame("GUI");
		Golf_Game golfGame = new Golf_Game();
		GUI gui = new GUI(gamemodelinput);
		frame.getContentPane().add(gui.getWordPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(gui.getChoicesPanel(), BorderLayout.CENTER);
		frame.getContentPane().add(gui.getScorePanel(), BorderLayout.SOUTH);
		frame.setSize(500,140);
		frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public static void main(String[] args){
		
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	runGUI();
            }
        });
    }
}
