package createtask.brickbreaker.gfx;

import java.awt.image.BufferedImage;
//This extended code was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2030/TileGame/src/dev/codenmore/tilegame/gfx/SpriteSheet.java
public class SpriteSheet {
private BufferedImage sheet;
	
	public SpriteSheet (BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x,y,width,height);
	}
}
