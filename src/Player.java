import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Player extends JPanel {
	public int strokes;
	private int xLoc, yLoc;

	private int clubIndex = 0;
	private Clubs currentClub;
	private double shotAngle = 90;
	private double range;
	public ArrayList<Clubs> clubList = new ArrayList<Clubs>();

	public Player() {
		// TODO Auto-generated constructor stub
		strokes = 0;
		Clubs driver = new Clubs(80, "driver");
		Clubs iron = new Clubs(40, "iron");
		Clubs wedge = new Clubs(25, "wedge");
		Clubs putter = new Clubs(8, "putter");

		clubList.add(driver);
		clubList.add(iron);
		clubList.add(wedge);
		clubList.add(putter);
		currentClub = clubList.get(clubIndex);
		range = currentClub.getRange();
	}

	public void swing() {

	}

	public int getStrokes() {
		return this.strokes;
	}

	public void switchClub() {
		clubIndex += 1;
		if (clubIndex > 3)
			clubIndex = 0;
		currentClub = clubList.get(clubIndex);
	}
@Override	
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
		g2.draw(new Rectangle(xLoc,yLoc,40,50));
//		g2.drawImage(, 0, 0, currentClub.getWidth(), currentClub.getHeight(), this);

//		if (spriteLoaded) {
//			g2.drawImage(image, x, y, rad, rad, this);
//		} else {
//			g2.setColor(Color.CYAN);
//			g2.fillOval(x, y, rad, rad);
//		}
	}

}
