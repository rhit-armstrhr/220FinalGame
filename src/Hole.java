import java.awt.Dimension;
import java.awt.Graphics2D;
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
	private Random r = new Random();

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
	}

	// return what to draw and have a central drawing area
	public void draw(Graphics2D g2) {
		g2.drawImage(windDirection.get(direction), 10, 100, windDirection.get(direction).getWidth(),
				windDirection.get(direction).getHeight(), this);

		g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
		g2.drawImage(HoleCard, 10, 10, HoleCard.getWidth(), HoleCard.getHeight(), this);
		g2.drawImage(bigNums.get(holeNum), 50, 60, bigNums.get(holeNum).getWidth(), bigNums.get(holeNum).getHeight(),
				this);
		g2.drawImage(bigNums.get(par), 120, 60, bigNums.get(par).getWidth(), bigNums.get(par).getHeight(), this);
		repaint();
	}

	public double getStartX() {
		return this.startX;
	}

	public double getStartY() {
		// TODO Auto-generated method stub
		return this.startY;
	}

	public void newWind() {
		direction = r.nextInt(windDirection.size());
	}
}
