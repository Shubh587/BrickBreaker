package createtask.brickbreaker.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
//This extended code was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2034/TileGame/src/dev/codenmore/tilegame/ui/UIObject.java
public abstract class UIObject{
	
	protected float objX, objY;
	protected int objWidth, objHeight;
	protected boolean hovering = false;
	protected Rectangle hoveringBounds;
	
	
	public UIObject(float x, float y, int width, int height) {
		objX = x;
		objY = y;
		objWidth = width;
		objHeight = height;
		hoveringBounds = new Rectangle((int)objX, (int)objY, objWidth, objHeight);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(hoveringBounds.contains(e.getX(), e.getY())) {
			hovering = true;
		} else {
			hovering = false;
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		if (hovering) {
			onClick();
		}
	}
	
}
