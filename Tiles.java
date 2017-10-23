package game.tiles;

import java.awt.Color;
import java.awt.Graphics;

import game.constants.Constants;
import game.gameutils.GameUtils;

public class Tiles implements Constants {
	static GameUtils red = new GameUtils(255);
	static GameUtils green = new GameUtils(255);
	static GameUtils blue = new GameUtils(255);
	private Color color;
	private int delay;
	
	Tiles tiles[][] = new Tiles[5][19];
	
	public Tiles() {
		color = new Color(red.getRandomNumber(), blue.getRandomNumber(), green.getRandomNumber());
	}
	
	public void formTiles() {
		for(int u=0; u<=4; u++)	
			for(int t=0; t<=18; t++) {
				Tiles tile = new Tiles();
				tiles[u][t] = tile;
			}
	}
	
	public void drawTiles(Graphics g) {
		for(int x=0; x<=FRAME_WIDTH; x+=62) {
			for(int y=0; y<=150; y+=37) {
				if(delay==4000) {
				color = new Color(red.getRandomNumber(), blue.getRandomNumber(), green.getRandomNumber());
				delay=0;
				}
				g.setColor(color);
				g.fillRect(x, y, 59, 35);
			}
		delay++;
		}
	}

	
}
