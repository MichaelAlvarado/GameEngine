package Scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import GameSetUp.Handler;
import Resources.Animation;
import Resources.Images;

/**
 * @author Michael J. Alvarado
 * @date Jan 09, 2021
 * This is your scene our your project. The tick and render plays at the same fixed FPS based on the game engine
 * the render method is used to visuals of your scene (first game view)
 * the tick method is used to 
 */
public class Scene {
	
	Animation animation;//Test animation
	
	/**
	 * Always called at first frame
	 */
	public Scene() {
		animation = new Animation(Images.testAnimation, 0.6);
	}
	
	/**
	 * Method used to run your game engine code (run in the fixed FPS of the game engine).
	 */
	public void tick() {
		//Example Scene tick
		if(Handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)){
			animation.startAnimation(); //Start sample idle animation
		}
		if(Handler.getKeyManager().keyHold(KeyEvent.VK_SHIFT)) {
			animation.startAnimation(); //Start sample idle animation

		}
	}
	
	/**
	 * Method used to make visuals of your game (run in the fixed FPS of the game engine).
	 * @param g - Graphics g to print on game engine canvas
	 */
	public void render(Graphics g) {
		//Example Scene render 
		int width = 90, height = 90;
		int x = Handler.getWidth()/2-width;
		int y = Handler.getHeight()/2-height;
		//Animation Sample
		g.drawImage(animation.getCurrentFrame(), x, y, width, height,null);
		//Draw the text
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Press Space to Play Animation. Press Shift to continue Animation", x-width, y-30);
	}
}
