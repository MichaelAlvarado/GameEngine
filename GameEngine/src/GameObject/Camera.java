package GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import GameSetUp.Handler;
import Resources.Images;
import Scene.Scene;

public class Camera implements GameObject{

	private int width, height;
	private int x, y;
	private int focalWidth, focalHeight;
	private Player player;
	private BufferedImage background;
	private boolean debugging = false;

	public Camera(Scene scene, int width, int height, Player focusPoint, BufferedImage background) {
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
		this.focalWidth = width/2;
		this.focalHeight = height/2;
		this.player = focusPoint;
		this.background = background;
	}

	@Override
	public void tick() {
		UpdateCamera();
		if(Handler.getKeyManager().keyJustPressed(KeyEvent.VK_T)) {
			debugging = !debugging;
		}
	}

	@Override
	public void render(Graphics g) {
		BufferedImage background = this.background.getSubimage(x, y, width, height);
		g.drawImage(background,0,0,Handler.getWidth(),Handler.getHeight(),null);

		//Draw Focal Point
		if(debugging) {
			Rectangle bound = new Rectangle(x, y, this.focalWidth, this.focalHeight);
			g.drawRect(bound.x, bound.y, focalWidth, focalHeight);
		}
	}

	private void UpdateCamera() {
		if(player.x > this.x+focalWidth) {
			this.x = player.x-focalWidth;
		}
		if(player.y > this.y+focalHeight) {
			this.y = player.y-focalHeight;
		}
		if(player.x < this.x) {
			this.x = player.x;
		}
		if(player.y < this.y) {
			this.y = player.y;
		}
		boundStop();
	}

	private void boundStop() {
		if(x<0) {
			x = 0;
		}
		if(x+this.width>background.getWidth()) {
			x = background.getWidth()-this.width;
		}
		if(y<0) {
			y = 0;
		}
		if(y+this.height>background.getHeight()) {
			y = background.getHeight()-this.height;
		}
	}
}
