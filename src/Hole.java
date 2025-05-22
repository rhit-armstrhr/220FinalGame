import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Frank LaMantia Used only 220 materials
 */

public class Hole extends JPanel {

	private int holeNum;
	private int par;
	private BufferedImage image;
	private double startX, startY;
	private BufferedImage HoleCard;
	private ArrayList<BufferedImage> bigNums;
	private ArrayList<BufferedImage> windDirection;
	private int direction = 0;
	private Random rand = new Random();
	private double l, r, b, t;
	private Path2D.Double st1;
	private ArrayList<Path2D.Double> sandTraps;
	private ArrayList<Path2D.Double> waterTraps;
	private Double st2;
	private Double wt1;

	public Hole(String file, int holeNum, int par, double startX, double startY) {
		this.holeNum = holeNum;
		this.par = par;
		this.startX = startX;
		this.startY = startY;

		System.out.println("Hole 1");
		bigNums = Animations.bigNums();

		windDirection = Animations.windDirections();

		try {
			image = ImageIO.read(new File(file));
			HoleCard = ImageIO.read(new File("src/Images/HoleCard.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to Load Image for hole" + holeNum);
		}
		System.out.println(holeNum + "");

		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

		System.out.println(image.getWidth());
		sandTraps = new ArrayList<>();
		waterTraps = new ArrayList<>();
		initHazards();
	}

	// return what to draw and have a central drawing area
	public void draw(Graphics2D g2) {
		g2.drawImage(windDirection.get(direction), 10, 100, windDirection.get(direction).getWidth(),
				windDirection.get(direction).getHeight(), this);
		g2.setColor(Color.pink);
		g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
		sandTraps.forEach(g2::fill);
		waterTraps.forEach(g2::fill);
		g2.drawImage(HoleCard, 10, 10, HoleCard.getWidth(), HoleCard.getHeight(), this);
		g2.drawImage(bigNums.get(holeNum), 50, 60, bigNums.get(holeNum).getWidth(), bigNums.get(holeNum).getHeight(),
				this);
		g2.drawImage(bigNums.get(par), 120, 60, bigNums.get(par).getWidth(), bigNums.get(par).getHeight(), this);
		g2.drawRect((int) l, (int) t, (int) (r - l), (int) (b - t));
		repaint();

	}

	public void update() {

	}

	public void initHazards() {
		// Hole 1
		if (holeNum == 1) {
			st1 = new Path2D.Double();
			st1.moveTo(901, 306);
			st1.curveTo(917, 290, 935, 276, 975, 273);
			st1.lineTo(959, 200);
			st1.lineTo(931, 198);
			st1.curveTo(902, 229, 882, 267, 880, 305);
			st1.closePath();

			st2 = new Path2D.Double();
			st2.moveTo(1051, 287);
			st2.curveTo(1092, 287, 1125, 254, 1158, 229);
			st2.lineTo(1175, 242);
			st2.lineTo(1083, 422);
			st2.lineTo(1032, 441);
			st2.curveTo(1049, 373, 1056, 336, 1050, 291);
			st2.closePath();

			wt1 = new Path2D.Double();
			wt1.moveTo(780, 303);
			wt1.lineTo(828, 417);
			wt1.curveTo(827, 451, 809, 465, 740, 445);
			wt1.lineTo(678, 330);
			wt1.lineTo(692, 288);
			wt1.curveTo(726, 264, 740, 233, 783, 267);
			wt1.closePath();
			sandTraps.add(st1);
			sandTraps.add(st2);
			waterTraps.add(wt1);

			this.l = 1040;
			this.r = 1058;
			this.b = 197;
			this.t = 180;
		}
		// Hole 2

		// Hole 3
	}

	public double getStartX() {
		return this.startX;
	}

	public double getStartY() {
		// TODO Auto-generated method stub
		return this.startY;
	}

	public void newWind() {
		direction = rand.nextInt(windDirection.size());
	}

	public double getL() {
		return this.l;
	}

	public double getR() {
		return this.r;
	}

	public double getB() {
		return this.b;
	}

	public double getT() {
		return this.t;
	}

	public void checkHazard(Ball ball, Player player) {
		double xPos = ball.getXPosition();
		double yPos = ball.getYPosition();
		for (Double p : waterTraps) {
			if (p.contains(xPos, yPos)) {
				if (!ball.checkIfMoving())
					ball.reset();
					player.reset();
				System.out.println("wet");
			} else
				player.setStatus("none");
		}

		for (Double p : sandTraps) {
			if (p.contains(xPos, yPos)) {
				if (!ball.checkIfMoving())
					player.setStatus("sand");
			} else
				player.setStatus("none");
		}
	}

}
