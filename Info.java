package snakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Info extends JFrame implements ActionListener{
	
	JTextArea text;
    JScrollPane scrollPane;
    JMenuBar menu;
	JMenu Back;
	JMenuItem back1;
    
    Info(){
   	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 this.setSize(1500,1500);
   	 this.setTitle("Game Information");
   	 this.setLayout(null);
   	 
   	 
   	 
   	 
   	//Text area for game's information
   	text=new JTextArea();
       text.setEditable(false);
       text.setLineWrap(true);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Serif", Font.PLAIN, 16));
       text.setBackground(Color.DARK_GRAY);
   	text.setText("Snake Game is a fast-paced survival game where you control a small square "
   			+ "using the arrow keys. Your goal is to collect reward icons scattered around the map "
   			+ "to increase your score and grow in size. Be careful, though — several traps are placed a"
   			+ "cross the field, and touching any of them will immediately end the game. Each time you "
   			+ "grab a reward, it relocates to a new random position, and your snake becomes larger, "
   			+ "making movement more challenging. The map wraps around, so moving off one edge brings "
   			+ "you back from the opposite side. Try to survive as long as you can, avoid obstacles, and"
   			+ " reach the highest score possible."
   			+ "\n"
   			+ "\n"
   			+ "\n"
   			+ "\n"
   			+ "Abid Games");
   	 
   	scrollPane = new JScrollPane(text);
   	scrollPane.setBounds(350, 100, 750, 600);
   	
   	
   	menu=new JMenuBar();
	Back=new JMenu("Back");
	back1=new JMenuItem("Back to Menu");
	back1.addActionListener(this);
	
	 this.setJMenuBar(menu);
	 menu.add(Back);
	 Back.add(back1);
   	 this.add(scrollPane);
   	 this.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==back1) {
			dispose();
			Menu menu=new Menu();
		}
	}


}
