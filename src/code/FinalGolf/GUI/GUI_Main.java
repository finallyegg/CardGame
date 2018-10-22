package code.FinalGolf.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import code.FinalGolf.Golf_Game;

public class GUI_Main {
	public static void runGUI(){
		JFrame frame = new JFrame("Golf_Relaxed");
		Golf_Game golfLogic = new Golf_Game();
		Golf_GUI gui = new Golf_GUI(golfLogic);
		frame.getContentPane().add(gui.getTabluePanel(), BorderLayout.NORTH);
//		frame.getContentPane().add(gui.getChoicesPanel(), BorderLayout.CENTER);
		frame.getContentPane().add(gui.getlowerPanel());
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
