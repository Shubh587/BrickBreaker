package createtask.brickbreaker.tiles;

import java.awt.image.BufferedImage;

import createtask.brickbreaker.gfx.Assets;
////This class was developed independently by me
public class Brick extends Tile{
	
	public static final int DEFAULT_HEALTH = 10;
	
	private int health;

	public Brick(int ID) {
		super(Assets.getBrick(), ID);
		health = DEFAULT_HEALTH;
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
