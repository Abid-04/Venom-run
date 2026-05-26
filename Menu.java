package snakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener,MouseListener{
	
	
	JButton start,info,exit;
	Image background;
	Clip click2;
	
	Menu(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,900);
		this.setTitle("Menu");
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(179, 230, 181));
		
		background=new ImageIcon("src//light-green-color-solid-background-1920x1080.png").getImage();
		
		
		
		start=new JButton("Start");
		info=new JButton("Game's Info");
		exit=new JButton("Exit");
		start.setBounds(570, 210, 350, 85);
		info.setBounds(570, 310, 350, 85);
		exit.setBounds(570, 410, 350, 85); 
		
		menuu(start);
		menuu(info);
		menuu(exit);
		
		click("src//snakeGame//ui-click-43196.wav");
		
		
		this.add(start);
		this.add(info);
		this.add(exit);
		this.setVisible(true);
	}
	
	
	
	


	//the common specifications among those buttons are written here so that they don't have to be- 
	//written separately for each button multiple times.
	public void menuu(JButton btn ) {
		
		  btn.setBackground(new Color(0, 0, 0, 45));
	      btn.setOpaque(true);
	      btn.setContentAreaFilled(true);
	      btn.setBorderPainted(true);
	      btn.setFocusPainted(false);
	      btn.setForeground(Color.WHITE);
	      btn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
	      btn.setFocusable(false);
	      btn.addActionListener(this);
	      btn.addMouseListener(this);
	      
	      
	   
	      
	}

    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==start) {
			start.setBounds(570, 210, 400, 100);
		}
		else if(e.getSource()==info) {
			info.setBounds(570, 310, 400, 100);
		}
		else if(e.getSource()==exit) {
			exit.setBounds(570, 410, 400, 100); 
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		start.setBounds(570, 210, 350, 85);
		info.setBounds(570, 310, 350, 85);
		exit.setBounds(570, 410, 350, 85);
	}


	
	//ActionPerformed method
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==start) {
			click2.start();
			dispose();
			Level_ level=new Level_();
		}
		else if(e.getSource()==info) {
			click2.start();
			dispose();
			Info info=new Info();
		}
		else if(e.getSource()==exit) {
			click2.start();
			System.exit(0);
		}
		
	}
	
	
	//Audio 
	public void click(String clickPath) {
		
		File file3=new File(clickPath);
		
		try {
			AudioInputStream clickAudio=AudioSystem.getAudioInputStream(file3);
			try {
				click2=AudioSystem.getClip();
				click2.open(clickAudio);
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

}
