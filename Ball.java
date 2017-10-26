package game.ball;

import java.awt.Color;
import java.awt.Graphics;

import game.constants.Constants;
import game.gameutils.GameUtils;

public class Ball implements Constants {
	static GameUtils red = new GameUtils(255);
	static GameUtils green = new GameUtils(255);
	static GameUtils blue = new GameUtils(255);
	static GameUtils xrSpeed;
	static GameUtils yrSpeed;
	private int xBall = FRAME_WIDTH/2;
	private int yBall = FRAME_HEIGHT/2;
	private int xSpeed;
	private int ySpeed;
	
	private Color color = new Color(red.getRandomNumber(), green.getRandomNumber(), blue.getRandomNumber());
	
	public void formBall(Graphics g) {
		g.setColor(color);
		g.fillOval(xBall,yBall,30,30);
	}
	
	public void changeDirection() {
		
		if(yBall >= FRAME_HEIGHT-48) {
			ySpeed = -ySpeed;
		}
		if(xBall >= FRAME_WIDTH-50) {
			xSpeed = -xSpeed;
		}
		if(yBall <= 0) {
			ySpeed = -ySpeed;
		}
		if(xBall <= 0) {
			xSpeed = -xSpeed;
		}
	}

	public void moveBall() {
		changeDirection();
		xBall += xSpeed;
		yBall += ySpeed;
	}
	
	
	public Ball() {
		xSpeed = 10;
		ySpeed = 10;
	}

	public int getxBall() {
		return xBall;
	}

	public void setxBall(int xBall) {
		this.xBall = xBall;
	}

	public int getyBall() {
		return yBall;
	}

	public void setyBall(int yBall) {
		this.yBall = yBall;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

}