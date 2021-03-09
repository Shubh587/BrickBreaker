package createtask.brickbreaker.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//This class was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2030/TileGame/src/dev/codenmore/tilegame/gfx/ImageLoader.java
public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path)); //returns the buffered image object of our loaded image
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1); //if an image is not loaded, the game will not run
		}
		return null;
	}
}
