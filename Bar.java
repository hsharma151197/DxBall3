package game.bar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import game.constants.Constants;

public class Bar extends JPanel implements Constants{
	private int rect_X = 80;
	private final int RECT_Y = FRAME_HEIGHT-20;
	private final int RECT_WIDTH = 190;
	private final int RECT_HEIGHT = 12;
	int rect_xSpeed = 0;
	
	public void drawRect(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(rect_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	}
	
	public void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				if(rect_X>=0 && rect_X<=FRAME_WIDTH) {
					if(e.getKeyCode()==KeyEvent.VK_LEFT)
							rect_X = rect_X--;
					if(e.getKeyCode()==KeyEvent.VK_RIGHT)
							rect_X = rect_X++;
					}
				}
				@Override
				public void keyPressed(KeyEvent e) {
				if(rect_X>=0 && rect_X<=FRAME_WIDTH) {
					if(e.getKeyCode()==KeyEvent.VK_LEFT)
						rect_X = rect_X--;
					if(e.getKeyCode()==KeyEvent.VK_RIGHT)
						rect_X = rect_X++;
				}
				}
	});
	}

}
