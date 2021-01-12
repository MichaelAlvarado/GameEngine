package GameObject;

import java.awt.Graphics;

import GameSetUp.Handler;
import Resources.Animation;
import Resources.Images;

/**
 * 
 * @author Michael J. Alvarado
 * @date Jan 12, 2021
 * Sample player
 *
 */
public class Player implements GameObject{

	public int x=0, y=0, width=10, height=10; //Position
	public int speed = 2;
	public Animation animationR, animationL, animationIdleL, animationIdleR;
	private boolean facingLeft = false;
	private boolean moving = false;

	public Player() {} //Default Constructor

	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.animationR = new Animation(Images.CharacterSpriteRight,0.6);
		this.animationL = new Animation(Images.CharacterSpriteLeft,0.6);
		this.animationIdleL = new Animation(Images.CharacterSpriteIdleLeft,0.6);
		this.animationIdleR = new Animation(Images.CharacterSpriteIdleRight,0.6);

	}

	@Override
	public void tick() {
		if(Handler.getKeyManager().up) {
			moving = true;
			this.y -= speed;
			animate().startAnimation();
		}
		else if(Handler.getKeyManager().down) {
			moving = true;
			this.y += speed;
			animate().startAnimation();
		}
		else if(Handler.getKeyManager().left) {
			facingLeft = true;
			moving = true;
			this.x -= speed;
			animate().startAnimation();
		}
		else if(Handler.getKeyManager().right) {
			facingLeft = false;
			moving = true;
			this.x += speed;
			animate().startAnimation();
		}
		else {
			moving = false;
		}
		updateAnimationPosition();		
		animate().startAnimation();

	}

	@Override
	public void render(Graphics g) {
		animate().render(g);
	}

	//returns the animation that should be playing in the current time
	private Animation animate() {
		if(moving) {
			if(facingLeft) {
				return animationL;
			}
			else {
				return animationR;
			}
		}
		else {
			if(facingLeft) {
				return animationIdleL;
			}
			else {
				return animationIdleR;
			}
		}
	}

	//Make sure all animation positions are in the players position
	private void updateAnimationPosition() {
		animationL.setBound(x, y, width, height);
		animationR.setBound(x, y, width, height);
		animationIdleL.setBound(x, y, width, height);
		animationIdleR.setBound(x, y, width, height);
	}

}
