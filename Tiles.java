package game.tiles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.constants.Constants;
import game.gameutils.GameUtils;

public class Tiles extends JPanel implements Constants {
	static GameUtils red = new GameUtils(255);
	static GameUtils green = new GameUtils(255);
	static GameUtils blue = new GameUtils(255);
	private Color color; 
	
	Tiles tiles[] = new Tiles[123];
	
	public void formTiles() {
		for(int t=0; t<=123; t++) {
			Tiles tile = new Tiles();
			tiles[t] = tile;
			t++;	
		}
	}
	
	public void drawTiles(Graphics g) {
		for(int x=0; x<=FRAME_WIDTH; x+=37) {
			for(int y=0; y<=150; y+=37) {
				color = new Color(red.getRandomNumber(), blue.getRandomNumber(), green.getRandomNumber());
				g.setColor(color);
				g.fillRect(x, y, 35, 35);
				
			}
		}
	}
	
	
}
