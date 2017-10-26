package game.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.ball.Ball;
import game.bar.Bar;
import game.constants.Constants;
import game.tiles.Tiles;

public class Board extends JPanel implements Constants {
	private Image bgImage;
	private Timer timer;
	private Bar bar;
	private Ball ball;
	
	private void bgImage() {
		bgImage = new ImageIcon(Board.class.getResource("bgImage.jpg")).getImage();
	}
	
	public Board() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		bgImage();		
		bar = new Bar();
		ball = new Ball();
		formTiles();
		settingX_Ytile();
		gameLoop();
		setFocusable(true);
		bar.bindEvents();
		
		//setDoubleBuffered(true);
		//setFocusable(true); //use of setFocusable - To focus on JPanel
	}
	
	
	Tiles tiles[][] = new Tiles[5][19];
	
	public void formTiles() {
		for(int u=0; u<=4; u++)	{
			for(int t=0; t<=18; t++) {
				Tiles tile = new Tiles();
				tiles[u][t] = tile;
			}	
		}
	}
	
	private void settingX_Ytile() {
		for(int u=0; u<=4; u++) {
			for(int t=0; t<=18; t++) {
				tiles[u][t].setxTile(62*t);
				tiles[u][t].setyTile(37*u);
			}	
		}
	}
	
	private boolean isGameOver;
	private void isGameOver() {
		isGameOver=true;
		for(int u=0; u<=4; u++)	{
			for(int t=0; t<=18; t++) {
				if(tiles[u][t].isTiles_isVisible()==true) {
					isGameOver=false;
					break;
				}	
			}	
		}
	}
	
	private int Score;
	private void drawScore(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("ARIEL", Font.ITALIC, 100));
		String score = "Score = "+ Score;
		g.drawString(score, FRAME_WIDTH/2, FRAME_HEIGHT/2);
	}
	
	private void gameOver(Graphics g) {
		if(isGameOver) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("Helvetica", Font.BOLD, 50));
			String gameOver = "YOU WON ";
			g.drawString(gameOver, (FRAME_WIDTH/2-20), FRAME_HEIGHT/2);
			timer.stop();
		}
	}
	
	public boolean isCollision(Tiles nearest, Ball ball) {
		int xDistance = nearest.getxTile()-ball.getxBall();
		int yDistance = nearest.getyTile()-ball.getyBall();
		
		return (xDistance<=nearest.getW()+7.5 && xDistance>=-22.5 && yDistance<=nearest.getH()+7.5 && yDistance>=-22.5);
	}
	
	private void checkCollision() {
		for(int u=0; u<=4; u++)	{
			for(int t=0; t<=18; t++) {
				if(tiles[u][t].isTiles_isVisible()==true) {
					if(isCollision(tiles[u][t],ball)) {
						tiles[u][t].setTiles_isVisible(false);
						ball.setySpeed(-ball.getySpeed());
						Score++;
					}
				}
			}	
		}
	}
	
	private void gameLoop() {
		timer = new Timer(DELAY,(e)-> {
			bar.move();
			ball.moveBall();
			checkCollision();
			isGameOver();
			
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
//		tile.drawTiles(g);
		ball.formBall(g);
		gameOver(g);
		drawScore(g);
		for(int u=0; u<=4; u++)	{
			for(int t=0; t<=18; t++) {
				
				if(tiles[u][t].isTiles_isVisible()) {
					
					tiles[u][t].drawTiles(g);
					
				}
			}	
		}
		
			
	}
}
