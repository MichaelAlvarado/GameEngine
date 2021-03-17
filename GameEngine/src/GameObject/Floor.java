package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Floor extends GameObject{

	private Rectangle bound;
	
	public Floor(int x, int y, int width, int height) {
		super(x,y,width,height);
		bound = new Rectangle(x,y,width,height);
	}
	public Rectangle getBound() {return bound;}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		bound.setBounds(x,y,width,height);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
	
	
}
