package game.frame;

import java.awt.Toolkit;

import javax.swing.JFrame;

import game.board.Board;
import game.constants.Constants;

class Frame extends JFrame implements Constants{
	public Frame() {
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		Board board = new Board();
		add(board);
		Toolkit.getDefaultToolkit().sync();
	}
}

public class DxBall3 {

	public static void main(String[] args) {
		Frame frame = new Frame();

	}

}
