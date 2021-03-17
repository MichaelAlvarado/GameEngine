package Resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	public BufferedImage[] images;
	
	//Take Horizontal 
	public Sprite(String path, int x, int y, int width, int height, int maxX, int xSpacing) {
		LoadImageSprite(path,x,y,width,height,maxX, xSpacing);
	}
	
	/**
	 * This method is use to preload a image to rapidly access later on.
	 * @param name - name to access the image (using get method)
	 * @param path - Tha path of the image from this project file
	 * @return the newly loaded Buffered Image
	 */
	public BufferedImage LoadImageSprite(String path, int x, int y, int width, int height, int maxX, int xSpacing) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
			int maxWidth = (maxX-x)/(width+xSpacing);
			images = new BufferedImage[maxWidth];
//			System.out.println(image.getWidth());
			int index = 0;
//			System.out.println("Size: "+maxWidth);
			for(int i = x; index < maxWidth; i += (width+xSpacing)) {
//				System.out.println(index);
				images[index] = image.getSubimage(i, y, width, height);
				index++;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
