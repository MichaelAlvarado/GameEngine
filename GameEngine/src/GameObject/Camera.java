package GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;
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
	}

	@Override
	public void render(Graphics g) {
		BufferedImage background = this.background.getSubimage(x, y, width, height);
		g.drawImage(background,0,0,Handler.getWidth(),Handler.getHeight(),null);
		
		//Draw Focal Point
//		Rectangle bound = new Rectangle(x+(focalWidth/2), y+(focalHeight/2), this.focalWidth, this.focalHeight);
//		g.drawRect(bound.x, bound.y, focalWidth, focalHeight);
	}
	
	private void UpdateCamera() {
		Rectangle bound = new Rectangle(x+(focalWidth/2), y+(focalHeight/2), this.focalWidth, this.focalHeight);
		if(!bound.contains(player.x, player.y)) {
			this.x = player.x;
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
