import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {

		public JLabel turn;

		
		public TopPanel() {
			
			setBackground(Color.blue);
			setBounds(30,10, 800, 100);
			setLayout(null);
			setVisible(true);
			
			//adding label to the top panel
			turn = new JLabel("Your turn");
			turn.setFont(new Font("courier", Font.BOLD, 20));
			turn.setBounds(360, 60, 800, 30);
			add(turn);
		}

	}