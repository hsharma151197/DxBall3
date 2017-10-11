package game.tiles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.constants.Constants;

public class Tiles extends JPanel implements Constants {
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
				g.setColor(Color.BLUE);
				g.fillRect(x, y, 35, 35);
				
			}
		}
	}
	
	
}
