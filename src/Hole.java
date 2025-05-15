import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class Hole extends JPanel {

	private int holeNum;
	private int par;
	private BufferedImage image;
	private double startX,startY;
	
	
	
	public Hole(String file, int holeNum, int par, double startX, double startY) {
		this.holeNum = holeNum;
		this.par = par;
		this.startX=startX;
		this.startY=startY;
		System.out.println("Hole 1");
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to Load Image for hole" + holeNum);
		} 
		System.out.println("Hole 2");
		
		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		
		System.out.println(image.getWidth());
	}
	
	
	
	// return what to draw and have a central drawing area
	public void draw(Graphics2D g2) {
		
		g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
		
		repaint();
	}

	public double getStartX() {
		return this.startX;
	}
	public double getStartY() {
		// TODO Auto-generated method stub
		return this.startY;
	}
}
