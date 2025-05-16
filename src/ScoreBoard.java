import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Frank LaMantia Used only 220 materials
 */

public class ScoreBoard extends JPanel {

	private BufferedImage ScoreCard;
	private BufferedImage HoleCard;
	private ArrayList<BufferedImage> windDirection;
	private ArrayList<BufferedImage> smallNums;
	private ArrayList<BufferedImage> bigNums;

	private int direction = 0;
	private Random r = new Random();
	
	private int strokes = 0;
	private boolean doubleDigits = false;
	
	public ScoreBoard() {
		windDirection = Animations.windDirections();
		smallNums = Animations.smallNums();
		bigNums = Animations.bigNums();
		
		
		try {
			ScoreCard = ImageIO.read(new File("src/Images/ScoreBoard.png"));
			HoleCard = ImageIO.read(new File("src/Images/HoleCounter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in loading Scoreboard");
		}
	}

	public void newWind() {
		direction = r.nextInt(windDirection.size());
	}
	
	public void strokesUpdate(int strokes) {
		if (strokes > 9) {
		doubleDigits = true;
		}
		this.strokes = strokes;
	}
	

	public void draw(java.awt.Graphics2D g2) {
		g2.drawImage(HoleCard, 10, 10, HoleCard.getWidth(), HoleCard.getHeight(), this);
		g2.drawImage(ScoreCard, 115, 11, ScoreCard.getWidth(), ScoreCard.getHeight(), this);
		
		g2.drawImage(windDirection.get(direction), 10, 100, windDirection.get(direction).getWidth(),
				windDirection.get(direction).getHeight(), this);
		if (!doubleDigits) {
			g2.drawImage(smallNums.get(strokes), 145, 55, smallNums.get(strokes).getWidth(),
					smallNums.get(strokes).getHeight(), this);
			}

		repaint();
	}

	public void update() {
		
	}
}
