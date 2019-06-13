package com.mikopankiewicz.game.main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import com.mikopankiewicz.game.gamestate.GameStateManager;

import java.lang.Object;
import java.awt.Graphics; 

//this class handles the gameloop & drawing. the other one 
//the more physical (?) details - like the window size etc.
// so one is the 'physical' look and the other - the logic (?)
public class GamePanel extends JPanel implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	//GamePanel inherits from JPanel - can use its methods (JPanel is a library, not a separate file)
	//there are many types of inheritance? not only subclass and superclass
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600; // then can modify this 
	
	private Thread thread; // what's a thread?
	private boolean isRunning = false; 
	
	
	private int fps = 60;
	private long targetTime = 1000 / fps; 
	
	private GameStateManager gsm;
	
	
	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this); //those two important for the keys to do sth
		setFocusable(true);
		
		
		
		start();
	}
	
	private void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start(); // calls the run method - how?
	}
	public void run(){
		long start, elapsed, wait;
		
		gsm = new GameStateManager();
		
		while(isRunning){
			
			start = System.nanoTime();
			
			tick();
			repaint(); // what's that?
			
			elapsed = System.nanoTime() - start; 
			wait = targetTime - elapsed / 1000000; // so the object does not move too fast
			
			
			if(wait <= 0){
				wait = 5; 
			}
			
			try{
				Thread.sleep(wait); //not entirely sure what he means by that
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	private void tick(){
		System.out.println("Running");
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.clearRect(0, 0, WIDTH, HEIGHT); //clearing the screen before drawing the next layer
		gsm.draw(g); //calling the methods like this bc GSM also has these methods
	}
	

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());

	}
}
