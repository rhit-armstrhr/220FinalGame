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
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to Load Image");
		} 
	}
}
