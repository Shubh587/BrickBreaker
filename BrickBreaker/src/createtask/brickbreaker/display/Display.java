package createtask.brickbreaker.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
//This extended code was found at https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%2030/TileGame/src/dev/codenmore/tilegame/display/Display.java
public class Display {
	//PROPERTIES
	private JFrame frame; //everything on canvas is brought to the JFrame object so that th euser can see it
	private Canvas canvas; //everything is drawn on canvas
	private Dimension dimension;
	
	private String title;
	private int width; //in pxs
	private int height; // in pxs
	
	
	//Constructor
	public Display(String t, int w, int h){
		title = t;
		width = w;
		height = h;
		dimension = new Dimension(width, height);
		
		//initialize frame in another function
		createDisplay();
	}
	
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program closes down properly
		frame.setResizable(false); //user can resize the window
		frame.setLocationRelativeTo(null); //frame loads in the center of the screen
		frame.setVisible(true); //by default JFrames are not visible to the user, this line of code changes that default condition
		
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMaximumSize(dimension); // ensures that the canvas stays the same size as the JFrame
		canvas.setMinimumSize(dimension);
		canvas.setFocusable(false); //allows the application to focus itself and allows the JFrame to be the only thing that focuses
		
		frame.add(canvas); //adds canvas object to the JFrame object
		frame.pack(); //resizes window the see all the drawings on the canvas object
	}
	
	
	
	//Getter and Setter Methods


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public Canvas getCanvas() {
		return canvas;
	}


	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}


	public Dimension getDimension() {
		return dimension;
	}


	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
	
}
