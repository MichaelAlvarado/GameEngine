package UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameSetUp.Handler;

public abstract class Button {

	public int x, y, width, height;
	public BufferedImage image;
	
	public Button(int x, int y, int width, int height, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	public abstract void onClick();
	
	public void tick() {
		if(Handler.getMouseManager().clickedOn(new Rectangle(x,y,width,height))) {
			onClick();
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}
	
}
