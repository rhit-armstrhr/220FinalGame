import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Frank LaMantia and Hayden Armstrong
 * Used only 220 materials
 */

public class Ball extends JPanel {

	private double x, y;
	private int height;
	private ArrayList<BufferedImage> ballFrames = Animations.ballArc();

	public Ball(double startX, double startY) {
		x = startX;
		y = startY;
		height = 0;

	}

	public void getBlown(double x,double y) {
		
	}

	public void getHit(double xLoc, double yLoc) {
		x = xLoc;
		y = yLoc;
	
	}

}
