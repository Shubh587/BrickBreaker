package createtask.brickbreaker.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.gfx.Assets;

public class Ball extends Creature{
	
	private Rectangle ballCollisionBound;
	private double dx = 3, dy = 6;

	public Ball(Handler h, float x, float y) {
		super(h, x, y, Assets.getBallDiameter());
		collisionBounds.x = 0;
		collisionBounds.y = 0;
		collisionBounds.width = Assets.getBallDiameter();
		collisionBounds.height = Assets.getBallDiameter();
	}
	//This section of code was found in this video: https://www.youtube.com/watch?v=GPjbcQSR6Sg&t=178s
	@Override
	public void update() {
		setPosition();
	}
	
	public void setPosition() {
		x += dx;
		y += dy;
		
		if (x < 0) {
			dx = -dx;
		}
		if (y < 0) {
			dy = -dy;
		}
		if (x > handler.getWidth() - Assets.getBallDiameter()) {
			dx = -dx;
		}
		if (y > handler.getHeight() - Assets.getBallDiameter()) {
			dy = -dx;
		}
	}
	//This section of code below was developed independently by me
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.getBall(), (int)x, (int)y, Assets.getBallDiameter(), Assets.getBallDiameter(), null);
	}
	
	public Rectangle getballCollisionBound() {
		ballCollisionBound = new Rectangle((int)x,(int)y,Assets.getBallDiameter(), Assets.getBallDiameter());
		return ballCollisionBound;
	}
	
	public boolean isBelowPaddle() {
		if (y >= handler.getHeight()) {
			return true;
		}
		return false;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void setDy(double dy) {
		this.dy = dy;
	}
	
	public double getDx() {
		return dx;
	}
	
	public void setDx(double dx) {
		this.dx = dx;
	}

}
