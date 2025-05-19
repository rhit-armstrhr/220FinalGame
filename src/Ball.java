import java.awt.Graphics2D;
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
	private int currentFrame = 0;

	public Ball(double startX, double startY) {
		x = (int) startX;
		y = (int) startY;
		height = 0;

	}
	
	public Boolean checkPin(double l, double r, double b, double t) {
		//l = left, r = right, b = bottom, t = top of the border of the pin hole location for each hole passed in. 
		if(x <=r && l<=x && y<=b&&t<=y) {
			return true;
		}
		return false;
	}

	public void getBlown(double x,double y) {
		
	}

	public void getHit(double xLoc, double yLoc) {
		x =  xLoc;
		y = yLoc;
	
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(ballFrames.get(currentFrame), (int)x,(int) y,ballFrames.get(currentFrame).getWidth(), ballFrames.get(currentFrame).getHeight(), this);
		repaint();
	}

	public void nextHole(double startX, double startY) {
		x =  startX;
		y =  startY;
	}

//	public void update
}
