import javax.swing.*;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.*;

public class Button extends JButton implements ActionListener {
    
	public int x, y;
    
	public Button() {
		super();
		setBackground(new Color(97, 79, 53));
		
		
	}
	
	public void setXY(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	

	

	public void actionPerformed(ActionEvent e) {
		
		
		
	}

	
}
