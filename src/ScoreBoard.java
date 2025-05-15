import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class ScoreBoard extends JPanel {

	private BufferedImage ScoreCard;
	private BufferedImage HoleCard;
	private ArrayList<BufferedImage> windDirection;
	private ArrayList<BufferedImage> club;
	private int currentClub = 0;
	private int direction = 0;
	
	public ScoreBoard() {
		windDirection = Animations.windDirections();
		club = Animations.clubs();
		try {
			ScoreCard = ImageIO.read(new File("src/Images/ScoreBoard.png"));
			HoleCard = ImageIO.read(new File("src/Images/HoleCounter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in loading Scoreboard");
		}
	}
	
	public void draw(java.awt.Graphics2D g2) {
		g2.drawImage(HoleCard, 10, 10, HoleCard.getWidth(), HoleCard.getHeight(), this);
		g2.drawImage(ScoreCard, 115, 11, ScoreCard.getWidth(), ScoreCard.getHeight(), this);
		g2.drawImage(club.get(currentClub), 10, 590, club.get(currentClub).getWidth(), club.get(currentClub).getHeight(), this);
		g2.drawImage(windDirection.get(direction), 10, 100, windDirection.get(direction).getWidth(), windDirection.get(direction).getHeight(), this);
		} 
}
