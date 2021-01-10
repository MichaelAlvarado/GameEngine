package Resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Michael J. Alvarado
 * @date Jan 09, 2021
 * This class is use to place all your image file and load them for use in the Engine
 * Make a public static BufferedImage in the class and use load the images as the example in the Cronstuctor Images()
 */
public class Images {

	public static BufferedImage[] testAnimation;



	public Images() {


		testAnimation = new BufferedImage[9];

		try {

			testAnimation[0] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (1).png")); //IDLE
			testAnimation[1] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (2).png")); //IDLE
			testAnimation[2] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (3).png")); //IDLE
			testAnimation[3] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (4).png")); //IDLE
			testAnimation[4] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (5).png")); //IDLE
			testAnimation[5] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (6).png")); //IDLE
			testAnimation[6] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (7).png")); //IDLE
			testAnimation[7] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (8).png")); //IDLE
			testAnimation[8] = ImageIO.read(new File("res/animation_Images/a_girl/Idle (9).png")); //IDLE

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
