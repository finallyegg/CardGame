package gui_Thieve;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import ThieveGameLogic.Thieve;
import code.Deck.Card;
import code.FinalGolf.GUI.Tools;

/**
 * @author TEAM
 * 
 *          GUI
 * 
 */
public class ThieveGUI {
	// Important
	private Thieve gameLogic;
	private JPanel stockPanel;
	private JPanel middle_S_W_Panel;
	private JPanel lowerTableauPanel;
	private JLayeredPane wastePile;
	private JPanel homeCellPanel;
	private boolean isSelected;
	private JPanel bigPhoto;
	
	public enum selectedType {
		TABLEAU, WASTE, EMPTY
	}

	private selectedType whereSelected;
	private int selectedAtIndex;
	private JLayeredPane selectedPanel;
	private Color backgroundCol;
	/**
	 * Constructor
	 */
	public ThieveGUI(Thieve ThieveGameLogic) {
		gameLogic = ThieveGameLogic;
		stockPanel = new JPanel();
		setMiddle_S_W_Panel(new JPanel());
		lowerTableauPanel = new JPanel();
		homeCellPanel = new JPanel();
		wastePile = new JLayeredPane();
		setSelected(false);
		setSelectedPanel(null);
		setWhereSelected(selectedType.EMPTY);
		backgroundCol = new Color(0, 128, 1);
		selectedPanel = null;
		bigPhoto = new JPanel();
		
	}

