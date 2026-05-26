package snakeGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame_ extends JFrame{

	
	Panel_ panel;
	Frame_(int speed,boolean mid,boolean dif){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Game");
		this.setSize(1400,900);
		this.setLayout(new BorderLayout());
		panel=new Panel_(speed,mid,dif);
		
		
		
		this.add(panel);
		this.setVisible(true);
	}
}
