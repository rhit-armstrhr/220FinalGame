import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.Shape;

public class Clubs extends JPanel{

	double range;
	private String title;
	private String image;

	public Clubs(double range, String name) {
		this.range = range;
		this.title = name;
//		if(name = "driver") {
//			this.image = 
//		}

	}

	public void swing() {

	}

	public double getRange() {
		return range;
	}

	public Shape getImage(int x, int y) {
		//return image;
		return new Rectangle(x, y, 40, 10); 
	}

}
