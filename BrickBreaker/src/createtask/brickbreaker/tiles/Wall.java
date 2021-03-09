package createtask.brickbreaker.tiles;

import java.awt.Rectangle;

//This class was done independently by me.
import createtask.brickbreaker.gfx.Assets;

public class Wall extends Tile{
	
	private Rectangle leftWallCollisionBound;
	private Rectangle rightWallCollisionBound;

	public Wall(int ID) {
		super(Assets.getWall(), ID);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
	public Rectangle getLeftWallCollisionBound() {
		leftWallCollisionBound = new Rectangle(0, 0, Assets.getWallWidth(), Assets.getWallHeight() * 8);
		return leftWallCollisionBound;
	}
	
	public Rectangle getRightWallCollisionBound() {
		rightWallCollisionBound = new Rectangle(390, 0, Assets.getWallWidth(), Assets.getWallHeight() * 8);
		return rightWallCollisionBound;
	}
	
}
