package Resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import GameSetUp.Handler;

public abstract class Button {

	String message;
	String name; //Temporal Use for printing
	Rectangle rec;
	int fontSize;
	Color color;

	public Button(String message, int fontSize, int x, int y, int width, int height, Color color) {
		this.message = message;
		rec = new Rectangle(x,y,width,height);
		this.color = color;
		this.fontSize = fontSize;
		name = message;

	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void tick() {
		if(Handler.getMouseManager().clickedOn(rec)) {
			action();
		}
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRoundRect(rec.x, rec.y, rec.width, rec.height, 20, 20);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		g.drawString(message, rec.x+5, rec.y+(rec.height/2)+(fontSize/2));
	}

	private void StringLineDivider() {
		for(int i = 0; i < message.length(); i++) {
			if(i*fontSize>rec.width) {
				name = name.substring(0, i) + "\n" + name.substring(i);
				System.out.println(name);
				break;
			}
		}
	}
	
	public abstract void action();

}
