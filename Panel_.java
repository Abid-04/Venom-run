package snakeGame;


import java.sql.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.util.Random;


public class Panel_ extends JPanel implements ActionListener{
	
	
	//Variables 
	Action up,down,right,left;
	Player player;
    Random random=new Random();
    Timer timer;
    int movement=10;
    int score=0;
    int highestScore1=0;
    JButton pause,resume;
    JLabel label,label2;
    boolean dif_level=false;
	boolean mid_level=false;
    
    private int timerV=0;
    
    

	Clip clip1,clip2;
    
    
    Image reward,trap,heart;
    int trapX1=250;
    int trapX2=790;
    int trapY1=580;
    int trapY2=343;
    int rewardX=100;
    int rewardY=50;
    int heartX;
    int heartY;
    
    
    
	
   
    int panel_width=1400;
    int panel_height=900;
    
    int UP=0;
    int DOWN=1;
    int RIGHT=2;
    int LEFT=3;
    String name;
    
    int direction=RIGHT;
    
  //declaration of rectangle objects
    Rectangle rec1,rec2,rec3,rec4,rec5,rec6,rec7;
    
    
    //Constructor
	Panel_(int speed,boolean mid,boolean dif){
		this.setBackground(new Color(179, 230, 181));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(panel_width,panel_height));
		this.timerV=speed;
		this.dif_level=dif;
		this.mid_level=mid;

		
		player=new Player();
		reward=new ImageIcon("src//snakeGame//loyalty.png").getImage();
		trap=new ImageIcon("src//snakeGame//trap.png").getImage();
		heart=new ImageIcon("src//snakeGame//kind.png").getImage();
		
		//Asking for player's name
		name=JOptionPane.showInputDialog(null, "Write your name...", "Player's name", JOptionPane.QUESTION_MESSAGE);
		
		
		//the timer is getting the time value from timerV which is initialized in level class.
		timer=new Timer(timerV,this);
		timer.start();
		
		
		//Labels for score and highest score
		label=new JLabel();
		label.setText(name+"'s Score: "+score);
		label.setBounds(10, 30,210, 50);
		label.setFont(new Font("New Times Roman", Font.BOLD,20));
		

		
		label2=new JLabel();
		int highestScore1 = Database.getHighestScore();
		label2.setText("Highest Score: " + highestScore1);
		label2.setBounds(10, 10,210, 700);
		label2.setFont(new Font("New Times Roman", Font.BOLD,20));
		
		
		
		//Buttons(to pause or resume game)
		pause=new JButton("Pause the game");
		pause.setForeground(Color.GRAY);
		pause.setBackground(new Color(236, 244, 227));
		pause.setBounds(10, 10, 150, 30);
		pause.setFocusable(false);
	    pause.addActionListener(this);
		pause.setVisible(true);
	    
	    resume=new JButton("Resume");
	    resume.setForeground(Color.GRAY);
	    resume.setBackground(new Color(236, 244, 227));
	    resume.setBounds(10, 10,150, 30);
	    resume.setFocusable(false);
	    resume.addActionListener(this);
		resume.setVisible(false);
		
		
		//assigning the direction methods to Action objects
		up=new upMov();
		down=new downMov();
		right=new rightMov();
		left=new leftMov();
		
		heartX=random.nextInt(130, 1110);
		heartY=random.nextInt(130, 600);
		
