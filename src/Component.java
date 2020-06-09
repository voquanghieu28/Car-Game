/**
 * 	@author QUANG HIEU VO
 *	@version 2.0
 * 	Component class with basics fields and properties to create an image object
 *  All code is written and images are drawed by Quang Hieu Vo
 *  Please email to voquanghieu28@gmail.com for permission to use the code and images
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Component extends javax.swing.JPanel {
	
	private BufferedImage image;
	private int y;
	
	/**
     * Overloaded constructor to load and read image path
     * @param imagePath directory of the image of the  component
     */
	public Component(String imagePath) {
		try {
			  image = ImageIO.read(this.getClass().getResourceAsStream(imagePath));
		  } catch(IOException ex) {
			  ex.printStackTrace();
		  }
	}
	
	/**
     * Method to draw image component which take a fixed x-position and an array of y-positions
     * @param paint Graphics objects
     * @param x x-position of the components
     * @param yPositions y-positions  of the components
     * @param width width of the components
     * @param height height of the components
     */
	public void paintImage(Graphics paint, int x, int[] yPositions, int width, int height) {
		for (int y : yPositions)  
			paint.drawImage(getImage(), x, getY() + y, width, height, null);
	}
	
	/**
     * Method to draw image component which take a fixed x-position and a fixed y-position
     * @param paint Graphics objects
     * @param x x-position of the component
     * @param y y-position of the component
     * @param width width of the component
     * @param height height of the component
     */
	public void paintImage(Graphics paint, int x, int y, int width, int height) {
			paint.drawImage(getImage(), x,  y, width, height, null);
	}
	
	/**
     * Method to draw image component which take a 2D array of x and y positions
     * @param paint Graphics objects
     * @param x x-position of the component
     * @param y y-position of the component
     * @param width width of the component
     * @param height height of the component
     */
	public void paintImage(Graphics paint, int[][] positions, int width, int height) {
		for(int[] position: positions) 
			paint.drawImage(getImage(), position[0], getY() + position[1], width, height, null);
	}
	
	/**
     * Method to move the component down. When the component reach the y given point,
     * it will be set to reset point
     * @param speed speed of the movement
     * @param reachedPoint
     * @param resetPoint
     */
	public void moveDown(int speed, int reachedPoint, int resetPoint) {
		setY(getY() + speed);
		if (getY() == reachedPoint) setY(resetPoint);  	
	}

	/**
	 * Public getter 
	 * @return return image of the component as BufferedImage
	 */
	public BufferedImage getImage() { return image;}
	
	/**
	 * Public setter to set buffer image
	 * @param image BufferedImage object
	 */
	public void setImage(BufferedImage image) {this.image = image;}

	/**
	 * Public getter 
	 * @return return y-positions of the component as an integer
	 */
	public int getY() {return y;}
	
	/**
	 * Public setter to set y
	 * @param y y-position
	 */
	public void setY(int y) {this.y = y;}
	
}
