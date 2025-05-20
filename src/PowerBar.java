import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Frank LaMantia Used only 220 materials
 */

public class PowerBar extends JPanel {

	private final int BARX = 150, Y = 650;
	private int sliderX;
	private BufferedImage bar;
	private BufferedImage slider;
	private final int MAXX;
	private final int SPEED = 3;
	private int dx;

	private int diffPower = 32;
	private int totalPower;
	private double[] powerValues = { 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2 };
	private boolean hitting = false;

	public PowerBar() {
		try {
			bar = ImageIO.read(new File("src/Images/PowerBar/PowerBar.png"));
			slider = ImageIO.read(new File("src/Images/PowerBar/PowerPicker.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Power Bar not loading");
		}

		sliderX = BARX;
		MAXX = BARX + bar.getWidth() - slider.getWidth();
	}

	protected void draw(java.awt.Graphics2D g2) {
		if (hitting) {
			g2.drawImage(bar, BARX, Y, this);
			g2.drawImage(slider, sliderX, Y, this);
		}
	}

	public void update() {
		if (hitting) {
			if (sliderX <= BARX)
				dx = SPEED;
			else if (sliderX >= MAXX)
				dx = -1 * SPEED;

			sliderX += dx;
			totalPower = sliderX - BARX;
		}
	}

	public void startSwing() {
		hitting = true;
		sliderX = 0;
	}
	
	public double getPower() {
		int ind = totalPower / diffPower;
		hitting = false;
		return powerValues[ind];
		
	}
}
