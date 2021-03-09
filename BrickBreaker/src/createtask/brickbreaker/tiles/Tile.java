package createtask.brickbreaker.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import createtask.brickbreaker.gfx.Assets;
//This class except the render method was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2030/TileGame/src/dev/codenmore/tilegame/tiles/Tile.java
public class Tile {
	
	//STATIC VARIABLES
	public static Tile[] tiles = new Tile[256];
	public static Tile wall = new Wall(0); //an ID number of 0 will always represent a Wall Tile
	public static Tile brick = new Brick(1);
	public static Tile blank = new Blank(2);
	
	protected BufferedImage texture;
	protected final int ID;
	
	public Tile(BufferedImage texture, int ID) {
		this.texture = texture;
		this.ID = ID;
		
		tiles[ID] = this;
	}
	//This method was done independently be me.
	public void render(Graphics g, int x, int y) {
		if (ID == 0) {
			g.drawImage(texture, x, y, Assets.getWallWidth(), Assets.getWallHeight(), null);
		}
		else if (ID == 1){
			g.drawImage(texture, x, y, Assets.getBrickWidth(), Assets.getBrickHeight(), null);
		}
		else {
			g.drawImage(texture, x, y, Assets.getBlankWidth(), Assets.getBlankHeight(), null);
		}
	}
	
	public boolean isSolid() {
		return false; //returns false as default
	}
	
	public void update() {
		
	}
	
	//Getters and Setter Methods
	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public int getID() {
		return ID;
	}
	
	public static Tile[] getTiles() {
		return tiles;
	}

	public static void setTiles(Tile[] tiles) {
		Tile.tiles = tiles;
	}

	public static Tile getWall() {
		return wall;
	}

	public static void setWall(Tile wall) {
		Tile.wall = wall;
	}

	public static Tile getBrick() {
		return brick;
	}

	public static void setBrick(Tile brick) {
		Tile.brick = brick;
	}

	public static Tile getBlank() {
		return blank;
	}

	public static void setBlank(Tile blank) {
		Tile.blank = blank;
	}
	
}
