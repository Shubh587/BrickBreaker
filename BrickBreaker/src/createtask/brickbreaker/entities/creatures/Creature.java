package createtask.brickbreaker.entities.creatures;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.entities.Entity;
import createtask.brickbreaker.gfx.Assets;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 3;
	public static final float DEFAULT_SPEED = 3.0f;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler h, float x, float y, int width, int height) {
		super(h, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public Creature(Handler h, float x, float y, int diameter) {
		super(h, x, y, diameter);
	}
	
	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX() {
		x += xMove;
		/*
		if(xMove > 0) {//Moving to the right
			int tempXRight = (int)(x + xMove + collisionBounds.x + collisionBounds.width) / 75;//x-coordinate of tile we are trying to move
			
			if(!collisionWithTile(tempXRight, (int)(y + collisionBounds.y) / 50) && (!collisionWithTile(tempXRight, (int)(y + collisionBounds.y + collisionBounds.height) / 50))) {
				x += xMove;
			} else {
				x = tempXRight * 75 - collisionBounds.x - collisionBounds.width - 1;
			}
		} else if(xMove < 0) { //Moving to the left
			int tempXLeft = (int)(x + xMove + collisionBounds.x) / 75;//x-coordinate of tile we are trying to move
			
			if(!collisionWithTile(tempXLeft, (int)(y + collisionBounds.y) / 50) && (!collisionWithTile(tempXLeft, (int)(y + collisionBounds.y + collisionBounds.height) / 50))) {
				x += xMove;
			} else {
				x = tempXLeft * 75 + 75 - collisionBounds.x;
			}
		}
		*/
	}
	
	public void moveY() {
		y += yMove;
		/*
		if (yMove < 0) {//Up
			int tempYUp = (int)(y + yMove + collisionBounds.y + collisionBounds.height) / 50;
			
			if (!collisionWithTile((int) (x + collisionBounds.x) / 75, tempYUp) && !collisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / 75, tempYUp)) {
				y += yMove;
			} else {
				y = tempYUp * 50 + 50 - collisionBounds.y;
			}
		} else if(yMove > 0) {//Down
			int tempYDown = (int)(y + yMove + collisionBounds.y) / 50;
			
			if (!collisionWithTile((int) (x + collisionBounds.x) / 75, tempYDown) && !collisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / 75, tempYDown)) {
				y += yMove;
			} else {
				y = tempYDown * 50 - collisionBounds.y - collisionBounds.height - 1;
			}
		}
		*/
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	//Getter and Setter Methods
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	
}
