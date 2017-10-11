package game.gameutils;

import java.util.Random;

public class GameUtils {
	Random r = new Random();
	int range;
	
	public GameUtils(int range) {
		this.range = range;
	}

	public int getRandomNumber(){
		
		return r.nextInt(this.range);
		}
}
