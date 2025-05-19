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

	private ArrayList<BufferedImage> smallNums;

	private int strokes = 0;
	private int score = 0;
	private int firstDigit = 0;
	private boolean doubleDigits = false;

	public ScoreBoard() {

		smallNums = Animations.smallNums();

		try {
			ScoreCard = ImageIO.read(new File("src/Images/ScoreCard.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in loading Scoreboard");
		}
	}

	public void strokesUpdate(int strokes) {
		if (strokes >= 10) {
			doubleDigits = true;
			int num = strokes;
			while (num >= 10)
				num = num / 10;
			firstDigit = num;
		}
		this.strokes = strokes % 10;
	}

	public void draw(java.awt.Graphics2D g2) {
		int x = 235;
		int y = 65;
		g2.drawImage(ScoreCard, 185, 21, ScoreCard.getWidth(), ScoreCard.getHeight(), this);

		if (!doubleDigits) {
			g2.drawImage(smallNums.get(strokes), x, y, smallNums.get(strokes).getWidth(),
					smallNums.get(strokes).getHeight(), this);
		} else {
			g2.drawImage(smallNums.get(firstDigit), x - 10, y, smallNums.get(firstDigit).getWidth(),
					smallNums.get(firstDigit).getHeight(), this);
			g2.drawImage(smallNums.get(strokes), x + 10, y, smallNums.get(strokes).getWidth(),
					smallNums.get(strokes).getHeight(), this);

		}

		repaint();
	}

	public void update() {

	}

	public void nextHole(int holeScore) {
		// TODO Auto-generated method stub
		score += holeScore;
	}
}
