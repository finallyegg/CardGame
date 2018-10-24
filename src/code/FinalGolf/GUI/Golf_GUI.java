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
	private JPanel upperPanel;		// tabluesPanel has 7 tableau piles
	private JPanel lowerPanel;			// lower Panel has one stock pile and one homecell pile
	private Golf_Game gameLogic;
	private boolean selected;			// store a boolean value of whether there existed a selected pane
	private JLayeredPane selectedPanel;	// store tableau panel which been selected
	private int selectedAtTablue_index; // store tableau index which been selected

	public Golf_GUI(Golf_Game GL) {
		gameLogic = GL;
		upperPanel = new JPanel();
		Color backgroundCol = new Color(0, 128, 1); // setting color
		upperPanel.setBackground(backgroundCol);
		upperPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 0, 40)); // setting border
		lowerPanel = new JPanel();
		lowerPanel.setBackground(backgroundCol); // setting color
		lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 30, 40));
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 0));
		setSelected(false);	// initialized
		selectedPanel=null;
	}

	public JPanel getUpperPanel() {
		upperPanel.removeAll(); // refresh function
		JLayeredPane[] tabluePanes = new JLayeredPane[7]; // 7 JLayeredPane, each for one tableau piles

		for (int i = 0; i < 7; i++) {
			tabluePanes[i] = new JLayeredPane();
			Dimension layeredPaneSize = new Dimension(90, 190); // set each tableauPane Size 
			tabluePanes[i].setPreferredSize(layeredPaneSize);
			tabluePanes[i].setBorder(BorderFactory.createTitledBorder("Tablue Piles")); // No idea why this does not work
			Point origin = new Point(0, 0); // Because each Card is not exactly on top of previous, we need assign each card a coordinate

			if (gameLogic.getTableaus(i).getTablestack().isEmpty()) {
				tabluePanes[i].add(Tools.getEmptyCardLabel(0)); //get a green label for empty pane 
			} else {
				for (int a = gameLogic.getTablueStackSize(i) - 1; a >= 0; a--) { // loop through every card of a card stack
					Card card = gameLogic.getTableaus(i).getTablestack().get(a);
					JLabel image = Tools.getCardLabel(card); // get Card Label
					image.setBounds(origin.x, origin.y, image.getWidth(), image.getHeight());
					origin.x = origin.x;			//increase coordinate
					origin.y += 20;
					tabluePanes[i].add(image, 0); // Add Card to the top of the tabluePane

				}
			}
			tabluePanes[i].setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 5));
			upperPanel.add(tabluePanes[i]);
		}
		
		// Add Tableau Mouse Listener
		for (int i = 0; i < 7; i++) {
			if (!gameLogic.getTableaus(i).getTablestack().isEmpty()) { // only when the stack is not empty
				tabluePanes[i].addMouseListener(new GolfTableauMouseListener(this,tabluePanes[i],i));
			}
		}
		return upperPanel;
	}

	public JPanel getlowerPanel() {
		
		lowerPanel.removeAll(); // refresh function
		JPanel stockPile = new JPanel(); // Declare new JPanel
		stockPile.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
		stockPile.setMinimumSize(new Dimension(73, 97));
		if (!gameLogic.getStockPile().getStockStack().isEmpty()) { // if stockPile is not empty, show icon
			JLabel matthewIcon = new JLabel();
			matthewIcon.setIcon(Tools.getMatthewIcon(0));
			matthewIcon.addMouseListener(new GolfStockMouseListener(gameLogic, this, matthewIcon));
			matthewIcon.setBounds(0, 0, matthewIcon.getWidth(), matthewIcon.getHeight());
			stockPile.add(matthewIcon);
		} else { // if empty, add empty Icon
			JLabel green = Tools.getEmptyCardLabel(0);
			stockPile.add(green);
		}
		lowerPanel.add(stockPile);
		
		
		JLayeredPane homeCellPile = new JLayeredPane(); // Initialize HomeCellPile
		
		homeCellPile.setPreferredSize(new Dimension(550, 97));
		Point inital = new Point(0, 0); //inital coordinate
		if (!gameLogic.getHomeCell().getHomecellstack().isEmpty()) {
			homeCellPile.removeAll(); // refresh function
			for (int i = gameLogic.getHomeCell().getHomecellstack().size() - 1; i >= 0; i--) { //loop through homeCell Stack
				Card card = gameLogic.getHomeCell().getHomecellstack().get(i);
				JLabel image = Tools.getCardLabel(card);
				image.setBounds(inital.x, inital.y, image.getWidth(), image.getHeight());
				inital.y = inital.y;
				inital.x += 13;
				image.addMouseListener(new TESTMouseListener(gameLogic,this));
				homeCellPile.add(image, 0);
			}
		} else {
			homeCellPile.add(Tools.getEmptyCardLabel(0)); // add empty Picture
		}
		lowerPanel.add(homeCellPile);
		return lowerPanel;
	}

	public void refresh() {
		getUpperPanel().revalidate();
		getUpperPanel().repaint();
		getlowerPanel().revalidate();
		getlowerPanel().repaint();
		selected=false;
		selectedAtTablue_index=-1;
		selectedPanel=null;
	}
	
	public void setUpperPanel (JPanel Panel) {
		this.upperPanel = Panel;
	}
	
	public void setLowerPanel (JPanel Panel) {
		this.lowerPanel = Panel;
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
