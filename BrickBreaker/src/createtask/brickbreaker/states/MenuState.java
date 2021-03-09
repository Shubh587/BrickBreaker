package createtask.brickbreaker.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import createtask.brickbreaker.Handler;
import createtask.brickbreaker.gfx.Assets;
import createtask.brickbreaker.ui.ClickListener;
import createtask.brickbreaker.ui.UIImageButton;
import createtask.brickbreaker.ui.UIManager;
//This class was developed independently by me
public class MenuState extends State{
	
	private Rectangle startBtn = new Rectangle(160, 150, 100, 50);
	private Rectangle settingsBtn = new Rectangle(140, 250, 150, 50);
	private Rectangle quitBtn = new Rectangle(160, 350, 100, 50);
	private UIManager uiManager;
	
	public MenuState(Handler h){
		super(h);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		uiManager.addObject(new UIImageButton(150, 200, 128, 64, Assets.getButtons(), handler, new ClickListener(){

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
		g.drawString("Brick Breaker", 60, 100);
		
		uiManager.render(g);
		/*
		Graphics2D g2D = (Graphics2D) g; //casts g to a Graphics2D object 
		g.setColor(Color.black);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.setColor(null);
		
		Font menuFont = new Font("arial", Font.PLAIN, 50);
		g.setFont(menuFont);
		g.setColor(Color.white);
		g.drawString("Brick Breaker", 60, 100);
		
		Font btnFont = new Font("Monospaced", Font.BOLD, 30);
		g.setFont(btnFont);
		g.setColor(Color.CYAN);
		g.drawString("Start", startBtn.x + 6, startBtn.y + 40);
		g.setColor(Color.white);
		g2D.draw(startBtn);
		
		
		g.setColor(Color.CYAN);
		g.drawString("Settings", settingsBtn.x + 2, settingsBtn.y + 40);
		g.setColor(Color.white);
		g2D.draw(settingsBtn);
		
		g.setColor(Color.CYAN);
		g.drawString("Quit", quitBtn.x + 12, quitBtn.y + 40);
		g.setColor(Color.white);
		g2D.draw(quitBtn);
		*/
	}
}
