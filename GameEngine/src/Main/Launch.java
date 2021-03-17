package Main;

import java.awt.EventQueue;

import GUI.Display;
import GameSetUp.GameEngine;
import GameSetUp.Handler;
import Scene.Scene;

public class Launch {
	/*
	 * Launch Application
	 */
	public final static String ProjectName = "Project"; //You can change this to which ever Name you want
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Loading App...");
					long start = System.nanoTime();
					Display display = new Display(ProjectName);
					GameEngine gameEngine = new GameEngine(display);
					gameEngine.start();
					System.out.println("App Loaded in: " + ((System.nanoTime()-start)/1000000000.0) + " seconds");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public static void runScene(Scene scene) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Loading App...");
					long start = System.nanoTime();
					Display display = new Display(ProjectName);
					GameEngine gameEngine = new GameEngine(display, scene);
					gameEngine.start();
					System.out.println("App Loaded in: " + ((System.nanoTime()-start)/1000000000.0) + " seconds");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
