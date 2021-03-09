package createtask.brickbreaker;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import createtask.brickbreaker.display.Display;
import createtask.brickbreaker.gfx.Assets;
import createtask.brickbreaker.input.KeyManager;
import createtask.brickbreaker.input.MouseManager;
import createtask.brickbreaker.states.GameOverState;
import createtask.brickbreaker.states.GameState;
import createtask.brickbreaker.states.MenuState;
import createtask.brickbreaker.states.State;
import createtask.brickbreaker.states.VictoryState;

public class Game implements Runnable{
	
	//JFrame and Canvas
	private Display display;
	private int width, height;
	private String title;
	
	//Threads
	private boolean running;
	private Thread thread;
	
	//Graphics
	private BufferStrategy bs; //tells the computer how to draw things to the screen. Buffer - hidden computer screen within your computer 
	private Graphics g; //"paint brush" for the canvas object
	
	//States
	private State gameState;
	private State menuState;
	private State gameOverState;
	private State victoryState;

	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Handler
	private Handler handler;
	
	
	//Constructor
	public Game(String t, int w, int h){
		width = w;
		height = h;
		title = t;
		running = false;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init(){ //initializes all the graphics of the game. Runs only once
		//I have extended code found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2029/TileGame/src/dev/codenmore/tilegame/Game.java
		display = new Display(title, height, width);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init(); //calls the init() method in the Assets Class and loads all the images in the sprite sheet
		
		handler = new Handler(this);
		
		//Initialize State objects. This code was independently done by me.
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		gameOverState = new GameOverState(handler);
		victoryState = new VictoryState(handler);
		
		//Set current state
		State.setCurrentState(menuState);
	}
	
	private void update(){
		
		keyManager.update();
		
		if(gameState != null) {
			State.getCurrentState().update();
		}
		
	}
	
	private void render() {
		//I have extended code found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2029/TileGame/src/dev/codenmore/tilegame/Game.java
		bs = display.getCanvas().getBufferStrategy(); //sets the buffered strategy of the game to the same buffered strategy of the canvas
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3); //creates 3 buffer strategies if there are none on the canvas
			return;
		}
		g = bs.getDrawGraphics();
		 
		//Clear screen
		g.clearRect(0, 0, width, height); 
		
		//Draw Here! (Order matters)
		if(State.getCurrentState() != null) {
			State.getCurrentState().render(g);
		}
		//End Drawing!
		
		bs.show(); //tells the computer to switch from the buffer screen to the actual screen
		g.dispose(); //ends Graphics object properly
	}
	
	public void run(){ //requirement to implement Runnable interface
		//The calculations were done at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2029/TileGame/src/dev/codenmore/tilegame/Game.java
		init();
		
		int fps = 60; //amount of times Game loop runs per second
		double timePerUpdate = 1000000000/fps;  //period = 1/frequency
		double delta = 0;
		long now;
		long  lastTime = System.nanoTime(); //current time in nanoseconds 
		long timer = 0;
		int updates = 0;
		
		
		while(running) { //GAME LOOP
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate; //amount of time until the Game loop has to run again
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				update();
				render();
				updates++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				updates = 0;
				timer = 0;
			}
				
		}
		
		stop();
	}

	public synchronized void start() //starts the thread
	{
		if (running){ //checks if the game is already running
			return;
		} else {
			running = true;
			thread = new Thread(this);
			thread.start(); //runs the run() method
		}
;	}
	
	public synchronized void stop() //stops the thread
	{
		if(!running) { //checks if the game has already stopped
			return;
		} else {
			running = false;
			try {
				thread.join(); //need to surround this statement in try/catch statement. this statement stops the thread safely
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
	}
	
	
	//Getter and Setter Methods. These methods were done by Eclipse itself. Source >> Generate Getters and Setters
	
	public Display getDisplay() {
		return display;
	}


	public void setDisplay(Display display) {
		this.display = display;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	public BufferStrategy getBs() {
		return bs;
	}
	
	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public void setMenuState(State menuState) {
		this.menuState = menuState;
	}

	public State getGameOverState() {
		return gameOverState;
	}

	public void setGameOverState(State gameOverState) {
		this.gameOverState = gameOverState;
	}

	public State getVictoryState() {
		return victoryState;
	}

	public void setVictoryState(State victoryState) {
		this.victoryState = victoryState;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public void setKeyManager(KeyManager keyManager) {
		this.keyManager = keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public void setMouseManager(MouseManager mouseManager) {
		this.mouseManager = mouseManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
