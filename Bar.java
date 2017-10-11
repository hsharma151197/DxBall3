package game.bar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import game.constants.Constants;
import game.tiles.Tiles;
import game.gameutils.GameUtils;

public class Bar extends JPanel implements Constants{
	private int rect_X;
	private final int RECT_Y = FRAME_HEIGHT-20;
	private final int RECT_WIDTH = 190;
	private final int RECT_HEIGHT = 12;
	static GameUtils red = new GameUtils(255);
	static GameUtils green = new GameUtils(255);
	static GameUtils blue = new GameUtils(255);
	Color color = new Color(red.getRandomNumber(),green.getRandomNumber(),blue.getRandomNumber());
	
	public int getRect_X() {
		return rect_X;
	}

	public void setRect_X(int rect_X) {
		this.rect_X = rect_X;
	}

	public void drawRect(Graphics g) {
		g.setColor(color);
		g.fillRect(rect_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	}
	
	public void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			if(rect_X>=0 && rect_X<=FRAME_WIDTH) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
					rect_X--;
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
					rect_X++;
			}
			}
	});
	}
	
	public Bar() {
		rect_X = 80;
		
	}
}
