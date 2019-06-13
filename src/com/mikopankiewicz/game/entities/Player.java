package com.mikopankiewicz.game.entities;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.mikopankiewicz.game.main.GamePanel;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Rectangle{
	private static final long serialVersionUID =1L;
	
	private boolean right = false, left = false;
	
	public Player(int width, int height){
		setBounds(GamePanel.WIDTH/2, GamePanel.HEIGHT/2, width, height);
		//the player doesn't move - the background does
		
		
	}
	public void tick(){
		if(right){
			x++;
		}
		if(left){
			x--;
		}
		
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
		
	}
	//not moving for some reason
	public void keyPressed(int k){
		if (k==KeyEvent.VK_RIGHT) right = true;
		if(k==KeyEvent.VK_LEFT)left = true; 
	}
	public void keyReleased(int k){
		if (k==KeyEvent.VK_RIGHT) right = false;
		if(k==KeyEvent.VK_LEFT)left = false; 
	}
	
	
}

