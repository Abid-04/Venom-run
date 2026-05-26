package snakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
	
	private int	recX=325;
    private int recY=250;
    private int recW=30;
    private int recH=30;
    private int movement=10;
    

	
    
    
    Player(){
    	
    	
    	
    	
       }
    
    
    //Setters and getters 
    public int getMovement() {
		return movement;
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	
	
    public int getRecX() {
		return recX;
	}
	public void setRecX(int recX) {
		this.recX = recX;
	}


	public int getRecY() {
		return recY;
	}
	public void setRecY(int recY) {
		this.recY = recY;
	}


	public int getRecW() {
		return recW;
	}
	public void setRecW(int recW) {
		this.recW = recW;
	}


	public int getRecH() {
		return recH;
	}
	public void setRecH(int recH) {
		this.recH = recH;
	}
 
	
	//2D graphics method, filling a rectangle and it will be rendered in panel's class.
    public void render(Graphics2D g2D) {
    	
    	g2D.setColor(Color.DARK_GRAY);
    	g2D.fillRect(recX, recY, recW, recH);
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(recX, recY, recW, recH);
    }
    
    
    //Method for player's movement
    public void move(int x,int y) {
    	recX+=x;
    	recY+=y;
    }
    
    
    
}
