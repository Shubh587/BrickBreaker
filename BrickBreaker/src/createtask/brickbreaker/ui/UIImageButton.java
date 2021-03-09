package createtask.brickbreaker.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.gfx.Assets;
import createtask.brickbreaker.states.State;

public class UIImageButton extends UIObject{
	
	private BufferedImage[] images;
	private ClickListener clicker;
	private Handler handler;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, Handler h, ClickListener clicker) {
		super(x,y,width,height);
		this.images = images;
		this.clicker = clicker;
		handler = h;
	}

	@Override
	public void update() {
	}

	@Override
	//This section of code was done by me independently.
	public void render(Graphics g) {
		if (State.getCurrentState() == handler.getGame().getMenuState()) {
			if(hovering) {
				g.drawImage(images[1], (int)objX, (int)objY, objWidth, objHeight, null);
			} else {
				g.drawImage(images[0], (int)objX, (int)objY, objWidth, objHeight, null);
			}
		} else if (State.getCurrentState() == handler.getGame().getGameOverState()) {
			g.drawImage(images[2], 60, 200, Assets.getRestartWidth(), Assets.getRestartHeight(), null);
		} else if(State.getCurrentState() == handler.getGame().getVictoryState()) {
			g.drawImage(images[2], 80, 200, Assets.getRestartWidth(), Assets.getRestartHeight(), null);
		}
	}
	
	@Override
	public void onClick() {
		clicker.onClick();
	}
	
	//Getters and Setters

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public ClickListener getClicker() {
		return clicker;
	}

	public void setClicker(ClickListener clicker) {
		this.clicker = clicker;
	}
	
	
}
