package com.mikopankiewicz.game.gamestate;

import java.awt.Graphics;

public abstract class GameState {
//not sure yet what is this class for
//creating subclasses of, like MenuState
	
	/* An abstract class - can't create an instance of it
	 * Can only create instances of classes that inherit from this class
	 * 
	 * 
	 */
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm ;
		init();
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed (int k);
	public abstract void keyReleased(int k);


	
	
	
}
