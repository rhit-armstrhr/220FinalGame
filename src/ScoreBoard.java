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
	private BufferedImage endCard;
	private ArrayList<BufferedImage> smallNums;

	private int strokes = 0;
	private int score = 0;
	private int firstDigit = 0;
	private boolean doubleDigits = false;

	private boolean doubleDigitsScore;

	private int score1stnum;

	private int firstDigitScore;

	private int score2ndNum;

	private int xscore, yscore;

	public ScoreBoard() {

		smallNums = Animations.smallNums();

		try {
			ScoreCard = ImageIO.read(new File("src/Images/ScoreCard.png"));
			endCard = ImageIO.read(new File("src/Images/EndCard.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in loading Scoreboard");
		}
	}

	public void strokesUpdate(int strokes) {
		if (strokes >= 10) {
			doubleDigits = true;
			doubleDigitsScore = true;
			int num = strokes;
			while (num >= 10)
				num = num / 10;
			firstDigit = num;
		}
		this.strokes = strokes % 10;
	}

	public void draw(java.awt.Graphics2D g2, boolean end) {
		int x = 235;
		int y = 65;
		if (!end) {
			xscore = x + 100;
			yscore = y;
	
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

		} else {
			
			xscore = 631;
			yscore = 397;
			g2.drawImage(endCard, 0, 0, this);
		}
		if (!doubleDigits) {
			g2.drawImage(smallNums.get(score), xscore, yscore, smallNums.get(score).getWidth(),
					smallNums.get(score).getHeight(), this);
		} else {
			g2.drawImage(smallNums.get(firstDigitScore), xscore - 10, yscore, smallNums.get(firstDigitScore).getWidth(),
					smallNums.get(firstDigitScore).getHeight(), this);
			g2.drawImage(smallNums.get(score2ndNum), xscore + 10, yscore, smallNums.get(score2ndNum).getWidth(),
					smallNums.get(score2ndNum).getHeight(), this);

		}
		repaint();
	}

	public void update() {

	}

	public void nextHole(int holeScore) {
		score += holeScore;
		if (holeScore >= 10) {
			doubleDigits = true;
			doubleDigitsScore = true;
			int num = holeScore;
			while (num >= 10)
				num = num / 10;
			firstDigitScore = num;
		}
		this.score2ndNum = score % 10;
	}
}
