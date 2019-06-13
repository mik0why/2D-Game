package com.mikopankiewicz.game.gamestate;

import java.util.Stack; // so that's how its done
import java.awt.Graphics;
//checking all the states & creates logic for them
public class GameStateManager {

	//this class updates the stack 
	//whichever state should currently be there
	
	public Stack<GameState> states;
	
	public GameStateManager(){
		states = new Stack<GameState>();
		states.push(new MenuState(this)); //passing ..what?.. to game state manager
		//java (OO) is so smart lol
		//literally we make a new datatype
		// and then we just can make DS of it
	}

	public void tick(){
		states.peek().tick(); //updating the top of the stack?
		//peek just retrieves, idk what tick does
	}
	
	public void draw(Graphics g){
		states.peek().draw(g); 
	}
	
	public void keyPressed(int k){
		states.peek().keyPressed(k); 
		
	}
	
	public void keyReleased (int k){
		states.peek().keyReleased(k);
	}
}
