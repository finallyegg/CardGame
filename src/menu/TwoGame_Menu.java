package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.FinalGolf.GUI.GUI_Main;
import final_LittleSpider_GUI.runGui;

public class TwoGame_Menu {
	public static void runGUI() {
		JFrame frame = new JFrame("Two Game");

		JLabel label = new JLabel("Hello");
		JPanel panel = new JPanel();
		panel.add(label);

		JButton button = new JButton("GolfGame");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_Main.runGUI();
			}
		});
		JButton button2 = new JButton("LittleSpider");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runGui.runGUI();
			}
		});
		JButton forty = new JButton("Forty Theives");
		forty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui_Thieve.runGUI.runGame();
			}
		});
		JButton button3 = new JButton("Exit");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(button);
		panel.add(button2);
		panel.add(forty);
		panel.add(button3);
		frame.add(panel);
		frame.setSize(400, 200);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//        frame.pack();

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runGUI();
			}
		});
	}
}
