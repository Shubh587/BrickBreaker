package createtask.brickbreaker.worlds;

import java.awt.Graphics;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.tiles.Tile;
import createtask.brickbreaker.utility.Utils;
//This class was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2020/TileGame/src/dev/codenmore/tilegame/worlds/World.java, besides from the render function.
public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles; //contains all the tile data for the world
	
	
	public World(Handler h, String path) {
		handler = h;
		loadWorld(path);
	}
	
	public void update() {

	}
	//This render(Graphics g) method was completed independently by me.
	public void render(Graphics g) {
		int xStart = 0, yStart = 0, xEnd = width, yEnd = height;
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x,y).render(g,(x*75),(y*50));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height){
			return Tile.wall;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.wall;
		}
		return t;
	}
	
	public void convertBrickToBlank(int x, int y) {
		if (tiles[x][y] == 1) {
			tiles[x][y] = 2;
		}
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y * width) + 4]);
			}
		}
	}

	//Getter and Setter Methods
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
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

	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}

	public int[][] getTiles() {
		return tiles;
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}
}

/* The images used in this app came from: 
 * Brick - https://www.pinterest.com/pin/771874823620821532/
 * Ball - https://www.tynker.com/community/projects/play/brick-breaker-template-for-web/59e8c0035ae0292f4d8b4645
 * Paddle - https://code.tutsplus.com/tutorials/create-an-iphone-inspired-switch-checkbox-using-flash-and-actionscript-30--active-2382
 * Wall - https://www.xmple.com/wallpaper/checkered-grey-black-squares-7680x4320-c2-000000-696969-l-280-a-0-f-2-image/
 * Blank - Developed using Google Drawing by myself
 * Start Button (not hovering) - https://www.pngwing.com/en/free-png-zajlo (edited to different color using pixelartmaker.com)
 * Start Button (hovering) - Standard button on http://pixelartmaker.com/
 * Restart Button - https://www.kindpng.com/imgv/obbowx_reset-button-restart-button-pixel-art-8-bit/
 */
