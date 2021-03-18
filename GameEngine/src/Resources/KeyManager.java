package Resources;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Description - it has the keyboard typing to be use in the game
 * @author Michael J. Alvarado
 * @date Mar 22, 2020
 *
 */
public class KeyManager implements KeyListener {

	private static boolean[] keys,justPressed,cantPress;
	public static boolean up=false, down=false, left=false, right=false,shift=false;

	public KeyManager(){
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}

	public void tick(){
		for(int i =0; i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i]=false;
			}else if(justPressed[i]){
				cantPress[i]=true;
				justPressed[i] =false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i]=true;
			}
		}
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]; 
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		shift = keys[KeyEvent.VK_SHIFT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	/**
	 * Key pressed only once
	 * @author Michael J. Alvarado
	 * @date Mar 23, 2020
	 *
	 */
	public static boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	/**
	 * Key Hold
	 * @author Michael J. Alvarado
	 * @date Mar 23, 2020
	 *
	 */
	public static boolean keyHold(int keyCode) {
		return keys[keyCode];
	}
}