import java.awt.Component;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * @author Frank LaMantia Used only 220 materials
 */

public class Courses {
	private int currentHole = 0;
	private ArrayList<Hole> holes = new ArrayList<>();

	public Courses() {
		holes.add(new Hole("src/Images/Hole1.png", 1, 3, 300, 500,600,608,203,190));
		System.out.println("Courses Image");
	}

	public Hole getHole() {
		return holes.get(currentHole);

	}

	public void draw(Graphics2D g2) {
		holes.get(currentHole).draw(g2);
	}

	public void advanceHole() {
		currentHole++;
	}
}
