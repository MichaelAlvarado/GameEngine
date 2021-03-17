package Resources;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import GameSetUp.GameEngine;


/**
 * Description - This class contains method to animate images
 * @author Michael J. Alvarado 
 * @date Apr 9, 2020
 */
public class Animation {

	private double tick = 0;
	private double time; 
	private double timePerImage;
	private int x,y,width,height;
	private BufferedImage[] animation;

	/**
	 * Description - this Object will have images that it can animate (Mainly use for Effects)
	 * PostCondition - it has to implement the method render(g) so it can be displayed on Canvas
	 * @author Michael J. Alvarado
	 * @param images - list of Images to animate through time. The first at the array is idle image(Cannot be an empty list)
	 * @param x - position on the canvas it want to be drawn
	 * @param y - position on the canvas it want to be drawn
	 * @param width - width to be drawn
	 * @param height - height to be drawn
	 * @param time - time in seconds for the animation last
	 */
	public Animation(BufferedImage[] images, int x, int y, int width, int height, double time) {
		this.time = time;
		this.animation = images;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if(images != null)
			timePerImage = time/animation.length;
	}

	public Animation(BufferedImage[] images, double time) {
		this.time = time;
		this.animation = images;
		if(images != null && animation.length > 0)
			timePerImage = time/animation.length;
	}
	
	public BufferedImage[] getAnimation() {
		return animation;
	}

	public void setAnimation(BufferedImage[] animation) {
		this.animation = animation;
	}

	public void setBound(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 * Description - paint of Canvas the Animation sprite only if animation started
	 * Precondition - the animation must be provided with x, y, width, height;
	 * @author - Michael J. Alvarado
	 * @date Apr 9, 2020
	 */
	public void render(Graphics g) {
		if(isAnimating()) {
			g.drawImage(getCurrentFrame(), x, y, width, height, null);
		}
	}
	
	/**
	 * 
	 * Description - paint of Canvas the Animation sprite only if animation started
	 * Precondition - the animation must be provided with x, y, width, height;
	 * @author - Michael J. Alvarado
	 * @date Apr 9, 2020
	 */
	public void renderWithIdle(Graphics g) {
		g.drawImage(getCurrentFrame(), x, y, width, height, null);
	}

	/**
	 * Starts animation 
	 */
	public void startAnimation() {
		if(tick > 0) {
			return;
		}
		tick = 1;
	}

	/**
	 * Stop animation and go to idle 
	 */
	public void stopAnimation() {
		tick = 0;
	}

	public boolean isAnimating() {
		return tick > 0;
	}

	/**
	 * Description - This method animate the images from the animation in the time
	 * PreCondition - This method should be implemented in render 
	 * @author - Michael J. Alvarado
	 * @date Apr 9, 2020
	 * @return the image that should be displaying
	 */
	public BufferedImage getCurrentFrame() {
		if(tick == 0) {
			return animation[0]; //idle image
		}
		else {
			tick++;
			if(tick/(double)GameEngine.getFPS() == time) {
				tick = 0;
			}
			int currentIndex = (int)((tick)/(double)(GameEngine.getFPS())/timePerImage);
			return animation[currentIndex];
		}
	}

}
