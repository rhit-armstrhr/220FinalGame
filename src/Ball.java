import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Frank LaMantia and Hayden Armstrong
 * 
 */

public class Ball extends JPanel {

	private double x, y;
	private int height;
	private ArrayList<BufferedImage> ballFrames = Animations.ballArc();
	private int currentFrame = 0;
	private boolean moving;

	private int frameCounter = 0;
	private final int FRAME_DELAY = 6;
	private final double SPEED = 4;
	private final double PUTTSPEED = 2;
	private double speed = SPEED;
	private double destX, destY;
	private double speedx, speedy;
	private double totalDist, halfDist, traveledDist;
	private int countDirection = 1;
	private boolean putt = false;
	private double lastx, lasty;
	private int xset, yset;

	public Ball(double startX, double startY) {
		x = (int) startX;
		y = (int) startY;
		height = 0;

	}

	public void getBlown(double x, double y) {

	}

	public void getHit(double xLoc, double yLoc, Clubs p) {
		if (p.getName().equals("Putter")) {
			putt = true;
			speed = PUTTSPEED;
		} else {
			speed = SPEED;
			putt = false;
		}
		lastx = x;
		lasty = y;
		destX = xLoc;
		destY = yLoc;
		double dx = destX - x;
		double dy = destY - y;
		totalDist = Math.hypot(dx, dy);
		halfDist = totalDist / 2;
		speedx = speed * dx / totalDist;
		speedy = speed * dy / totalDist;
		moving = true;

	}

	public void draw(Graphics2D g2) {
		xset = ballFrames.get(currentFrame).getWidth() / 2;
		yset = ballFrames.get(currentFrame).getHeight() / 2;
		g2.drawImage(ballFrames.get(currentFrame), (int) (x - xset), (int) (y - yset),
				ballFrames.get(currentFrame).getWidth(), ballFrames.get(currentFrame).getHeight(), this);
		repaint();
	}

	public void nextHole(double startX, double startY) {
		x = startX;
		y = startY;
	}

	public boolean checkIfMoving() {
		if (putt)
			return false;
		return moving;
	}

	public void update() {
		if (!moving)
			return;

		double step = Math.hypot(speedx, speedy);
		x += speedx;
		y += speedy;
		traveledDist += step;

		double xdist = destX - x;
		double ydist = destY - y;
		if (Math.hypot(xdist, ydist) <= speed) {
			x = destX;
			y = destY;
			moving = false;
			putt = false;
			traveledDist = 0;
			currentFrame = 0;
//			System.out.println("stopped");
		}

		if (Math.abs(traveledDist) >= Math.abs(halfDist)) {
			countDirection = -1;
		} else {
			countDirection = 1;
		}

		if (!putt) {
			if (currentFrame <= 0) {
				currentFrame = 0;
				countDirection = 1;
			}

			frameCounter++;
			if (frameCounter >= FRAME_DELAY) {
				frameCounter = 0;
				currentFrame = (currentFrame + countDirection) % ballFrames.size();
//			System.out.println(currentFrame + " and count" + countDirection);
			}
		}
//		System.out.println(frameCounter);

	}

	public void setMoving(boolean b) {
		moving = b;

	}

	public double getXPosition() {
		return (x);
	}

	public double getYPosition() {
		return (y);
	}

	public void reset() {
		x = lastx;
		y = lasty;
	}
}
