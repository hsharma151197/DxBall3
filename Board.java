package game.board;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.bar.Bar;
import game.constants.Constants;
import game.tiles.Tiles;

public class Board extends JPanel implements Constants {
	private Image bgImage;
	private Timer timer;
	private Bar bar;
	private Tiles tile;
	
	private void bgImage() {
		bgImage = new ImageIcon(Board.class.getResource("bgImage.jpg")).getImage();
	}
	
	public Board() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		bgImage();		
		bar = new Bar();
		tile = new Tiles();
		gameLoop();
		setFocusable(true); //use of setFocusable?
	}
	
	private void gameLoop() {
		timer = new Timer(DELAY,(e)-> {
			repaint();
		});
		timer.start();
	}
	
	private void drawBGImage(Graphics g) {
		g.drawImage(bgImage,0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);//why null
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBGImage(g);
		bar.drawRect(g);
		tile.formTiles();
		tile.drawTiles(g);
		bar.bindEvents();
	}
}
