package Resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;

/**
 * @author Michael J. Alvarado
 * @date Jan 09, 2021
 * This class is use to place all your image file and load them for use in the Engine
 * Make a public static BufferedImage in the class and use load the images as the example in the Cronstuctor Images()
 */
public class Images {

	private static Hashtable<String, BufferedImage> Images = new Hashtable<String, BufferedImage>();


	//Testing Images
	public static BufferedImage[] CharacterSpriteRight;
	public static BufferedImage[] CharacterSpriteLeft;
	public static BufferedImage[] CharacterSpriteIdleRight;
	public static BufferedImage[] CharacterSpriteIdleLeft;

	public static BufferedImage Background;

	/**
	 * Loads testing Images
	 */
	public Images() {

		CharacterSpriteRight = new BufferedImage[9];
		CharacterSpriteLeft = new BufferedImage[9];
		CharacterSpriteIdleRight = new BufferedImage[9];
		CharacterSpriteIdleLeft = new BufferedImage[9];

		try {
			CharacterSpriteIdleRight[0] = ImageIO.read(new File("res/animation_Images/boy/Idle (1).png")); //IDLE
			CharacterSpriteIdleRight[1] = ImageIO.read(new File("res/animation_Images/boy/Idle (2).png")); //IDLE
			CharacterSpriteIdleRight[2] = ImageIO.read(new File("res/animation_Images/boy/Idle (3).png")); //IDLE
			CharacterSpriteIdleRight[3] = ImageIO.read(new File("res/animation_Images/boy/Idle (4).png")); //IDLE
			CharacterSpriteIdleRight[4] = ImageIO.read(new File("res/animation_Images/boy/Idle (5).png")); //IDLE
			CharacterSpriteIdleRight[5] = ImageIO.read(new File("res/animation_Images/boy/Idle (6).png")); //IDLE
			CharacterSpriteIdleRight[6] = ImageIO.read(new File("res/animation_Images/boy/Idle (7).png")); //IDLE
			CharacterSpriteIdleRight[7] = ImageIO.read(new File("res/animation_Images/boy/Idle (8).png")); //IDLE
			CharacterSpriteIdleRight[8] = ImageIO.read(new File("res/animation_Images/boy/Idle (9).png")); //IDLE

			CharacterSpriteRight[0] =  ImageIO.read(new File("res/animation_Images/boy/Walk (1).png"));
			CharacterSpriteRight[1] =  ImageIO.read(new File("res/animation_Images/boy/Walk (2).png"));
			CharacterSpriteRight[2] =  ImageIO.read(new File("res/animation_Images/boy/Walk (3).png"));
			CharacterSpriteRight[3] =  ImageIO.read(new File("res/animation_Images/boy/Walk (4).png"));
			CharacterSpriteRight[4] =  ImageIO.read(new File("res/animation_Images/boy/Walk (5).png"));
			CharacterSpriteRight[5] =  ImageIO.read(new File("res/animation_Images/boy/Walk (6).png"));
			CharacterSpriteRight[6] =  ImageIO.read(new File("res/animation_Images/boy/Walk (7).png"));
			CharacterSpriteRight[7] =  ImageIO.read(new File("res/animation_Images/boy/Walk (8).png"));
			CharacterSpriteRight[8] =  ImageIO.read(new File("res/animation_Images/boy/Walk (9).png"));

			//Lefts
			CharacterSpriteIdleLeft[0] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (1).png")); //IDLE
			CharacterSpriteIdleLeft[1] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (2).png")); //IDLE
			CharacterSpriteIdleLeft[2] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (3).png")); //IDLE
			CharacterSpriteIdleLeft[3] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (4).png")); //IDLE
			CharacterSpriteIdleLeft[4] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (5).png")); //IDLE
			CharacterSpriteIdleLeft[5] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (6).png")); //IDLE
			CharacterSpriteIdleLeft[6] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (7).png")); //IDLE
			CharacterSpriteIdleLeft[7] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (8).png")); //IDLE
			CharacterSpriteIdleLeft[8] = ImageIO.read(new File("res/animation_Images/boy/IdleLeft (9).png")); //IDLE

			CharacterSpriteLeft[0] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (1).png"));
			CharacterSpriteLeft[1] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (2).png"));
			CharacterSpriteLeft[2] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (3).png"));
			CharacterSpriteLeft[3] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (4).png"));
			CharacterSpriteLeft[4] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (5).png"));
			CharacterSpriteLeft[5] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (6).png"));
			CharacterSpriteLeft[6] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (7).png"));
			CharacterSpriteLeft[7] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (8).png"));
			CharacterSpriteLeft[8] =  ImageIO.read(new File("res/animation_Images/boy/WalkLeft (9).png"));

			Background = ImageIO.read(new File("res/background/Engine.png"));
		}catch (IOException e) {
//			e.printStackTrace();
		}
	}

	/**
	 * This method is use to preload a image to rapidly access later on.
	 * @param name - name to access the image (using get method)
	 * @param path - Tha path of the image from this project file
	 * @return the newly loaded Buffered Image
	 */
	public static BufferedImage LoadImage(String name, String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
			Images.put(name, image);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Get the Image already loaded using LoadImage method
	 * @param name - name of Image
	 * @return - the loaded Buffered Image
	 */
	public static BufferedImage get(String name) {
		return Images.get(name);
	}

}
