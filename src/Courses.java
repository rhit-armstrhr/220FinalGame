import java.awt.Component;
import java.util.ArrayList;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class Courses {
	private int currentHole;
	private ArrayList<Hole> holes= new ArrayList<>();
	
	public Courses() {
		holes.add(new Hole("src/Images/Hole1.png", 1, 3));
	}

	public Hole getHole() {
		return holes.get(currentHole);
	}
}
