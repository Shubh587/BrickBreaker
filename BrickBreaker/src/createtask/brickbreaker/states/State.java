package createtask.brickbreaker.states;

import java.awt.Graphics;

import createtask.brickbreaker.Game;
import createtask.brickbreaker.Handler;
//This class was developed independently by me
public abstract class State {
	
	private static State currentState = null;
	protected Handler handler;
	
	public State(Handler h){
		handler = h;
	}
	
	//Abstract methods
	public abstract void update();
	public abstract void render(Graphics g);
	
	
	//Getter and Setter methods
	public static State getCurrentState() {
		return currentState;
	}
	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}


