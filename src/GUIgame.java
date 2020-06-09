/**
 * 	@author QUANG HIEU VO
 *	@version 2.0
 * 	GUIgame class contain main method to run the game. Also handle user key input
 *  All code is written and images are drawed by Quang Hieu Vo
 *  Please email to voquanghieu28@gmail.com for permission to use the code and images
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUIgame extends JFrame {

	private static final long serialVersionUID = 1L;
	Paint paint;
	
	// Constant holding speed for each level
	public static final int EASY = 1;
	public static final int MEDIUM = 2;
	public static final int HARD = 3;
	
	// Speed by user selection
	public static int speed;

	/**
	 * Constructor to create the Paint and control the player's key input
	 */
	public GUIgame() {
		levelSelect();
        paint = new Paint();
		
		setSize(500, 500);
		setTitle("FAST AND FURIOUS");
		setVisible(true);
		setDefaultCloseOperation(3);
		setLocation(400, 100);
		setResizable(false);
		add(paint);

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int key = ke.getKeyCode();	
				if (key == 37) paint.yourCar.moveLeft();
				if (key == 39) paint.yourCar.moveRight();	
			}
		});
	}

	/**
	 * Main method to run the games
	 * @param args
	 */
	public static void main(String[] args) {
		new GUIgame();
	}
	
	/**
	 * Dialog box to ask player for level (EASY, MEDIUM, HARD)
	 */
	public void levelSelect() {
		String[] options = {"EASY", "MEDIUM"};
        int choice = JOptionPane.showOptionDialog(null, "TOO FAST, TO FURIOUS", "CHOOSE YOUR LEVEL!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        switch(choice) {
		    case 0:
		    	speed = EASY;
		      break;
		    case 1:
		    	speed = MEDIUM;
		      break;
		    default:
		    	speed = HARD;  	
        }
	}

}
    
