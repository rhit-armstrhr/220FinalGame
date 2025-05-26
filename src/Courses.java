import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * @author Frank LaMantia and Hayden Armstrong Used only 220 materials
 * Courses Class holds each of the holes that we make. Can be built up for more holes in the future. 
 */

public class Courses {
	private int currentHole = 0;
	private ArrayList<Hole> holes = new ArrayList<>();
	private boolean endCard;

	public Courses() {
		holes.add(new Hole("src/Images/Hole1.png", 1, 3, 316, 522));
		holes.add(new Hole("src/Images/Hole2.png", 2, 4, 152, 343));
	}

	public Hole getHole() {
		return holes.get(currentHole);
	}

	public void draw(Graphics2D g2) {
		holes.get(currentHole).draw(g2);
	}

	public void advanceHole() {
		
		if (currentHole == 1)
			endCard = true;
		currentHole = 1;
		
	}

	public boolean isEndCard() {
		if (endCard)
			return true;
		return false;
	}
}
