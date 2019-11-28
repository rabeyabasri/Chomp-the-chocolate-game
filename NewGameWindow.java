import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;

import javax.swing.*;

public class NewGameWindow extends JFrame implements ActionListener{

	public TopPanel topPanel;
	public GamePanel smallBar, mediumBar, largeBar;
	public JButton back;
	
	public NewGameWindow(JButton back) {
		super("CHOMP ");
		back = back;
		setBounds(300, 150, 900, 600);
		//getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//adding the topPanel
		topPanel = new TopPanel();
		add(topPanel);
		
		//adding smallBar, mediumBar and largeBar panels
		
		smallBar = new GamePanel(3,4, topPanel, back);
		smallBar.setBounds(30,130, 800, 400);
	    add(smallBar);
	    
		mediumBar = new GamePanel(4,5, topPanel, back);
		mediumBar.setBounds(30,130, 800, 400);
	    add(mediumBar);
	    
		largeBar = new GamePanel(5,6, topPanel, back);
		largeBar.setBounds(30,130, 800, 400);
	    add(largeBar);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
