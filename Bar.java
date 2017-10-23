package game.bar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import game.constants.Constants;
import game.gameutils.GameUtils;

public class Bar extends JPanel implements Constants{
	private final int RECT_Y = FRAME_HEIGHT-20;
	private final int RECT_WIDTH = 190;
	private final int RECT_HEIGHT = 12;
	static GameUtils red = new GameUtils(255);
	static GameUtils green = new GameUtils(255);
	static GameUtils blue = new GameUtils(255);
	private Color color = new Color(red.getRandomNumber(),green.getRandomNumber(),blue.getRandomNumber());
	private int barSpeed;
	private int rect_X;
	
	public Bar() {
		rect_X = 400;
	}
	
	public void move() {
		rect_X += barSpeed;
	}
	
	
	public void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				barSpeed = 0;
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(rect_X>=0 && rect_X<=FRAME_WIDTH) {
				if(rect_X>0) {
					if(e.getKeyCode()==KeyEvent.VK_LEFT) 
						barSpeed = -1;
				}
				if(rect_X<FRAME_WIDTH) {
					if(e.getKeyCode()==KeyEvent.VK_RIGHT)
						barSpeed = 1;
					}
				}
			}
	});
	}
	
	public void drawRect(Graphics g) {
		g.setColor(color);
		g.fillRect(rect_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	}

	public int getRect_X() {
		return rect_X;
	}

	public void setRect_X(int rect_X) {
		this.rect_X = rect_X;
	}

}