package createtask.brickbreaker.gfx;

import java.awt.image.BufferedImage;

import createtask.brickbreaker.gfx.SpriteSheet;
//This class was developed by me independently.
public class Assets {
	private static final int BRICK_WIDTH = 75, BRICK_HEIGHT = 50, BALL_DIAMETER = 45, PADDLE_WIDTH = 170, PADDLE_HEIGHT = 33, WALL_WIDTH = 75, WALL_HEIGHT = 50, BLANK_WIDTH = 75, BLANK_HEIGHT = 50, START_PLAIN_WIDTH = 288, START_PLAIN_HEIGHT = 110, START_HOVER_WIDTH = 300, START_HOVER_HEIGHT = 100, RESTART_WIDTH = 313, RESTART_HEIGHT = 125; 
	
	
	private static BufferedImage brick, ball, paddle, wall, blank;
	private static BufferedImage[] buttons = new BufferedImage[256];
	
	public static void init() { //loads every image into the game
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\imsav\\eclipse-workspace\\BrickBreaker\\res\\textures\\BrickBreaker Sheet.png"));
		
		brick = sheet.crop(23, 43, BRICK_WIDTH, BRICK_HEIGHT);
		ball = sheet.crop(160, 54, BALL_DIAMETER, BALL_DIAMETER);
		paddle = sheet.crop(267, 51, PADDLE_WIDTH, PADDLE_HEIGHT);
		wall = sheet.crop(557, 34, WALL_WIDTH, WALL_HEIGHT);
		blank = sheet.crop(770, 31, BLANK_WIDTH, BLANK_HEIGHT);
		buttons[0] = sheet.crop(12, 198, START_PLAIN_WIDTH, START_PLAIN_HEIGHT); //Button 0: Start Button on the Main Screen
		buttons[1] = sheet.crop(363, 206, START_HOVER_WIDTH, START_HOVER_HEIGHT);
		buttons[2] = sheet.crop(23, 387, RESTART_WIDTH, RESTART_HEIGHT);
	}
	
	//Getter and Setter Methods

	public static BufferedImage getBrick() {
		return brick;
	}

	public static void setBrick(BufferedImage brick) {
		Assets.brick = brick;
	}

	public static BufferedImage getBall() {
		return ball;
	}

	public static void setBall(BufferedImage ball) {
		Assets.ball = ball;
	}

	public static BufferedImage getPaddle() {
		return paddle;
	}

	public static void setPaddle(BufferedImage paddle) {
		Assets.paddle = paddle;
	}

	public static int getBrickWidth() {
		return BRICK_WIDTH;
	}

	public static int getBrickHeight() {
		return BRICK_HEIGHT;
	}

	public static int getBallDiameter() {
		return BALL_DIAMETER;
	}

	public static int getPaddleWidth() {
		return PADDLE_WIDTH;
	}

	public static int getPaddleHeight() {
		return PADDLE_HEIGHT;
	}

	public static BufferedImage getWall() {
		return wall;
	}

	public static void setWall(BufferedImage wall) {
		Assets.wall = wall;
	}

	public static int getWallWidth() {
		return WALL_WIDTH;
	}

	public static int getWallHeight() {
		return WALL_HEIGHT;
	}

	public static BufferedImage getBlank() {
		return blank;
	}

	public static void setBlank(BufferedImage blank) {
		Assets.blank = blank;
	}

	public static int getBlankWidth() {
		return BLANK_WIDTH;
	}

	public static int getBlankHeight() {
		return BLANK_HEIGHT;
	}

	public static int getStartWidth() {
		return START_PLAIN_WIDTH;
	}

	public static int getStartHeight() {
		return START_PLAIN_HEIGHT;
	}
	
	public static BufferedImage[] getButtons() {
		return buttons;
	}

	public static void setButtons(BufferedImage[] buttons) {
		Assets.buttons = buttons;
	}

	public static int getStartPlainWidth() {
		return START_PLAIN_WIDTH;
	}

	public static int getStartPlainHeight() {
		return START_PLAIN_HEIGHT;
	}

	public static int getStartHoverWidth() {
		return START_HOVER_WIDTH;
	}

	public static int getStartHoverHeight() {
		return START_HOVER_HEIGHT;
	}

	public static int getRestartWidth() {
		return RESTART_WIDTH;
	}

	public static int getRestartHeight() {
		return RESTART_HEIGHT;
	}
}
