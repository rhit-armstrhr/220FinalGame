import javax.swing.JPanel;

/*
 * Authors Hayden Armstrong Used only the CSSE course materials
 * Clubs class that gets added to the player for each range and name. 
 */
public class Clubs extends JPanel {

	double range;
	private String title;
	private String image;

	public Clubs(double range, String name) {
		this.range = range;
		this.title = name;

	}

	public double getRange() {
		return range;
	}


	public String getName() {
		return title;
	}
}
