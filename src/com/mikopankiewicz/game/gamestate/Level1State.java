package com.mikopankiewicz.game.gamestate;

import java.awt.Graphics;
import com.mikopankiewicz.game.entities.Player;

public class Level1State extends GameState{

	//should add a key listener here?
	
	public Level1State(GameStateManager gsm){
		super(gsm);
		
	}
	
	private Player player;
	public void init() {
		player = new Player(30,30); //TODO change the width and height
	}

	public void tick() {
		player.tick();
	}

	public void draw(Graphics g) {
		player.draw(g);
	}

	public void keyPressed(int k) {
		player.keyPressed(k);
		
	}

	public void keyReleased(int k) {
		player.keyReleased(k);
	}

}