		//Key bindings 
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction");
		this.getActionMap().put("upAction",up);
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		this.getActionMap().put("downAction", down);
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		this.getActionMap().put("rightAction", right);
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		this.getActionMap().put("leftAction", left);
		
		
		//Adding all the components to the panel
		this.add(label);
		this.add(label2);
		this.add(pause);
		this.add(resume);
		playMusic2("src//snakeGame//slowburn-relaxing-lofi-background-music-loopable-206624.wav");
		clip2.start();
	}
	
	//setter and getter
	public int getTimerV() {
		return timerV;
	}


	public void setTimerV(int timerV) {
		this.timerV = timerV;
	}
	
	
	
	 public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Graphics2D g2D=(Graphics2D) g;
			
			//Player's shape is rendered through another class
			player.render(g2D);
			
			//Drawing the images of traps and reward
			g2D.drawImage(reward, rewardX, rewardY, null);
			g2D.drawImage(trap,trapX1,380,null);
			g2D.drawImage(trap,trapX2,80,null);
			g2D.drawImage(trap,1000,trapY1,null);
			g2D.drawImage(trap,1200,trapY2,null );
			
			if(score%8==0) {
				g2D.drawImage(heart,heartX,heartY,null);
			}
			
		  }
	
	 
	//Direction's methods 
	public class upMov extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			direction=UP;
		}
		
	}
	public class downMov extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			direction=DOWN;
		}
		
	}
	public class rightMov extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			direction=RIGHT;
		}
		
	}
	
	public class leftMov extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			direction=LEFT;
		}
		
	}

	
	//ActionPerformed method
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Making the conditions for pausing and resuming the game 
		if(e.getSource()==pause) {
			pause.setVisible(false);
			resume.setVisible(true);
			timer.stop();
		}
		else if(e.getSource()==resume) {
			resume.setVisible(false);
			pause.setVisible(true);
			timer.start();
		}
		
		//starting the timer, everything start from here!
		if(e.getSource()==timer) {
			
			
			//Assigning all the pictures from 2D graphics method to the rectangle objects so they can be used for intersection-
			//conditions later.
			rec1=new Rectangle(rewardX,rewardY,reward.getWidth(null),reward.getHeight(null));
			rec2=player.getBounds();
			rec3=new Rectangle(trapX1,380,trap.getWidth(null),trap.getHeight(null));
			rec4=new Rectangle(trapX2,80,trap.getWidth(null),trap.getHeight(null));
			rec5=new Rectangle(1000,trapY1,trap.getWidth(null),trap.getHeight(null));
			rec6=new Rectangle(1200,trapY2,trap.getWidth(null),trap.getHeight(null));
			rec7=new Rectangle(heartX,heartY,heart.getWidth(null),heart.getHeight(null));
			
			
			//if the level is medium, 2 of the traps will vertically. but if it's difficult-
			//level, then all 4 traps will move.(2 vertically and 2 horizontally)
			//As for the easy level, all the traps are on their own places, they wont be moving
			if(mid_level) {
				if(mid_level&&dif_level) {
					trapX1+=5;
					trapX2+=5;
				}
				
				trapY1+=5;
				trapY2+=5;
				if(rec2.intersects(rec3)||rec2.intersects(rec4)||rec2.intersects(rec5)||rec2.intersects(rec6)) {
					timer.stop();}
				if(trapX1>1500) {
					trapX1=0;	
				}
				if(trapX2>1450) {
					trapX2=0;
				}
				if(trapY1>900) {
					trapY1=2;	
				}
				if(trapY2>900) {
					trapY2=2;
				}
			}
			
			
			//conditions to explain what to do when one of the arrow keys are pressed.
			if(direction == UP)  {
				player.move(0,-movement);
				if(player.getRecY()<0) {
					player.setRecY(800);
				}
			}	
			if(direction == DOWN) {
				player.move(0,movement);
				if(player.getRecY()>795-30) {
					player.setRecY(0);
				}
			}
			if(direction == LEFT){
				player.move(-movement,0);
				if(player.getRecX()<0) {
					player.setRecX(1550);
				}
			}	
			if(direction == RIGHT) {
				player.move(movement,0);
				if(player.getRecX()>1535-30) {
					player.setRecX(0);
					
				}
			}
			repaint();
		}
		
		
		//when the player(rec2) intersects with reward(rec1), the hit sound will be played and the score will be increased and updated.
		//after the intersection, the reward(rec1) will be placed randomly on the screen between the values shown in the code. 
		if(rec2.intersects(rec1)) {
			playMusic("src//snakeGame//hit-tree-03-266306.wav");
			player.setRecW(player.getRecW()+4);
			player.setRecH(player.getRecH()+4);
			
			rewardX=random.nextInt(10, 1400);
			rewardY=random.nextInt(10, 750);
			
			while(rec1.intersects(rec3)||rec1.intersects(rec4)||rec1.intersects(rec5)||rec1.intersects(rec6)) {
				rewardX=random.nextInt(10, 1400);
				rewardY=random.nextInt(10, 750);
				
				rec1=new Rectangle(rewardX,rewardY,reward.getWidth(null),reward.getHeight(null));
			}
		
			score++;
			label.setText(name+"'s Score: "+score);
			
			
			
		}
		
		
		//code for highest score
		if(rec2.intersects(rec3)||rec2.intersects(rec4)||rec2.intersects(rec5)||rec2.intersects(rec6)) {
			timer.stop();
			
			Database.saveScore(name, score);
		    
		    
		    highestScore1 = Database.getHighestScore();
		    label2.setText("Highest Score: " + highestScore1);
			
			
			
			
		    int close=JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Game over!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
		    //when the intersection happens between player and  one of the traps, then user will be asked if they play again or not.
		    //If No, the game will be closed completely, whereas if it is a Yes, then the game will start again by asking playuer's name
		    if(close==JOptionPane.NO_OPTION) {
				System.exit(0);
			}
			else if(close==JOptionPane.YES_OPTION) {
				
				name=JOptionPane.showInputDialog(null, "Write your name...", "Player's name", JOptionPane.QUESTION_MESSAGE);
				score=0;
				player.setRecW(30);
			    player.setRecH(30);
				label.setText(name+"'s Score: "+score);
				
				player.setRecX(325);
				player.setRecY(250);
				timer.start();
			}
			
		}
		
		if(rec2.intersects(rec7)) {
			heartX=random.nextInt(130, 1110);
			heartY=random.nextInt(130, 600);
			score+=5;
			label.setText(name+"'s Score: "+score);
		}
		
		
	}
	
	
  
	//Audios' methods
	public void playMusic(String filePath) {
		
		File file=new File(filePath);
		
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			try {
				clip1=AudioSystem.getClip();
				clip1.open(audio);
				clip1.start();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void playMusic2(String filePath2) {
		File file2=new File(filePath2);
		
		try {
			AudioInputStream audio2=AudioSystem.getAudioInputStream(file2);
			try {
				clip2=AudioSystem.getClip();
				clip2.open(audio2);
				clip2.start();
				clip2.loop(clip2.LOOP_CONTINUOUSLY);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
