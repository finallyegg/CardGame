package gui.littleSpider;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import code.littleSpider.LittleSpider;

public class runGui {

		public static void runGUI(){
			LittleSpider ls = new LittleSpider();
			
        	JFrame frame = new JFrame("Little Spider");
        	LittleSpiderGui lol = new LittleSpiderGui(ls);
    	    frame.setSize(1000, 600);
    	   
    	    
    	    frame.getContentPane().add(lol.getTableaus(),  BorderLayout.SOUTH);
    	    frame.getContentPane().add(lol.getHome(),  BorderLayout.NORTH);
    	  
    	   
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

