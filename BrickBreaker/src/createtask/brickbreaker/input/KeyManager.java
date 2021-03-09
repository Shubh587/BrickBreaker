package createtask.brickbreaker.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean left, right;
	
	public void update()
	{
		//Paddle Keys
		left = keys[KeyEvent.VK_A]; //the A key moves the paddle to the left
		right = keys[KeyEvent.VK_D]; //the D key moves the paddle to the right
	}
	
	
	public KeyManager()
	{
		keys = new boolean[256];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) { //called whenever a key is pressed on the keyboard
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) { //called whenever a key is released on the keyboard
		keys[e.getKeyCode()] = false;
	}
	
}
