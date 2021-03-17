package GameObject;

import java.awt.Graphics;

public abstract class GameObject {
	
	public int x, y, width, height;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void render(Graphics g, int x, int y) {
		
	}
	
}
