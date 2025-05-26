import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Frank LaMantia Used only 220 materials
 */
// help me
public class GamePanel extends JComponent {

	private Player p;
	private Ball b;
	private ScoreBoard sb;
	private Courses c;
	private Controller con;
	private PowerBar pb;

	public GamePanel(JFrame frame) {

		c = new Courses();
		double startY = c.getHole().getStartY();
		double startX = c.getHole().getStartX();
		b = new Ball(startX, startY);
		p = new Player(startX, startY, b);
		pb = new PowerBar();
		con = new Controller(frame, p, pb);
		sb = new ScoreBoard();

	}

	public void update() {
		sb.strokesUpdate(p.getStrokes());
		sb.update();
		pb.update();
		p.update();
		Hole hole = c.getHole(); // the hole logic for making the next hole.
		if (hole.checkInHole(b)) {
			b.setMoving(false);
			this.nextHole();
		}
		hole.checkHazard(b, p);
		b.update();
	}

	private void nextHole() {
		sb.nextHole(p.getStrokes());
		c.advanceHole();
		double startY = c.getHole().getStartY();
		double startX = c.getHole().getStartX();
		
		b.nextHole(startX, startY);
		p.nextHole(startX, startY, 0, 0);

	}

	public void drawScreen() {
		this.repaint();
	}

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (!c.isEndCard()) {
			c.draw(g2);
			sb.draw(g2, false);
			b.draw(g2);
			p.draw(g2);
			pb.draw(g2);
		} else
			sb.draw(g2, true);

	}

}
