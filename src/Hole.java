import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.geom.Path2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Polygon;
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
	private Path2D.Double st1;
	private ArrayList<Path2D.Double> sandTraps;
	private ArrayList<Path2D.Double> waterTraps;
	private Double st2;
	private Double wt1;
	private Polygon pin;

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
//		sandTraps.forEach(g2::fill);
//		waterTraps.forEach(g2::fill);
		g2.drawImage(HoleCard, 10, 10, HoleCard.getWidth(), HoleCard.getHeight(), this);
		g2.drawImage(bigNums.get(holeNum), 50, 60, bigNums.get(holeNum).getWidth(), bigNums.get(holeNum).getHeight(),
				this);
		g2.drawImage(bigNums.get(par), 120, 60, bigNums.get(par).getWidth(), bigNums.get(par).getHeight(), this);
//		g2.fill(pin);
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

			int[] xCords = { 1040, 1057, 1057, 1040 };
			int[] yCords = { 180, 180, 197, 197 };
			pin = new Polygon(xCords, yCords, 4);

		}
		// Hole 2
		if (holeNum == 2) {
			st1 = new Path2D.Double();
			st1.moveTo(662, 69);
			st1.curveTo(732, 72, 805, 113, 848, 167);
			st1.curveTo(829, 192, 796, 207, 754, 208);
			st1.curveTo(725, 213, 710, 195, 717, 161);
			st1.lineTo(661, 97);
			st1.closePath();
			
			st2 = new Path2D.Double();
			st2.moveTo(1094, 429);
			st2.lineTo(1167, 382);
			st2.lineTo(1204, 417);
			st2.lineTo(1178, 478);
			st2.closePath();
			
			wt1 = new Path2D.Double();
			wt1.moveTo(586, 395);
			wt1.curveTo(596, 333, 653, 250, 769, 237);
			wt1.lineTo(856, 234);
			wt1.lineTo(932, 305);
			wt1.lineTo(936, 461);
			wt1.curveTo(926, 489, 907, 543, 848, 581);
			wt1.lineTo(753, 552);
			wt1.lineTo(652, 493);
			wt1.lineTo(598, 438);
			wt1.lineTo(584, 402);
			wt1.closePath();
			
			
			sandTraps.add(st1);
			sandTraps.add(st2);
			waterTraps.add(wt1);

			int[] xCords = { 1142, 1160, 1160, 1142 };
			int[] yCords = { 613, 613, 630, 630 };
			pin = new Polygon(xCords, yCords, 4);

		}
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


	public Boolean checkInHole(Ball ball) {
		double xPos = ball.getXPosition();
		double yPos = ball.getYPosition();
		if (!ball.checkIfMoving()) {
			if (pin.contains(xPos, yPos)) {
				System.out.println("Hole");
				return true;
			}

		}
		return false;
	}

	public void checkHazard(Ball ball, Player player) {
		double xPos = ball.getXPosition();
		double yPos = ball.getYPosition();
		if (!ball.checkIfMoving()) {
			for (Double p : waterTraps) {
				if (p.contains(xPos, yPos)) {

					ball.reset();
					player.reset();

					System.out.println("wet");
				} else
					player.setStatus("none");
			}

			for (Double p : sandTraps) {
				if (p.contains(xPos, yPos)) {

					player.setStatus("sand");
				} else
					player.setStatus("none");
			}

		}

	}
}
