package GameSetUp;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import GUI.Display;
import Scene.Scene;
import Scene.TestScene;



/**
 * @author Michael J. Alvarado
 * Description: This class runs the game loop.
 * It initialize the keyboard and mouse settings and make the printable canvas for render.
 * 60FPS both render and tick.
 * Date - 11/March/2020
 */

public class GameEngine implements Runnable {
	//Running Game
	private Display display;
	private static boolean running = false;
	private Thread thread;
	//Paint Game
	public static boolean threadB;
	private BufferStrategy bs;
	private Graphics g;
	private Canvas canvas;
	private static final int FPS = 60;

	/**
	 * Description - Initialize Canvas, listeners, Game, VRMLFile, and Game thread.
	 * @author - Michael J. Alvarado
	 * @date Apr 23, 2020
	 */
	public GameEngine(Display display) {
		this.display = display;
		threadB = false;
		canvas = new Canvas();
		canvas.setBounds(0, 0, display.getContentPane().getWidth(), display.getContentPane().getHeight());
		canvas.setFocusable(true);
		display.getContentPane().add(canvas);
		new Handler(display, canvas, new TestScene());
	}
	
	public GameEngine(Display display, Scene scene) {
		this.display = display;
		threadB = false;
		canvas = new Canvas();
		canvas.setBounds(0, 0, display.getContentPane().getWidth(), display.getContentPane().getHeight());
		canvas.setFocusable(true);
		display.getContentPane().add(canvas);
		new Handler(display, canvas, scene);
	}

	public static int getFPS() {
		return FPS;
	}

	/**
	 * @author Michael J. Alvarado
	 * Date - 12/March/2020
	 * This method starts the game engine. 
	 * If this method is not run the game loop will not start.
	 */
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();		//this runs the run method in this  class
	}

	/**
	 * @author Michael J. Alvarado
	 * Date - 12/March/2020
	 * This method run the Game loop in fps constant
	 * Runs render and tick at same fps
	 */
	public void run(){
		double timePerTick = 1000000000 / FPS;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while(running){
			//makes sure the games runs smoothly at 60 FPS
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if(delta >= 1){
				//re-renders and ticks the game around 60 times per second
				render();
				tick();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	/**
	 * Description - This method is will run the game code 
	 * @author Michael J. Alvarado
	 * Date - 12/March/2020
	 */
	private void tick(){
		Handler.tick();
		if(Handler.getCurrentScene() != null) {
			Handler.getCurrentScene().tick();
		}
	}

	/**
	 * Description = This method will draw the game to the canvas	and make a bufferStrategy (preLoad draws)
	 * @author Michael J. Alvarado
	 * Date - 12/March/2020
	 */
	private void render(){
		bs = canvas.getBufferStrategy();

		if(bs == null){
			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		//Clear Screen
		g.clearRect(0, 0,  display.getWidth(), display.getHeight());

		//Draw Here!
		if(Handler.getCurrentScene() != null) {
			Handler.getCurrentScene().render(g);
		}
		canvas.setBounds(0, 0, display.getContentPane().getWidth(), display.getContentPane().getHeight()); //Resize Canvas

		//End Drawing!
		bs.show();
		g.dispose();

	}

	/**
	 * Description - This methods stops the game loop
	 * @author Michael J. Alvarado
	 * Date - 12/March/2020
	 */
	private synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void stopLoop() {
		running = false;
	}

}