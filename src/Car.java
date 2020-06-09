/**
 * 	@author QUANG HIEU VO
 *	@version 2.0
 * 	Car class with inherits from Component with more fields and properties of the behavior of the car
 *  All code is written and images are drawed by Quang Hieu Vo
 *  Please email to voquanghieu28@gmail.com for permission to use the code and images
 */

import java.awt.Graphics;
import java.util.Random;


public class Car extends Component {
	
	/** 
	 * private fields for car's properties, reset point, player's score
	 */
	private int x;
	private final int resetX;
	private final int resetY;
	private static int score = 0;
	public boolean isYourCar = false;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor to create car component
	 * @param imgPath path of the image
	 * @param x x-positions by default
	 * @param y x-positions by default
	 * @param isYourCar boolean, true if its the player's car, false if it's computer's car
	 */
	Car(String imgPath, int x, int y, boolean isYourCar) {
		super(imgPath);

		this.x = x;
		setY(y);

		resetX = x; resetY = y;
		this.isYourCar = isYourCar;
	}

	/**
	 * Method to get the score of the player
	 * @return score of the player as an integer
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Method to get the score of the player
	 * @return score of the player as an integer
	 */
	public int getX() {
		return x;
	}

	/**
	 * Method to paint the car 
	 * @param paint Graphics object
	 */
	public void paintCar(Graphics paint) {
		paint.drawImage(getImage(), x, getY(), 80, 100, null);
	}

	/**
	 * Method to turn left
	 */
	public void moveLeft() {
		if (x > 110)
			x -= 10;
	}

	/**
	 * Method to turn right
	 */
	public void moveRight() {
		if (x < 310)
			x += 10;
	}

	/**
	 * Public method to move the car down
	 */
	public void move() {
		// Move down the car
		moveDown(GUIgame.speed, 800, -4800);
		
		// If the computer's cars passed player's car (means no crash) the score get incremented
		if (getY() == 430)
			score++;		
	}

	/**
	 * Public method if the player car crash any other cars
	 * @param array array or Cars
	 * @return return a boolean true if car is crashed (loose), false if nothing happen
	 */
	public boolean isCrash(Car[] array) {
		for (int i = 0; i < array.length; i++) {
			if ((Math.abs(x - array[i].getX()) < 80) && (Math.abs(getY() - array[i].getY()) < 100))
				return true;
		}
		return false;
	}

	/**
	 * Method to reset car positions when game restart
	 */
	public void reset() {
		x = resetX;
		setY(resetY);
		score = 0;
	}
}