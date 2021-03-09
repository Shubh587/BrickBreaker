package createtask.brickbreaker.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.gfx.Assets;
import createtask.brickbreaker.ui.ClickListener;
import createtask.brickbreaker.ui.UIImageButton;
import createtask.brickbreaker.ui.UIManager;
//This class was developed independently by me
public class VictoryState extends State{
	
	private UIManager uiManager;
	
	public VictoryState(Handler h) {
		super(h);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		uiManager.addObject(new UIImageButton(150, 200, Assets.getButtons()[2].getWidth(), Assets.getButtons()[2].getHeight(), Assets.getButtons(), handler, new ClickListener(){

			@Override
			public void onClick() {
				State.setCurrentState(handler.getGame().getGameState());
			}
			}));
	}

	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.setColor(null);
		
		Font menuFont = new Font("arial", Font.PLAIN, 50);
		g.setFont(menuFont);
		g.setColor(Color.white);
		g.drawString("YOU WIN!", 115, 100);
		
		uiManager.render(g);
	}

}
