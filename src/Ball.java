import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class Ball extends JPanel{

	private int x, y;
	private int height;
	private ArrayList<BufferedImage> ballFrames = Animations.ballArc();
	
	
	public Ball(int startX, int startY) {
		x = startX;
		y = startY;
		height = 0;
		
	}
	
	public void getBlown() {
		
	}
	
	public void getHit() {
		
	}
	
}
