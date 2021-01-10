package GameSetUp;

import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import GUI.Display;
import Resources.Images;
import Resources.KeyManager;
import Resources.MouseManager;
import Resources.SoundManager;
import Scene.Scene;

/**
 * 
 * @author Michael J. Alvarado
 * @date Mar 22, 2020
 * This class will be use to handle keyboard, mouse, music, and other IO
 * PreCondition - These methods should only be access by the Game
 *
 */
public class Handler {
	
	private static Display display;
	private static Canvas canvas;
	//Scene
	private static Scene scene;
	//Managers
	private static KeyManager keyManager;
	private static MouseManager mouseManager; 
	private static SoundManager soundManager;
	

	public Handler(Display display, Canvas canvas) {
		Handler.display = display;
		Handler.canvas = canvas;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		soundManager = new SoundManager();
		canvas.setFocusable(true);
		canvas.requestFocusInWindow();
		canvas.addKeyListener(keyManager);
		canvas.addMouseMotionListener(mouseManager);
		canvas.addMouseListener(mouseManager);
		new Images(); //initialize the images
		scene = new Scene();
	}

	public static void tick() {
		keyManager.tick();
		mouseManager.tick();
	}

	public static int getWidth() {
		return canvas.getWidth();
	}

	public static int getHeight() {
		return canvas.getHeight();
	}

	public static KeyManager getKeyManager() {
		return keyManager;
	}

	public static MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public static SoundManager getSoundManager() {
		return soundManager;
	}
	
	public static Scene getCurrentScene() {
		return scene;
	}

}
