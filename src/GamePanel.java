import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
* @author Frank LaMantia
* Used only 220 materials
*/
// help me
public class GamePanel extends JComponent {

	private Player p;
	private Ball b;
	private ScoreBoard sb;
	private Courses c;
	
	
	public GamePanel() {
		c = new Courses();
		double startY = c.getHole().getStartY();
		double startX= c.getHole().getStartX();
		p = new Player(startX,startY);
		sb = new ScoreBoard();
		
		
	}
	
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		c.draw(g2);
		p.draw(g2);
		
		
	}
}
