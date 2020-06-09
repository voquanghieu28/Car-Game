/**
 * 	@author QUANG HIEU VO
 *	@version 2.0
 * 	Paint class which painting and controlling the components
 *  All code is written and images are drawed by Quang Hieu Vo
 *  Please email to voquanghieu28@gmail.com for permission to use the code and images
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Paint extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	// Player's car component
	public Car yourCar = new Car("/car1.png", 210, 330, true);

	// Street line component
	Component line = new Component("/line.png");
	
	// Grass component
	Component grass = new Component("/grass.png");
	
	// Computer's cars array
	Car[] cars = {    
			new Car("/car2.png", 115, 0, false), 		new Car("/car3.png", 300, -600, false), 	new Car("/car4.png", 208, -1200, false),
			new Car("/car5.png", 208, -1800, false), 	new Car("/car6.png", 115, -1800, false), 	new Car("/car7.png", 300, -2400, false),
			new Car("/car10.png", 300, -3000, false), 	new Car("/car9.png", 115, -3000, false),	new Car("/car8.png", 208, -3600, false),
			new Car("/car12.png", 300, -4200, false), 	new Car("/car11.png", 208, -4200, false), 	};

	Thread threadPaint;

	/**
	 * Public constructor to create paint thread
	 */
	public Paint() {
		threadPaint = new Thread(this);
		threadPaint.start();
	}

	/**
	 * Public method to draw all the components of the game
	 */
	public void paint(Graphics paint) {	
		// Paint the road
		paint.setColor(Color.GRAY);
		paint.fillRect(0, 0, 500, 500);
		paint.fillRect(0, 0, 500, 500);

		// Paint the white line on the street
		line.paintImage(paint, 240, new int[] {-500, -400, -300, -200, -100, 0, 100, 200, 300, 400, 500, 600, 700}, 20 , 50);	
		
		// Paint the grass
		grass.paintImage(paint, new int[][] {{0,0}, {0,-500}, {400,0}, {400,-500}}, 100, 500);
		
		// Paint player's car
		yourCar.paintCar(paint);
		
		// Paint the score
		paint.setColor(Color.black);
		paint.setFont(new Font("Calibri", Font.BOLD, 41));
		paint.drawString("Score", 2, 250);
		paint.drawString(Integer.toString(yourCar.getScore()), 35, 300);

		// Paint computer's car
		for (int i = 0; i < 11; i++)
			cars[i].paintCar(paint);
	}

	
	/**
	 * Public method to run and all the components and graphic movements of the game
	 */
	public void run() {
		while (true) {
			repaint();
			
			// Move all the computer's cars
			for (int i = 0; i < cars.length; i++)
				cars[i].move();
			
			// Move the white line and grass
			line.moveDown(GUIgame.speed, 500, 100);
			grass.moveDown(GUIgame.speed, 500, 0);
			
			try { 
				Thread.sleep(6L, 100000); //3L
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (yourCar.isCrash(cars)) {	
				playAgainDialog();
			} 
		}
	}
	
	/**
	 * Public method to ask user if they want to play the game again
	 */
	public void playAgainDialog() {
		int reply = JOptionPane.showConfirmDialog(null, "Want to play again?", "YOU LOOSE", 0);
		if (reply == 0) {
			for (int i = 0; i < 11; i++)
				cars[i].reset();

			threadPaint = new Thread(this);
			threadPaint.start();

		} else {
			System.exit(0);
		}
		threadPaint.stop();
	}
	
}

    