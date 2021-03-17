package GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import GameSetUp.Handler;
import Resources.Images;
import Scene.Scene;

/**
 * 
 * @author Michael J. Alvarado
 *	This class still testing
 *
 */
public class Camera {

	private int x,y;
	private int focalWidth, focalHeight;
	private GameObject focusPoint;
	private boolean debugging = false;

	public Camera(Scene scene, int width, int height, GameObject focusPoint) {
		this.focalWidth = width/2;
		this.focalHeight = height/2;
		this.focusPoint = focusPoint;
	}

	public void tick() {
		UpdateCamera();
		if(Handler.getKeyManager().keyJustPressed(KeyEvent.VK_T)) {
			debugging = !debugging;
		}
	}

	public void render(Graphics g) {
		//Draw Focal Point
		if(debugging) {
			Rectangle bound = new Rectangle(x, y, this.focalWidth, this.focalHeight);
			g.drawRect(bound.x, bound.y, focalWidth, focalHeight);
		}
	}

	private void UpdateCamera() {
		if(focusPoint.x > this.x+focalWidth) {
			this.x = focusPoint.x-focalWidth;
		}
		if(focusPoint.y > this.y+focalHeight) {
			this.y = focusPoint.y-focalHeight;
		}
		if(focusPoint.x < this.x) {
			this.x = focusPoint.x;
		}
		if(focusPoint.y < this.y) {
			this.y = focusPoint.y;
		}
		boundStop();
	}

	private void boundStop() {
		if(x<0) {
			x = 0;
		}
//		if(x+this.width>background.getWidth()) {
//			x = background.getWidth()-this.width;
//		}
		if(y<0) {
			y = 0;
		}
//		if(y+this.height>background.getHeight()) {
//			y = background.getHeight()-this.height;
//		}
	}
}
