package code.FinalGolf.GUI;

import javax.swing.*;

import code.FinalGolf.*;

public class Golf_GUI {
	private JPanel tabluesPanel;
	private JPanel homeCellPanel;
	private JPanel stockPanel;
	
	public Golf_GUI() {
		tabluesPanel = new JPanel();
		homeCellPanel = new JPanel();
		stockPanel = new JPanel();
		
	}
	
	public JPanel getTabluePanel(){
		JPanel[] tabluepiles = new JPanel[7];
		for (int i=0;i<7;i++) {
			JLabel a = new JLabel();
			a.setText(Golf_Game.getTableaus(i).getTablestack().get(0).toString());
			tabluepiles[i].add(a);
			
			
		}
		return tabluepiles;
	}
	

}
