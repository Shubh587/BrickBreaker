package createtask.brickbreaker.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import createtask.brickbreaker.Handler;
//This extended code was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2025/TileGame/src/dev/codenmore/tilegame/entities/Entity.java
public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height; //size of entity
	protected int diameter;
	protected Rectangle collisionBounds;
	
	public Entity(Handler h, float x, float y, int width, int height){
		handler = h;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		diameter = 0;
		
		collisionBounds = new Rectangle(0,0, width, height);
	}
	
	public Entity(Handler h, float x, float y, int d){
		handler = h;
		this.x = x;
		this.y = y;
		diameter = d;
		
		collisionBounds = new Rectangle(0,0, d, d);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

	//Getter and Setter Methods
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
