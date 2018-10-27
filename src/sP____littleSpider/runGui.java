package sP____littleSpider;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import code.littleSpider.LittleSpider;

public class runGui {
	public static void runGUI(){
		JFrame frame = new JFrame("Little Spider");
		LittleSpider ls = new LittleSpider();
		LittleSpiderGui lol = new LittleSpiderGui(ls);

		frame.getContentPane().add(lol.getTest(),BorderLayout.CENTER );
		frame.getContentPane().add(lol.getTableaus(),  BorderLayout.SOUTH);
		frame.getContentPane().add(lol.getHome(),  BorderLayout.NORTH);
		frame.setSize(1500, 900);
 	   
    	
    	   
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

