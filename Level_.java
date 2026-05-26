package snakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Level_ extends JFrame implements ActionListener,MouseListener{
	
	
	JButton easy,medium,difficult;
	Clip click;
	
	
	Level_(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Level");
		this.setSize(1400,900);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(179, 230, 181));
		
	    //Levels' buttons
		easy=new JButton("Easy");
		medium=new JButton("Medium");
		difficult=new JButton("Difficult");
		easy.setBounds(570, 210, 350, 85);
		medium.setBounds(570, 310, 350, 85);
		difficult.setBounds(570, 410, 350, 85);
		
		buttons(easy);
        buttons(medium);
        buttons(difficult);
		
		this.add(easy);
		this.add(medium);
		this.add(difficult);
		this.setVisible(true);

	}
	
	
	//the common specifications among those buttons are written here so that they don't have to be- 
	//written separately for each button multiple times.
	public void buttons(JButton button) {
		
		  button.setBackground(new Color(0, 0, 0, 45));
	      button.setOpaque(true);
	      button.setContentAreaFilled(true);
	      button.setBorderPainted(true);
	      button.setFocusPainted(false);
	      button.setForeground(Color.WHITE);
	      button.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
	      button.setFocusable(false);
	      button.addActionListener(this);
	      button.addMouseListener(this);
	      
	      
	      
	      click("src//snakeGame//ui-click-43196.wav");
	      
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
		if(e.getSource()==easy) {
			easy.setBounds(570, 210, 400, 100);
		}
		else if(e.getSource()==medium) {
			medium.setBounds(570, 310, 400, 100);
		}
		else if(e.getSource()==difficult) {
			difficult.setBounds(570, 410, 400, 100); 
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		easy.setBounds(570, 210, 350, 85);
		medium.setBounds(570, 310, 350, 85);
		difficult.setBounds(570, 410, 350, 85);
		
	}

	//ActionPerformed method
	//The values for speed and levels will be passed from here through Frame_ class's object.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==easy) {
			click.start();
			dispose();
			Frame_ frame=new Frame_(30,false,false);
			
		}
		if(e.getSource()==medium) {
			click.start();
			dispose();
			Frame_ frame=new Frame_(12,true,false);
		}
		if(e.getSource()==difficult) {
			
			click.start();
			dispose();
			Frame_ frame=new Frame_(3,true,true);
		}
	}
	
	
	//Audio
	public void click(String clickPath) {
	
		File file3=new File(clickPath);
		
		try {
			AudioInputStream clickAudio=AudioSystem.getAudioInputStream(file3);
			try {
				click=AudioSystem.getClip();
				click.open(clickAudio);
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
