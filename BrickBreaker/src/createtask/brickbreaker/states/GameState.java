package createtask.brickbreaker.states;

import java.awt.Graphics;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.entities.creatures.Ball;
import createtask.brickbreaker.entities.creatures.Player;
import createtask.brickbreaker.physics.Collision;
import createtask.brickbreaker.tiles.Tile;
import createtask.brickbreaker.worlds.World;


//This entire class was done independently by me.
public class GameState extends State{
	
	private Player player;
	private World world;
	private Ball gameBall;
	private Collision collision;
	
	public GameState(Handler h) {
		super(h);
		world = new World(handler, "C:\\Users\\imsav\\eclipse-workspace\\BrickBreaker\\res\\worlds\\level1.txt");
		handler.setWorld(world);
		player = new Player(handler, 135, 385);
		gameBall = new Ball(handler, 200, 360);
		collision = new Collision(this);
		//generateBricks();
	}
	
	/*
	
	private void generateBricks() {
		bricks = new ArrayList<Brick>();
		int id = 0;
		for (int yPosition = 0; yPosition <= 100; yPosition += Assets.getBrickHeight()) {
			for (int xPosition = 10; xPosition <= 310; xPosition += Assets.getBrickWidth()) {
				bricks.add(new Brick(game, id, xPosition, yPosition));
				id++;
			}
		}
	}
	*/
	
	@Override
	public void update() {
		world.update();
		player.update();
		
		collision.checkBallBrickCollision();
		collision.checkBallPaddleCollision();
		gameBall.update();
		
		loseLife();
		gameOver();
		winGame();
	}
	
	public void loseLife() {
		if(gameBall.isBelowPaddle()) {
			player.loseLive();
		}
	}
	
	private void resetInputs() {
		gameBall.setX(200);
		gameBall.setY(360);
		player.setLives(3);
		player.setX(135);
		player.setY(385);
		
	}
	
	public void gameOver() {
		if(player.getLives() == 0) {
			State.setCurrentState(handler.getGame().getGameOverState());
			resetInputs();
			resetBlocks();
		}
	}
	
	private void resetBlocks() {
		int[][] reset = new int[world.getTiles().length][world.getTiles()[0].length];
		for(int row = 0; row < world.getTiles().length; row++) {
			for(int col = 0; col < world.getTiles()[0].length; col++) {
				reset[row][col] = 1;
			}
		}
		world.setTiles(reset);
	}
	
	private boolean isEmpty() {
		for (int row = 0; row < world.getTiles().length; row++) {
			for (int col = 0; col < world.getTiles()[0].length; col++) {
				if (world.getTiles()[row][col] != 2) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void winGame() {
		if(isEmpty() && player.getLives() != 0) {
			State.setCurrentState(handler.getGame().getVictoryState());
			resetInputs();
		}
	}

	@Override
	public void render(Graphics g) {	
		world.render(g);
		player.render(g);
		gameBall.render(g);
		
		
		/*
		//left side 
		Tile.tiles[0].render(g, 0, 0);
		Tile.tiles[0].render(g, 0, 100);
		Tile.tiles[0].render(g, 0, 200);
		Tile.tiles[0].render(g, 0, 300);
		//right side
		Tile.tiles[0].render(g, 390, 0);
		Tile.tiles[0].render(g, 390, 100);
		Tile.tiles[0].render(g, 390, 200);
		Tile.tiles[0].render(g, 390, 300);
		
		//render bricks
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).render(g);
		}
		*/
	}

	//Getter and Setter Methods

	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Ball getGameBall() {
		return gameBall;
	}

	public void setGameBall(Ball gameBall) {
		this.gameBall = gameBall;
	}
}
