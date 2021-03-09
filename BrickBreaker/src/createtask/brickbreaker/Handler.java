package createtask.brickbreaker;

import createtask.brickbreaker.input.KeyManager;
import createtask.brickbreaker.input.MouseManager;
import createtask.brickbreaker.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game g) {
		game = g;
	}
	
	//Getters and Setters
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
}
