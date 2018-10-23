package code.FinalGolf.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Point;

import javax.swing.*;

import code.Deck.Card;
import code.FinalGolf.*;

public class Golf_GUI {
	private JPanel tabluesPanel;
	private JPanel lowerPanel;
	private Golf_Game gameLogic;
	private boolean selected;
	private JLayeredPane selectedPanel;
	private int selectedAtTablue_index;

	public Golf_GUI(Golf_Game GL) {
		gameLogic = GL;
		tabluesPanel = new JPanel();
		tabluesPanel.removeAll();
		Color backgroundCol = new Color(0, 128, 1);
		tabluesPanel.setBackground(backgroundCol);
		tabluesPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 0, 40));
		lowerPanel = new JPanel();
		lowerPanel.setBackground(backgroundCol);
		lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 30, 40));
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 0));
		setSelected(false);
		selectedPanel=null;
	}

	public JPanel getTabluePanel() {
		tabluesPanel.removeAll();
		JLayeredPane[] tabluepiles = new JLayeredPane[7];
//		Card x = new Card(Card.Ranks.EIGHT,Card.Suits.HEARTS);
//		tabluesPanel.add(Tools.getCardLabel(x));

//		JPanel P1 = new JPanel();
//		P1.setLayout(new BoxLayout(P1, BoxLayout.Y_AXIS));
//		for (int a = gameLogic.getTablueStackSize(0)-1; a>=0; a--) {
//			Card card = gameLogic.getTableaus(0).getTablestack().get(a);
//			JLabel image = Tools.getCardLabel(card);
//			P1.add(image);
//		}
		for (int i = 0; i < 7; i++) {
			tabluepiles[i] = new JLayeredPane();
			Dimension layeredPaneSize = new Dimension(90, 190);
			tabluepiles[i].setPreferredSize(layeredPaneSize);
//			tabluepiles[i].setLayout(new BoxLayout(tabluepiles[i], BoxLayout.Y_AXIS));
			tabluepiles[i].setBorder(BorderFactory.createTitledBorder("Tablue Piles"));
			Point origin = new Point(0, 0);

			if (gameLogic.getTableaus(i).getTablestack().isEmpty()) {
				tabluepiles[i].add(Tools.getCardLabel(new Card(null, null)));
			} else {
				for (int a = gameLogic.getTablueStackSize(i) - 1; a >= 0; a--) {
					Card card = gameLogic.getTableaus(i).getTablestack().get(a);
					JLabel image = Tools.getCardLabel(card);

					image.setBounds(origin.x, origin.y, image.getWidth(), image.getHeight());
					origin.x = origin.x;
					origin.y += 20;
//					cardPanel = new JLayeredPane();
//					cardPanel.add(image);
//					cardPanel.setSize(40, 40);

//					image.setBorder(BorderFactory.createEmptyBorder(-10,-10,-10,-10));
					tabluepiles[i].add(image, 0);

				}
			}
			tabluepiles[i].setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
			tabluesPanel.add(tabluepiles[i]);
		}
		
		int tablue_index = -1;
		for (int i = 0; i < 7; i++) {
			tablue_index +=1;
			if (gameLogic.getTableaus(i).getTablestack().isEmpty()) {
//				tabluepiles[i].addMouseListener(new GolfHomeCellMouseListener());
//				tabluepiles[i].getComponent(compomentCount-1).addMouseListener(new GolfMouseListener(null, null, null));
			}
			else {
				tabluepiles[i].addMouseListener(new GolfTablueauMouseListener(gameLogic,this,tabluepiles[i],tablue_index));
			}
		}
		return tabluesPanel;
	}

	public JPanel getlowerPanel() {
		lowerPanel.removeAll();
		JPanel stockpile = new JPanel();
		stockpile.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
		stockpile.setMinimumSize(new Dimension(73, 97));
		if (!gameLogic.getStockPile().getStockStack().isEmpty()) {
			JLabel mp = new JLabel();
			mp.setIcon(Tools.getMatthewIcon(0));
			mp.addMouseListener(new GolfStockMouseListener(gameLogic, this, mp));
			mp.setBounds(0, 0, mp.getWidth(), mp.getHeight());
			stockpile.add(mp);
		} else {
			JLabel mp = Tools.getEmptyCardLabel(0);
			stockpile.add(mp);

		}

//		Dimension stockPaneSize = new Dimension(73, 97);
//		stockpile.setPreferredSize(stockPaneSize);
//		stockpile.addMouseListener(new GolfStockMouseListener(this,stockpile));
		lowerPanel.add(stockpile);

//		lowerPanel.add(Tools.getEmptyCardLabel(1));
//		lowerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLayeredPane homeCellPile = new JLayeredPane();
//		Dimension homePaneSize = new Dimension(550, 97);
		homeCellPile.setPreferredSize(new Dimension(550, 97));
		Point inital = new Point(0, 0);
		if (!gameLogic.getHomeCell().getHomecellstack().isEmpty()) {
			homeCellPile.removeAll();
			for (int i = gameLogic.getHomeCell().getHomecellstack().size() - 1; i >= 0; i--) {
				Card card = gameLogic.getHomeCell().getHomecellstack().get(i);
				JLabel image = Tools.getCardLabel(card);
				image.setBounds(inital.x, inital.y, image.getWidth(), image.getHeight());
				inital.y = inital.y;
				inital.x += 13;
//				image.addMouseListener(new GolfHomeCellMouseListener(gameLogic,this));
				homeCellPile.add(image, 0);
			}
		} else {
			homeCellPile.add(Tools.getEmptyCardLabel(0));
		}
		lowerPanel.add(homeCellPile);
		return lowerPanel;
	}

	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this.getlowerPanel());
		SwingUtilities.updateComponentTreeUI(this.getTabluePanel());
	}

	
	public Component getSelectedPanel() {
		return selectedPanel;
	}

	public void setSelectedPanel(JLayeredPane selectedPanel) {
		this.selectedPanel = selectedPanel;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getSelectedAtTablue_index() {
		return selectedAtTablue_index;
	}

	public void setSelectedAtTablue_index(int selectedAtTablue_index) {
		this.selectedAtTablue_index = selectedAtTablue_index;
	}
	
	
}
