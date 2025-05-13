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
	private ArrayList<BufferedImage> WindDirection;
	
	public ScoreBoard() {
		try {
			ScoreCard = ImageIO.read(new File("src/Images/ScoreBoard.png"));
			HoleCard = ImageIO.read(new File("src/Images/HoleCounter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in loading Scoreboard");
		}
	}
	
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2 = (Graphics2D) g;
		
		
		g2.drawImage(HoleCard, 10, 10, HoleCard.getWidth(), HoleCard.getHeight(), this);
		g2.drawImage(ScoreCard, 100, 10, ScoreCard.getWidth(), ScoreCard.getHeight(), this);
		} 
}
