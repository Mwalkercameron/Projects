import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	//determine whose turn it is first randomly
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel(); //panel to hold title
	JPanel button_panel = new JPanel();// panel to hold the buttons
	JLabel textfield = new JLabel();//text field to display message
	JButton[] buttons = new JButton[9];//create array of buttons
	boolean player1_turn;
	
	TicTacToe(){ //constructor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800); //set size of frame
		frame.getContentPane().setBackground(Color.DARK_GRAY); //background color of ttt table
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.BLACK);
		textfield.setForeground(Color.YELLOW);
		textfield.setFont(new Font("Serif",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe Game");
		textfield.setOpaque(true);
		
		//title panel
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.GRAY);
		
		//loop to create all the buttons
		for(int i=0;i<9;i++){
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Courier",Font.BOLD,100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		//determine whose turn goes first now
		firstTurn();
		

	}

	@Override
	/*
	 * @description: this method will react to buttons pressed
	 * @param:
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						checkWin();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						checkWin();
					}
				}			
			}
		}			
	}
	
	public void firstTurn(){
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X Turn");
	    }else {
	    		player1_turn=false;
	    		textfield.setText("O Turn");
	    }
	}
	
	public void checkWin(){
		//check X win conditon
		//horizontal
		if(
			(buttons[0].getText()=="X") && 
			(buttons[1].getText()=="X") &&
			(buttons[2].getText()=="X")
			){	
			xWins(0,1,2);	
		}
		if(
			(buttons[3].getText()=="X") && 
			(buttons[4].getText()=="X") &&
			(buttons[5].getText()=="X")
			){	
				xWins(3,4,5);	
			}
		if(
			(buttons[6].getText()=="X") && 
			(buttons[7].getText()=="X") &&
			(buttons[8].getText()=="X")
			){	
			xWins(6,7,8);	
			}
		//vertical win condition
		if(
			(buttons[0].getText()=="X") && 
			(buttons[3].getText()=="X") &&
			(buttons[6].getText()=="X")
			){	
				xWins(0,3,6);	
			}
		if(
				(buttons[1].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				){	
				xWins(1,4,7);	
			}
		if(
				(buttons[2].getText()=="X") && 
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				){	
				xWins(2,5,8);	
			}
		//Diagonal win condition
		if(
				(buttons[0].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				){	
				xWins(0,4,8);	
			}
		if(
				(buttons[2].getText()=="X") && 
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				){	
				xWins(2,4,6);	
			}
		
		//check O win condition
		//horizontal
		
		if(
			(buttons[0].getText()=="O") && 
			(buttons[1].getText()=="O") &&
			(buttons[2].getText()=="O")
			){	
			oWins(0,1,2);	
		}
		if(
			(buttons[3].getText()=="O") && 
			(buttons[4].getText()=="O") &&
			(buttons[5].getText()=="O")
			){	
				oWins(3,4,5);	
			}
		if(
			(buttons[6].getText()=="O") && 
			(buttons[7].getText()=="O") &&
			(buttons[8].getText()=="O")
			){	
				oWins(6,7,8);	
			}
		//vertical win condition
		if(				
			(buttons[0].getText()=="O") && 
			(buttons[3].getText()=="O") &&
			(buttons[6].getText()=="O")
			){	
				oWins(0,3,6);	
			}
		if(
				(buttons[1].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				){	
				oWins(1,4,7);	
			}
		if(
				(buttons[2].getText()=="O") && 
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				){	
				oWins(2,5,8);	
			}
		//Diagonal win condition
		if(
				(buttons[0].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				){	
				oWins(0,4,8);	
			}
		if(
				(buttons[2].getText()=="O") && 
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				){	
				oWins(2,4,6);	
			}
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins!");
	}
	
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins!");
	}
		
}


