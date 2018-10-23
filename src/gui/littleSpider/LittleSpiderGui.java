package gui.littleSpider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


import code.Deck.Card;
import code.FinalGolf.GUI.Tools;
import code.littleSpider.LittleSpider;

public class LittleSpiderGui {
	private LittleSpider ls;
	private JPanel tab;
	private JPanel home;
	 //for Tab cards

	
	
	
	public LittleSpiderGui(LittleSpider idk) {
		ls = idk;
		tab = new JPanel();
		home = new JPanel();
	
		

	}
	
		
	public void setTableaus() {
	}
	
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
		tab.setBackground(Color.BLACK);
return tab;
	}
	
	
		
	
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
			
			homecellpile[i].add(image);
			home.add(homecellpile[i]);
		}
		home.setBackground(Color.PINK);
return home;

}
}
	
