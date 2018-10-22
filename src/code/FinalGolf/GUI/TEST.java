package code.FinalGolf.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import code.FinalGolf.Golf_Game;

public class TEST {
	public static void runGUI(){
		JFrame frame = new JFrame("Golf_Relaxed");
		frame.setSize(800,700);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
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