	// Set up tableaus
	/**
	 * @return get Tableaus Panel
	 */
	public JPanel getLowerTableauPanel() {
		lowerTableauPanel.removeAll();
		lowerTableauPanel.setBackground(backgroundCol);
		JLayeredPane[] tabluepiles = new JLayeredPane[13];
		for (int i = 0; i < 13; i++) {
			tabluepiles[i] = new JLayeredPane();
			Dimension layeredPaneSize = new Dimension(100, 250);

			tabluepiles[i].setBorder(BorderFactory.createTitledBorder("Tablue Piles"));
			Point origin = new Point(0, 0);

			if (gameLogic.getTableaus(i).getCardStack().isEmpty()) {
				tabluepiles[i].add(Tools.getEmptyCardLabel(0));
			} else {
				for (int a = gameLogic.getTableaus(i).getCardSize() - 1; a >= 0; a--) {
					Card card = gameLogic.getTableaus(i).getCardStack().get(a);
					JLabel image = Tools.getCardLabel(card);

					image.setBounds(origin.x, origin.y, image.getWidth(), image.getHeight());
					origin.x = origin.x;
					origin.y += 16;

					tabluepiles[i].add(image, 0);
					
				}
				tabluepiles[i].addMouseListener(new TableauMouseListener(gameLogic, this,tabluepiles[i],i));
			}
			tabluepiles[i].setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 5));
			tabluepiles[i].setPreferredSize(layeredPaneSize);
			lowerTableauPanel.add(tabluepiles[i]);
		}
		return lowerTableauPanel;
	}

	/**
	 * @return WastePile Panel
	 */
	public JLayeredPane getWastePile() {

		wastePile.removeAll(); //// Initialize HomeCellPile
		if (!gameLogic.getWaste().isEmpty()) {
			for (int i = gameLogic.getWaste().size() - 1; i >= 0; i--) { // loop through homeCell Stack
				Card card = gameLogic.getWaste().get(i);
				JLabel image = Tools.getCardLabel(card);
				image.setBounds(0, 0, image.getWidth(), image.getHeight());
				
				wastePile.add(image, 0);
				image.addMouseListener(new wastePileListener(gameLogic, this,wastePile));
			}
		} else {
//			wastePile.add(Tools.getEmptyCardLabel(0)); // add empty Picture
		}
		return wastePile;
	}

	/**
	 * @return HomeCelll Panel
	 */
	public JPanel getHomcellPanel() {
		homeCellPanel.removeAll();
		homeCellPanel.setBackground(backgroundCol);
		JLayeredPane[] homecellpile = new JLayeredPane[8];
		for (int i = 0; i < 8; i++) {
			homecellpile[i] = new JLayeredPane();
			Dimension layeredPaneSize = new Dimension(100, 300);
			homecellpile[i].setPreferredSize(layeredPaneSize);
			Point origin = new Point(0, 0);
			if (gameLogic.getHomeCells(i).getHomecellStack().isEmpty()) {
				homecellpile[i].add(Tools.getEmptyCardLabel(0));
			} else {
				for (int a = gameLogic.getHomeCells(i).getHomecellStack().size() - 1; a >= 0; a--) {

					JLabel image = Tools.getCardLabel(gameLogic.getHomeCells(i).getHomecellStack().get(a));
					image.setBounds(origin.x, origin.y, image.getWidth(), image.getHeight());
					origin.x = origin.x;
					origin.y += 16;

					homecellpile[i].add(image, 0);

				}
				homecellpile[i].setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
				homecellpile[i].addMouseListener(new HomecellMouseListener(gameLogic, this,i));
				homeCellPanel.add(homecellpile[i]);
			}
		}
		return homeCellPanel;
	}

	/**
	 * @return StockPanel
	 */
	public JPanel getstockpile() {
		stockPanel.removeAll();
		stockPanel.setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
		stockPanel.setMinimumSize(new Dimension(73, 97));
		if (!gameLogic.getThieve().getStock().isEmpty()) { // if stockPile is not empty, show icon
			JLabel matthewIcon = new JLabel();
			matthewIcon= Tools.getEmptyCardLabel(2);
			matthewIcon.addMouseListener(new ThieveStockListener(gameLogic, this, matthewIcon));
			matthewIcon.setBounds(0, 0, matthewIcon.getWidth(), matthewIcon.getHeight());
			stockPanel.add(matthewIcon);
		} else { // if empty, add empty Icon
			JLabel green = Tools.getEmptyCardLabel(1);
			stockPanel.add(green);
			this.getLowerTableauPanel().setVisible(true);
			this.getHomcellPanel().setVisible(true);
		}
		return stockPanel;
	}
	/**
	 * @return Cool easter egg
	 */
	public JPanel getBigPhoto() {
		bigPhoto.removeAll();
		bigPhoto.setLayout(null);
		JLabel photo = Tools.getMatthewBigPhoto();
		photo.setBounds(0, 0, 640, 480);
		bigPhoto.add(photo);
		return bigPhoto;
	}
	/**
	 * refresh the whole GUI
	 */
	public void refresh() {
		this.getHomcellPanel().revalidate();
		this.getHomcellPanel().repaint();
		getLowerTableauPanel().revalidate();
		getLowerTableauPanel().repaint();
		this.getWastePile().repaint();
		this.getWastePile().revalidate();
		setSelected(false);
		setSelectedAtIndex(-1);
		setSelectedPanel(null);
		setWhereSelected(selectedType.EMPTY);
	}

	/**
	 * @return Boolean.True / Boolean.False
	 */
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public selectedType getWhereSelected() {
		return whereSelected;
	}

	public void setWhereSelected(selectedType whereSelected) {
		this.whereSelected = whereSelected;
	}

	public int getSelectedAtIndex() {
		return selectedAtIndex;
	}

	public void setSelectedAtIndex(int selectedAtIndex) {
		this.selectedAtIndex = selectedAtIndex;
	}

	public JLayeredPane getSelectedPanel() {
		return selectedPanel;
	}

	public void setSelectedPanel(JLayeredPane selectedPanel) {
		this.selectedPanel = selectedPanel;
	}

	/**
	 * @return Restart button
	 */
	public JPanel getMiddle_S_W_Panel() {
		this.middle_S_W_Panel.removeAll();
		this.middle_S_W_Panel.setLayout(null);
		JButton restart = new JButton("Restart");
		restart.setBounds(0, 0, 75, 25);
		restart.addActionListener(new RestartActionListener(this));
		this.middle_S_W_Panel.add(restart);
		return middle_S_W_Panel;
	}

	public void setMiddle_S_W_Panel(JPanel middle_S_W_Panel) {
		this.middle_S_W_Panel = middle_S_W_Panel;
	}
	public void setGameLogic(Thieve gameLogic) {
		this.gameLogic = gameLogic;
	}

}
