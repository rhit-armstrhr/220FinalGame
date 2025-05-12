import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class Hole extends JPanel{

	private int holeNum;
	private int par;
	private BufferedImage image;
	
	
	
	public Hole(String file, int holeNum, int par) {
		this.holeNum = holeNum;
		this.par = par;
		
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to Load Image for hole" + holeNum);
		} 
		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
	}
	
	
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2 = (Graphics2D) g;
		
		
		g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
	}
}
