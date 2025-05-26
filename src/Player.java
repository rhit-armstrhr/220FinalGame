import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel {
	public int strokes;
	private double xLoc, yLoc;
	private double xAim, yAim, angle;
	private int clubIndex = 0;
	private Clubs currentClub;
	private double shotAngle = 90;
	private double range;
	public ArrayList<Clubs> clubList = new ArrayList<Clubs>();
	private ArrayList<BufferedImage> clubImage;
	private Ball ball;
	private Random r = new Random();
	private double errorx, errory;
	private double error = 50;
	private boolean sand;
	private double lastx;
	private double lasty;
	private double debuff;
	private double d;

	public Player(double startX, double startY, Ball ball) {
		// TODO Auto-generated constructor stub
		strokes = 0;
		Clubs driver = new Clubs(450, "driver");
		Clubs iron = new Clubs(275, "iron");
		Clubs wedge = new Clubs(90, "wedge");
		Clubs putter = new Clubs(30, "putter");

		clubList.add(driver);
		clubList.add(iron);
		clubList.add(wedge);
		clubList.add(putter);
		currentClub = clubList.get(clubIndex);
		range = currentClub.getRange();
		double y = startY;
		double x = startX; // done needs to be changed to be an argument in the player class when we get
							// the chance
		xLoc = x;
		yLoc = y;
		xAim = range + xLoc;
		yAim = yLoc;
		angle = 0;

		this.ball = ball;

		clubImage = Animations.clubs();
	}

	public void moveAim(double dAngle) {
		if (currentClub.getName().equals("driver"))
			d = 0.3;
		else if (currentClub.getName().equals("iron"))
			d = 0.4;
		else
			d = 1;
		angle += (dAngle * d);

		yAim = yLoc + range * Math.sin(angle) * debuff;
		xAim = xLoc + range * Math.cos(angle) * debuff;

//		System.out.println("aiming @" + angle + ",  " + dAngle);
//		System.out.println(xAim+",  "+yAim + ", " + dAngle);
		repaint();
	}

	public void swing(double power) {
		if (!ball.checkIfMoving()) {
			if (power > 1) {
				errorx = error * (r.nextDouble() * 2 - 1);
				errory = error * (r.nextDouble() * 2 - 1);
				System.out.println(errorx + " and y:" + errory);
			} else {
				errorx = 0;
				errory = 0;
			}
			lastx = xLoc;
			lasty = yLoc;

			xLoc += debuff * power * currentClub.getRange() * Math.cos(angle) + errorx;
			yLoc += debuff * power * currentClub.getRange() * Math.sin(angle) + errory;
			strokes += 1;
			moveAim(0); // update the aim function so it gets redrawn
			repaint();
			ball.getHit(xLoc, yLoc, currentClub);
		} else
			System.out.println("Wait");
	}

	public void switchClub() {
		clubIndex += 1;
		if (clubIndex > 3)
			clubIndex = 0;
		currentClub = clubList.get(clubIndex);
		range = currentClub.getRange();
		this.moveAim(0);
		repaint();
	}

	protected void draw(java.awt.Graphics2D g2) {
		Color old = g2.getColor();
		g2.setColor(Color.WHITE);
		g2.draw(new Rectangle((int) xLoc, (int) yLoc, 5, 5)); // ball character

		g2.setColor(Color.RED);
		g2.fill(new Rectangle((int) xAim, (int) yAim, 15, 15)); // aiming tool

		g2.setColor(old);
		g2.drawImage(clubImage.get(clubIndex), 10, 590, clubImage.get(clubIndex).getWidth(),
				clubImage.get(clubIndex).getHeight(), this);
//		g2.drawImage(, 0, 0, currentClub.getWidth(), currentClub.getHeight(), this);
//		if (spriteLoaded) {
//			g2.drawImage(image, x, y, rad, rad, this);
//		} else {
//			g2.setColor(Color.CYAN);
//			g2.fillOval(x, y, rad, rad);
//		}
	}

	public Ball getBall() {
		return this.ball;
	}

	public int getStrokes() {
		return this.strokes;
	}

	public void nextHole(double startX, double startY, int clubReset, int aimReset) {
		xLoc = startX;
		yLoc = startY;
		strokes = 0;
		this.clubIndex = 3;
		this.switchClub();
		this.angle = aimReset;
		this.moveAim(aimReset);
		this.repaint();
	}

	public void setStatus(String string) {
		if (string.equals("none"))
			this.sand = false;
		else if (string.equals("sand"))
			this.sand = true;
		else
			System.out.println("What? how?");
	}

	public void reset() {
		xLoc = lastx;
		yLoc = lasty;
	}

	public void update() {
		if (currentClub.getName().equals("wedge"))
			debuff = 1;
		else if (sand)
			debuff = 0.5;
		else
			debuff = 1;
		this.moveAim(0);
	}

}
