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

	public GamePanel(JFrame frame) {

		c = new Courses();
		double startY = c.getHole().getStartY();
		double startX = c.getHole().getStartX();
		b = new Ball(startX, startY);
		p = new Player(startX, startY, b);
		con = new Controller(frame, p);
		sb = new ScoreBoard();

	}

	public void update() {
		sb.strokesUpdate(p.getStrokes());
		sb.update();
		Hole hole = c.getHole();
		System.out.println(p.getBall().checkPin(hole.getL(), hole.getR(), hole.getB(), hole.getT()));
	}

	public void drawScreen() {
		this.repaint();
	}

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		c.draw(g2);
		sb.draw(g2);
		b.draw(g2);
		p.draw(g2);
	}

}
