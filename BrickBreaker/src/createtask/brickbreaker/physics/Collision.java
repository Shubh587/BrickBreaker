package createtask.brickbreaker.physics;

import java.awt.Rectangle;

import createtask.brickbreaker.states.GameState;
//The code from this video (https://www.youtube.com/watch?v=5_h7FlPtJRQ) helped me develop this class; however, the code was not copy/pasted directly
public class Collision {
	private GameState gameState;
	
	public Collision(GameState gs) {
		gameState = gs;
	}
	public void checkBallPaddleCollision() {	
		Rectangle ballCollisionRect = gameState.getGameBall().getballCollisionBound();
		Rectangle playerCollisionRect = gameState.getPlayer().getPlayerCollisionBound();
		if (ballCollisionRect.intersects(playerCollisionRect)) {
			gameState.getGameBall().setDy(-(gameState.getGameBall().getDy()));
		}
	}
	
	public void checkBallBrickCollision() {
		Rectangle ballCollisionRect = gameState.getGameBall().getballCollisionBound();
	 	for (int row = 0; row < gameState.getWorld().getTiles().length; row++) {
	 		
			for (int col = 0; col < gameState.getWorld().getTiles()[0].length; col++) {
				
				if (gameState.getWorld().getTiles()[row][col] == 1) {
					
					Rectangle brickCollisionRect = new Rectangle(row *75, col * 50, 75, 50);
					
					if (ballCollisionRect.intersects(brickCollisionRect)) {
						//First: set the brick tile to the blank tile
						gameState.getWorld().convertBrickToBlank(row, col);
						//Second: change the direction of the ball's movement
						gameState.getGameBall().setDy(-(gameState.getGameBall().getDy()));
						break;
					}	
				}
			}
		}
	}
}
