package gui.littleSpider;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.littleSpider.LittleSpider;

public class LittleSpiderGui {
	private LittleSpider ls;
	
	
	
	public static JFrame gameStart() {
		JFrame frame = new JFrame("Little Spider");
	    frame.setSize(1000, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    

	    return frame;
	    
	    
	    
	}
	
	
	public static void main(String[] args){
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	gameStart();
	        
	        }
	    });
	}
}
