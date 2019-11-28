import java.awt.event.*;

import javax.swing.*;

public class GameManager implements ActionListener {

	private HomeWindow homeWindow;
	private NewGameWindow newGameWindow;
	private JButton small, medium, large, playAgain, back;
	
	public GameManager() {
		
		//Working with homeWindow
		homeWindow = new HomeWindow();
		
		//Adding buttons to the homeWindow
		small = new JButton("small");
		small.setBounds(300,85,200,85);
		small.addActionListener(this);
		homeWindow.add(small);
		
		medium = new JButton("medium");
		medium.setBounds(300,255,200,85);
		medium.addActionListener(this);
		homeWindow.add(medium);
		
		large = new JButton("large");
		large.setBounds(300,425,200,85);
		large.addActionListener(this);
		homeWindow.add(large);
		
		back = new JButton("back");
		//Working with newGameWindow
		newGameWindow = new NewGameWindow(back);
		
		
	
		//add playAgain, back buttons to the newGameWindow
		playAgain = new JButton("Play again");
		playAgain.addActionListener(this);
		playAgain.setVisible(false);
		playAgain.setBounds(385, 20, 100, 30);
		newGameWindow.add(playAgain);
		
		
		back.addActionListener(this);
		back.setBounds(0,0, 100, 20);
		newGameWindow.add(back);
		
		
		//Setting Visibilities
		homeWindow.setVisible(true);
		newGameWindow.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if ( source.equals(back) ){
			newGameWindow.setVisible(false);
			homeWindow.setVisible(true);
			
		}
		
		if	(source.equals(small) | source.equals(medium) | source.equals(large)) {
			
			
			homeWindow.setVisible(false);
			newGameWindow.setVisible(true);
			
			if ( source.equals(small) ) {
				newGameWindow.smallBar.reset();
				newGameWindow.smallBar.setVisible(true);
				newGameWindow.mediumBar.setVisible(false);
				newGameWindow.largeBar.setVisible(false);
			}
			
			else if ( source.equals(medium) ) {
				newGameWindow.mediumBar.reset();
				newGameWindow.smallBar.setVisible(false);
				newGameWindow.mediumBar.setVisible(true);
				newGameWindow.largeBar.setVisible(false);
				
			}
			else {
				newGameWindow.largeBar.reset();
				newGameWindow.smallBar.setVisible(false);
				newGameWindow.mediumBar.setVisible(false);
				newGameWindow.largeBar.setVisible(true);
				
			}
			
			
			
		}		
		
		
	}

	
	public static void main(String[] args) {
		new GameManager();
		

	}


}
