package Scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import GameObject.Camera;
import GameObject.Floor;
import GameObject.GameObject;
import GameObject.Player;
import GameObject.Player2;
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
public class TestScene implements Scene{

	Player2 player;	
	Camera camera;
	public List<Floor> objects;
	/**
	 * Always called at first frame
	 */
	public TestScene() {
		player = new Player2(this,0,0,40,45);
		//camera = new Camera(this, 200, 200, player, Images.Background);
		objects = new ArrayList<Floor>();
		objects.add(new Floor(0,100,300,10));
		
	}

	/**
	 * Method used to run your game engine code (run in the fixed FPS of the game engine).
	 */
	public void tick() {
		player.tick();
		//camera.tick();
		for(Floor f:objects) {
			f.tick();
		}
	}

	/**
	 * Method used to make visuals of your game (run in the fixed FPS of the game engine).
	 * @param g - Graphics g to print on game engine canvas
	 */
	public void render(Graphics g) {
		//camera.render(g);
		player.render(g);
		for(Floor f:objects) {
			f.render(g);
		}
		//Draw the text
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Move with w a s d keys", Handler.getWidth()/2, 30);
	}
}
