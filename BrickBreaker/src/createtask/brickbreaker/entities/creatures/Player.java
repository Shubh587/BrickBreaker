package createtask.brickbreaker.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.gfx.Assets;
//This class besides the getInput() method was done independently by me.
public class Player extends Creature{
	public static final int DEFAULT_LIVES = 3;
	
	private Rectangle playerCollisionBound;
	private int lives;
	
	public Player(Handler h, float x, float y) {
		super(h, x, y, Assets.getPaddleWidth(), Assets.getPaddleHeight());
		collisionBounds.x = 0;
		collisionBounds.y = 0;
		collisionBounds.width = 170;
		collisionBounds.height = 33;
		lives = DEFAULT_LIVES;
	}

	@Override
	public void update() {
		getInput();
		move();
	}
	//This method was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2025/TileGame/src/dev/codenmore/tilegame/entities/creatures/Player.java
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
		
		
	}
	
	public Rectangle getPlayerCollisionBound() {
		playerCollisionBound = new Rectangle((int)x,(int)y, collisionBounds.width, collisionBounds.height);
		return playerCollisionBound;
	}
	
	public boolean isSolid() {
		return true; //true false as default
	}
	//This function was created by me independently
	public void loseLive() {
		lives--;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.getPaddle(), (int)x, (int)y, width, height, null);
		
		//Collision Box Rectangle
		//g.setColor(Color.red);
		//g.fillRect((int)(x + collisionBounds.x), (int)(y + collisionBounds.y), collisionBounds.width, collisionBounds.height);
	}
	
	//Getter and Setter Methods

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public static int getDefaultLives() {
		return DEFAULT_LIVES;
	}

	public void setPlayerCollisionBound(Rectangle playerCollisionBound) {
		this.playerCollisionBound = playerCollisionBound;
	}
	
	

}
