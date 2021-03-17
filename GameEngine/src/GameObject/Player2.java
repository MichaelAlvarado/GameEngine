package GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import GameSetUp.Handler;
import Resources.Animation;
import Resources.Images;
import Scene.Scene;
import Scene.TestScene;

/**
 * 
 * @author Michael J. Alvarado
 * @date Jan 12, 2021
 * Sample player
 *
 */
public class Player2 extends GameObject{

	public int speed = 2;
	public Animation animationR, animationL, animationIdleL, animationIdleR;
	private boolean facingLeft = false;
	private boolean moving = false;
	private boolean falling = false;
	private Rectangle bound; 
	private Scene scene;


	public Player2(Scene scene, int x, int y, int width, int height) {
		super(x,y,width,height);
		this.bound = new Rectangle(x,y,width, height);
		this.animationR = new Animation(Images.CharacterSpriteRight,0.6);
		this.animationL = new Animation(Images.CharacterSpriteLeft,0.6);
		this.animationIdleL = new Animation(Images.CharacterSpriteIdleLeft,0.6);
		this.animationIdleR = new Animation(Images.CharacterSpriteIdleRight,0.6);
		this.scene = scene;

	}
	public Rectangle getBound() {return bound;}
	
	@Override
	public void tick() {
		if(Handler.getKeyManager().left) {
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
		gravity();
		updateBound();
		boundStop();
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
	
	private void updateBound() {
		this.bound.setBounds(x, y, width, height);;
	}
	
	private void boundStop() {
		if(x<0) {
			x = 0;
		}
		if(x>Handler.getWidth()) {
			x = Handler.getWidth();
		}
		if(y<0) {
			y = 0;
		}
		if(y>Handler.getHeight()) {
			y = Handler.getHeight();
		}
	}
	
	private void jump() {
		
	}
	
	private void gravity() {
		falling = true;
		for(Floor obj : ((TestScene) scene).objects) {
			if(obj.getBound().contains(x+(width/2),y+height)) {
				falling = false;
			}
		}
		if(falling) {
			y++;
		}
	}
}
