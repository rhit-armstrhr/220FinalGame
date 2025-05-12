import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class Animations {

	public static ArrayList<BufferedImage> ballArc() {
		ArrayList<BufferedImage> ball = new ArrayList<>();
		
		try {
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0000.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0001.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0002.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0003.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0004.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0005.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0006.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0007.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0008.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_0009.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Lay_00010.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Golfball Animation Failed to Load");
		}
		
		return ball;
		
	}
}
