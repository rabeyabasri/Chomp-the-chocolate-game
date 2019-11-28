import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeWindow extends JFrame {


	
	public HomeWindow()  {
		super("CHOMP ");
		setBounds(300, 150, 900, 600);
		getContentPane().setBackground(Color.green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
	}

	

}
