package com.mikopankiewicz.game.main;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class twoDgame {

		public static void main(String[] args){
			JFrame Frame = new JFrame("Platformer"); // making a new frame
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.setResizable(true); // changed from false lol
			Frame.setLayout(new BorderLayout());
			Frame.add(new GamePanel(), BorderLayout.CENTER);
			Frame.pack(); //specified sizes to fit components and their layouts
			Frame.setLocationRelativeTo(null); // placed centrally on the screen
			Frame.setVisible(true);
					
			
		}
}
