package menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import code.FinalGolf.Golf_Game;
import code.FinalGolf.GUI.GUI_Main;
import code.FinalGolf.GUI.Golf_GUI;

public class TwoGame_Menu {
	public static void runGUI(){
		JFrame frame = new JFrame("Two Game");
		Golf_Game golfLogic = new Golf_Game();
		Golf_GUI gui = new Golf_GUI(golfLogic);
		
		JLabel label = new JLabel("Hello");
		JPanel panel = new JPanel();
		frame.add(label);
		frame.add(panel);
		    JButton button = new JButton("GolfGame");
		    button.addActionListener(new ActionListener(){
		        @Override
		        public void actionPerformed(ActionEvent e){
		            GUI_Main.runGUI();
		        }
		    });
		panel.add(button);    
		frame.add(panel);
		frame.setSize(800,400);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        frame.pack();
        
       
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
