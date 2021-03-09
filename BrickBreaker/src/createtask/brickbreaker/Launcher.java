package createtask.brickbreaker;

import createtask.brickbreaker.display.Display;
//This code was developed by me independently
public class Launcher {
	
	public static void main(String[] args) //MAIN METHOD
	{
		Game game = new Game("BrickBreaker", 450, 450);
		game.start();
	}

}
