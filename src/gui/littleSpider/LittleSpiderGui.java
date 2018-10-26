package gui.littleSpider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import code.Deck.Card;
import code.FinalGolf.GUI.Tools;
import code.littleSpider.LittleSpider;

public class LittleSpiderGui {
	//Important
	private LittleSpider ls;
	private JPanel tab;
	private JPanel home;
	
	//For Fun
	private JButton spider = new JButton("Have Fun");
	private JPanel test = new JPanel();
	private JButton gotem = new JButton("Gotem");
	private JLabel up = new JLabel();
	private JLabel joke = new JLabel();
	private JLabel ok = new JLabel();
	private JButton hah = new JButton("Alright I'll Stop");
	private LittleSpider gameLogic;
	private boolean selected;
	private JLayeredPane selectedPanel;
	private int selectedAtTableauIndex;
	private boolean selected2;
	private JLayeredPane selectedPanel2;
	private int selectedAtHomecellIndex;
	

	
	
	
	public LittleSpiderGui(LittleSpider idk) {
		ls = idk;
		tab = new JPanel();
		home = new JPanel();
		setSelected(false);
		selectedPanel = null;
		test.add(spider);
		
	}
	
		//for meme
	public JPanel getTest() {
		gotem.setVisible(false);
		hah.setVisible(false);
		test.add(getSpider());
		test.add(getGottem());
		test.add(getNormal());
		
		test.setBackground(Color.green);
		return test;
	}
	//Set up tableaus
	public JPanel getTableaus() {
		JLayeredPane[] tabluepiles = new JLayeredPane[8];
		for (int i = 0; i < 8; i++) {
			tabluepiles[i] = new JLayeredPane();
			Dimension layeredPaneSize = new Dimension(100,300);
			tabluepiles[i].setPreferredSize(layeredPaneSize);

			tabluepiles[i].setBorder(BorderFactory.createTitledBorder("Tablue Piles"));
			Point origin = new Point(10, 0);

			if (ls.getTableaus(i).getCardStack().isEmpty()) {
				tabluepiles[i].add(Tools.getCardLabel(new Card(null, null)));
			} else {
				for (int a = ls.getTableaus(0).getCardSize() - 1; a >= 0; a--) {
					Card card = ls.getTableaus(i).getCardStack().get(a);
					JLabel image = Tools.getCardLabel(card);

					image.setBounds(origin.x, origin.y, image.getWidth(), image.getHeight());
					origin.x = origin.x;
					origin.y += 20;
					
					tabluepiles[i].add(image, 0);
				}
			}
			tabluepiles[i].setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
			tab.add(tabluepiles[i]);
		}
		
		tab.setBackground(Color.PINK);
		
		for(int i = 0; i < 8; i++) {
			if(!gameLogic.getTableaus(i).getCardStack().isEmpty()) {
				tabluepiles[i].addMouseListener(new LittleSpiderTableauMouseListener(this, tabluepiles[i], i));
			}
		}
		
		
		return tab;
	}
		//Setup Home
	public JPanel getHome() {
		JLayeredPane[] homecellpile = new JLayeredPane[4];
		for(int i = 0; i< 4; i++) {
			homecellpile[i] = new JLayeredPane();
			Dimension layeredPaneSize = new Dimension(100,300);
			homecellpile[i].setPreferredSize(layeredPaneSize);
			Point origin = new Point(0,0);
			JLabel image = Tools.getCardLabel(ls.getHomeCells(i).getHomecellStack().get(0));
			image.setBounds(origin.x, origin.y, image.getWidth(), image.getHeight());
			origin.x = origin.x;
			origin.y += 20;
			homecellpile[i].add(image, 0);
			
			home.add(homecellpile[i]);
		}
		home.setBackground(Color.DARK_GRAY);
		return home;

}
	//Fun
		public  JButton getSpider() {
			 spider.addActionListener(new ActionListener(){
			        @Override 
			        public void actionPerformed(ActionEvent e){
			        	try{
			        		ImageIcon image1 = null;
			                String longURL = "https://www.ivanyolo.com/wp-content/uploads/2018/09/xthe-nun-valak-jumpscare.jpg.pagespeed.ic.pS2l8S3KEK.jpg";
			                URL url = new URL(longURL);
			                image1 = new ImageIcon(url);
			                up = new JLabel(image1);	              
			               home.setVisible(false);
			               tab.setVisible(false);
			               gotem.setVisible(true);
			               test.add(gotem);
			               	test.add(up);
			               	spider.setVisible(false);
			               		test.setBackground(Color.BLACK);
			             hah.setVisible(false);
			        	}catch(MalformedURLException e1){
			                e1.printStackTrace();
			            }
			        }
			    });		   
		    return spider;
		  }
		//Fun
	public JButton getGottem() {
		gotem.addActionListener(new ActionListener(){
	        @Override 
	        public void actionPerformed(ActionEvent e){
	        	try{
	        		hah.setVisible(true);
	        		ImageIcon pop = null;
	        		ImageIcon pop1 = null;
	        		String lmao = "https://i.imgur.com/BW3KLWl.jpg";
	               String lmao1 = "https://i.kym-cdn.com/photos/images/original/001/170/001/c44.png";
	               URL url = new URL(lmao1);
	               URL url1 = new URL(lmao);
	               pop = new ImageIcon(url1);
	               pop1 = new ImageIcon(url);	               
	               ok = new JLabel(pop1);               
	               test.setBackground(Color.CYAN);
	               home.setVisible(false);
	               tab.setVisible(false);                        
	            joke = new JLabel(pop);
	            test.add(ok);
	            	test.remove(up);
	               test.add(hah);
	               	test.add(joke);
	               	gotem.setVisible(false);
	               	spider.setVisible(false);
	        	}catch(MalformedURLException e1){
	                e1.printStackTrace();
	        	}
	        }
	    });
   return gotem;
	}
	//Turn Fun Back to Normal
	public JButton getNormal() {
		hah.addActionListener(new ActionListener(){
	        @Override 
	        public void actionPerformed(ActionEvent e){
	        	test.remove(ok);
	        	test.remove(up);
	        	test.remove(joke);
	        test.setBackground(Color.LIGHT_GRAY);	
	        tab.setVisible(true);
	        home.setVisible(true);
	        hah.setVisible(false);   	
	}	
		 });
	return hah;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean b) {
		this.selected = b;
		
	}

