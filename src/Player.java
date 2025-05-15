import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Player extends JPanel {
	public int strokes;
	private double xLoc, yLoc;
	private double xAim, yAim, angle;
	private int clubIndex = 0;
	private Clubs currentClub;
	private double shotAngle = 90;
	private double range;
	public ArrayList<Clubs> clubList = new ArrayList<Clubs>();
	private Ball ball;

	public Player(double startX, double startY) {
		// TODO Auto-generated constructor stub
		strokes = 0;
		Clubs driver = new Clubs(450, "driver");
		Clubs iron = new Clubs(140, "iron");
		Clubs wedge = new Clubs(90, "wedge");
		Clubs putter = new Clubs(30, "putter");

		clubList.add(driver);
		clubList.add(iron);
		clubList.add(wedge);
		clubList.add(putter);
		currentClub = clubList.get(clubIndex);
		range = currentClub.getRange();
		double y = startY;
		double x = startX; // done needs to be changed to be an argument in the player class when we get
							// the chance
		xLoc = x;
		yLoc = y;
		xAim = range + xLoc;
		yAim = yLoc;
		angle = 0;

		ball = new Ball(xLoc, yLoc);
	}

	public void moveAim(double dAngle) {
		angle += dAngle;
		yAim = range * Math.sin(angle);
		xAim = range * Math.cos(angle);
		repaint();
	}

	public void swing(double power) {
		xLoc += power * Math.cos(angle);
		yLoc += power * Math.sin(angle);
		strokes += 1;
		repaint();
		System.out.println(xLoc+",  "+yLoc);
		ball.getHit(xLoc, yLoc);
	}  

	public int getStrokes() {
		return this.strokes;
	}

	public void switchClub() {
		clubIndex += 1;
		if (clubIndex > 3)
			clubIndex = 0;
		currentClub = clubList.get(clubIndex);
		range = currentClub.getRange();
		repaint();
	}

	protected void draw(java.awt.Graphics2D g2) {
		Color old = g2.getColor();
		g2.setColor(Color.WHITE);
		g2.draw(new Rectangle((int) xLoc, (int) yLoc, 40, 50)); // ball character
		g2.setColor(Color.RED);
		g2.fill(new Rectangle((int) xAim, (int) yAim, 15, 15)); // aiming tool

		g2.setColor(old);
		repaint();

//		g2.drawImage(, 0, 0, currentClub.getWidth(), currentClub.getHeight(), this);
//		if (spriteLoaded) {
//			g2.drawImage(image, x, y, rad, rad, this);
//		} else {
//			g2.setColor(Color.CYAN);
//			g2.fillOval(x, y, rad, rad);
//		}
	}
	

}
