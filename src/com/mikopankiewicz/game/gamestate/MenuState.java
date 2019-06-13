package com.mikopankiewicz.game.gamestate;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.mikopankiewicz.game.main.GamePanel;


public class MenuState extends GameState{

	public String[] options = {"Start", "Help", "Quit"};
	private int currentSelection = 0; 	
	
	public MenuState(GameStateManager gsm) {
		super(gsm); //not 100% sure what it does but has to do with inheritance from GameState (superclass)
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void tick() {
		
	}


	@Override
	public void draw(Graphics g) {
		

		g.setColor(new Color(50, 100, 200));
		//TODO: change to some img background
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		for(int i = 0; i < options.length; i++){
			if(i == currentSelection){
				g.setColor(Color.GREEN);
			}else{
				g.setColor(Color.WHITE);
			}
		//g.drawLine(GamePanel.WIDTH/2, 0, GamePanel.WIDTH/2, GamePanel.HEIGHT);
		g.setFont(new Font("Arial", Font.PLAIN, 72));
		g.drawString(options[i], GamePanel.WIDTH/2 - 75, 150 + i * 150);	
		}
		
		
		
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_DOWN){
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		}else if(k == KeyEvent.VK_UP){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length-1;
				}
		}
		
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection ==0){
				gsm.states.push(new Level1State(gsm));
				//pushed onto a stack .. and then what?
				//what's the new thing displayed?
				// a new gsm state! i guess
				// play
				
				
			} else if(currentSelection ==1){
				// help
			}else if(currentSelection ==2){
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		
	}

}
