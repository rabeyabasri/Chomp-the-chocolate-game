import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class GamePanel extends JPanel implements ActionListener {

	private  Button [][] gridSquares;
	private int rows, cols, lastClickedx = -1, lastClickedy = -1;
	public TopPanel topPanel;
	public JButton back;
	
	public GamePanel(int rows, int cols, TopPanel topPanel, JButton back) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.topPanel = topPanel;
		this.back = back;
		
		setLayout(new GridLayout(rows, cols));
		
		//adding buttons to gamePanel_small
		gridSquares = new Button [rows][cols];
		
		for (int r=0; r<rows; r++)
		{
			for(int c=0; c<cols; c++) {
				
				gridSquares[r][c] = new Button();
				gridSquares[r][c].setVisible(true);// code added by MH
				gridSquares[r][c].setXY(r, c);
				gridSquares[r][c].addActionListener(this);
				add(gridSquares[r][c]);
			}
		}
		
		gridSquares[0][0].setBackground(new Color(235, 213, 52));
		
	}
	
	
	
	public boolean gameHasEnded() {
		return !(gridSquares[0][1].isVisible()) & !(gridSquares[1][0].isVisible());
	}
	
	private void chomp(int x, int y) {
		for (int r=x; r<rows; r++)
		{
			for(int c=y; c<cols; c++) {
				gridSquares[r][c].setVisible(false);
				
			}
		}
	}
	
	public void ComputerPlays() {
		
//		int x; int y=0;
//		boolean found = false;
//		if(lastClickedx == 0 & lastClickedy == 1) {
//			x=1; 
//			y=0;
//    	}
//		else if(lastClickedx == 1 & lastClickedy == 0) {
//			x=0; 
//			y=1;
//		}
//		
//		else if (lastClickedx == 1 & lastClickedy == 1) {
//			
//			for(int i=gridSquares[0].length; i<=2; i-- ) {
//				if(gridSquares[0][i].isVisible()) {
//					x=0;
//					y=i;
//					found = true;
//					break;
//				}
//					
//			}
//			
//			if(!found) {
//				for(int j=gridSquares.length; j<=2; j-- ) {
//					x=j;
//					y=0;
//					found = true;
//					break;
//				}
//			}
//			if(!found) {
//				x=0;
//				y=1;
//			}
//			
//		}
//		else if(lastClickedx == 0 & lastClickedy == 2) {
//			if(gridSquares[1][1].isVisible()) {
//				x = 1; y = 1;
//			}
//			else {
//				x = 2; y = 0;
//			}
//			
//		}
//		else if(lastClickedx == 2 & lastClickedy == 0) {
//			if(gridSquares[1][1].isVisible()) {
//				x = 1; y = 1;
//			}
//			else {
//				for(int i=gridSquares[0].length; i<=1; i-- ) {
//					if(gridSquares[0][i].isVisible()) {
//						x=0;
//						y=i;
//						break;
//					}
//						
//				}
//			}
//		}
//		else{
//			x=0;
//			y=1;
//			
//		}
		
		Timer timer;
		ActionListener action = new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent mevt) {
	        	int x=0; int y=0;
	    		
	    		if(lastClickedx == 0 & lastClickedy == 1) {
	    			
	    				x=1;
	    				y=0;
	    			}
	        	
	    		else if(lastClickedx == 1 & lastClickedy == 0) {
	    			x=0; 
	    			y=1;
	    		}
	    		
	    		else if (lastClickedx == 1 & lastClickedy == 1) {
	    			boolean found = false;
	    			System.out.println(gridSquares[0].length-1);
	    			for(int z=gridSquares[0].length-1;  z>=2; z-- ) {
	    				System.out.println(gridSquares[0].length-1);
	    				if(gridSquares[0][z].isVisible()) {
	    					x=0;
	    					y=z;
	    					System.out.println(x+" ,"+y);
	    					found = true;
	    					break;
	    				}
	    					
	    			}
	    			
	    			if(!found) {
	    				for(int j=gridSquares.length; j>=2; j-- ) {
	    					x=j;
	    					y=0;
	    					found = true;
	    					break;
	    				}
	    			}
	    			if(!found) {
	    				x=0;
	    				y=1;
	    				System.out.println(x+", "+y);
	    			}
	    			
	    		}
	    		else if(lastClickedx == 0 & lastClickedy == 2) {
	    			if(gridSquares[1][1].isVisible()) {
	    				x = 1; y = 1;
	    			}
	    			else {
	    				x = 2; y = 0;
	    			}
	    			
	    		}
	    		else if(lastClickedx == 2 & lastClickedy == 0) {
	    			if(gridSquares[1][1].isVisible()) {
	    				x = 1; y = 1;
	    			}
	    			else {
	    				for(int i=gridSquares[0].length; i<=1; i-- ) {
	    					if(gridSquares[0][i].isVisible()) {
	    						x=0;
	    						y=i;
	    						break;
	    					}
	    						
	    				}
	    			}
	    		}
	    		else{
	    			x=0;
	    			y=1;
	    			
	    		}
	        	chomp(x, y); 
	        	if (gameHasEnded()) {
	 	    	   topPanel.turn.setText("Computer wins!");
	 	    	   back.setText("Play again");
	 	       }
	 	       else {
	 	    	   topPanel.turn.setText("Your turn");
	 	       }
	        }
	      };      
	       timer = new Timer(2000, action);
	       timer.start();
	       timer.setRepeats(false);
	       
	       
	    	   
		
	}
	
	public void reset() {
		lastClickedx = -1; lastClickedy = -1;
		topPanel.turn.setText("Your turn");
		back.setText("Back");
		for (int r=0; r<gridSquares.length; r++)
		{
			for(int c=0; c<gridSquares[0].length ; c++) {
				gridSquares[r][c].setVisible(true);
				
			}
		}
	}
	

	
	public void actionPerformed(ActionEvent e) {
		int x = ((Button) e.getSource()).x;
		int y = ((Button) e.getSource()).y;
		if (x != 0 | y != 0) {
			lastClickedx = x; lastClickedy = y;
		
			chomp(x, y);
			if (!gameHasEnded()) {
				topPanel.turn.setText("Computer's turn");
				ComputerPlays();
			}
			else
			{
				//Edit here
				topPanel.turn.setText("You win!");
				back.setText("Play again");
			}
	}
}
	
}
