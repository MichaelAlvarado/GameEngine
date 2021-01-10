package Resources;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Description - This class has the mouse movement and methods for the use of the Game
 * @author Michael J. Alvarado
 * @date Mar 22, 2020
 */
public class MouseManager implements MouseListener, MouseMotionListener{

	int x,y;//Position of the mouse
	boolean pressed, click;
	int timer = 0;

	public MouseManager(){
		pressed = false;
		click = false;
	}

	public void tick() {
		if(pressed || click) {
			if(timer > 1) {
				pressed = false;
				click = false;
				timer = 0;
			}
			timer++;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
		click = false;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		x = arg0.getX();
		y = arg0.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		click = true;
	}
	/**
	 * @author Michael J. Alvarado
	 * @date Mar 30, 2020
	 * @param rec - Rectangle where the mouse should click
	 */
	public boolean clickedOn(Rectangle rec) {
		return click && rec.contains(x,y);
	}
	/**
	 * @author Michael J. Alvarado
	 * @date Mar 30, 2020
	 * @param rec - Rectangle where the mouse should pressed
	 */
	public boolean pressedOn(Rectangle rec) {
		return pressed && rec.contains(x,y);
	}
}