	public void setSelectedPanel(JLayeredPane pane) {
		this.selectedPanel = pane;
		
	}

	public void setSelectedAtTableauIndex(int index) {
		this.selectedAtTableauIndex = index;
		
	}

	public JLayeredPane getSelectedPanel() {
		return selectedPanel;
	}
	
	public int getSelectedAtTablue_index() {
		return selectedAtTableauIndex;
	}
	
	public boolean isSelected2() {
		return selected2;
	}

	public void setSelected2(boolean b) {
		this.selected2 = b;
		
	}

	public void setSelectedPanel2(JLayeredPane pane) {
		this.selectedPanel2 = pane;
		
	}

	public void setSelectedAtHomecellIndex(int index) {
		this.selectedAtHomecellIndex = index;
		
	}

	public JLayeredPane getSelectedPanel2() {
		return selectedPanel2;
	}
	
	public int getSelectedAtHomecellIndex() {
		return selectedAtHomecellIndex;
	}
	
	public void refresh() {
		getHome().revalidate();
		getHome().repaint();
		getTableaus().revalidate();
		getTableaus().repaint();
		selected = false;
		selectedAtTableauIndex = -1;
		selectedPanel = null;
		selected2 = false;
		selectedAtHomecellIndex = -1;
		selectedPanel2 = null;
		
	}
	
	
	
	
	
	
}
	
