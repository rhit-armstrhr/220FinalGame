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
	
	private ArrayList<BufferedImage> windDirection;
	private ArrayList<BufferedImage> smallNums;
	

	private int direction = 0;
	private Random r = new Random();
	
	private int strokes = 0;
	private int firstDigit = 0;
	private boolean doubleDigits = false;
	
	
	public ScoreBoard() {
		windDirection = Animations.windDirections();
		smallNums = Animations.smallNums();
		
		
		
		try {
			ScoreCard = ImageIO.read(new File("src/Images/ScoreBoard.png"));
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
		if (strokes >= 10) {
		doubleDigits = true;
		int num = strokes;
		while (num >= 10) num = num / 10;
		firstDigit = num;
		}
		this.strokes = strokes % 10;
	}
	

	public void draw(java.awt.Graphics2D g2) {
		
		g2.drawImage(ScoreCard, 115, 11, ScoreCard.getWidth(), ScoreCard.getHeight(), this);
		
		
		g2.drawImage(windDirection.get(direction), 10, 100, windDirection.get(direction).getWidth(),
				windDirection.get(direction).getHeight(), this);
		
		
		if (!doubleDigits) {
			g2.drawImage(smallNums.get(strokes), 225, 55, smallNums.get(strokes).getWidth(),
					smallNums.get(strokes).getHeight(), this);
			}
		else {
			g2.drawImage(smallNums.get(firstDigit), 215, 55, smallNums.get(firstDigit).getWidth(),
					smallNums.get(firstDigit).getHeight(), this);
			g2.drawImage(smallNums.get(strokes), 235, 55, smallNums.get(strokes).getWidth(),
					smallNums.get(strokes).getHeight(), this);
			
		}

		repaint();
	}

	public void update() {
		
	}
}
