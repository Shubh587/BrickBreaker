package createtask.brickbreaker.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import createtask.brickbreaker.Handler;
//This extended code was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2034/TileGame/src/dev/codenmore/tilegame/ui/UIManager.java
public class UIManager {
	
	private Handler handler;
	private ArrayList<UIObject> objects; 
	
	public UIManager(Handler h) {
		handler = h;
		objects = new ArrayList<UIObject>();
	}
	
	public void update() {
		for(UIObject o: objects){
			o.update();
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o: objects){
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for(UIObject o: objects){
			o.onMouseMove(e);
		}
	}

	public void onMouseRelease(MouseEvent e) {
		for(UIObject o: objects){
			o.onMouseRelease(e);
		}
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}
}
