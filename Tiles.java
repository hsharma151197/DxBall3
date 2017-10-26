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
	private boolean tiles_isVisible;
	private int xTile, yTile;
	private int w=60,h=35;
	
	public Tiles() {
		color = new Color(red.getRandomNumber(), blue.getRandomNumber(), green.getRandomNumber());
		tiles_isVisible = true;
	}
	
	public void drawTiles(Graphics g) {
				if(delay==4000) {
				color = new Color(red.getRandomNumber(), blue.getRandomNumber(), green.getRandomNumber());
				delay=0;
				}
					
					g.setColor(color);
					g.fillRect(xTile, yTile, w, h);
				
		delay++;
	}

	public int getxTile() {
		return xTile;
	}

	public void setxTile(int xTile) {
		this.xTile = xTile;
	}

	public int getyTile() {
		return yTile;
	}

	public void setyTile(int yTile) {
		this.yTile = yTile;
	}

	public boolean isTiles_isVisible() {
		return tiles_isVisible;
	}

	public void setTiles_isVisible(boolean tiles_isVisible) {
		this.tiles_isVisible = tiles_isVisible;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
}
