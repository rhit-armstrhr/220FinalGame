
/**
 * @author Frank LaMantia
* Used only 220 materials
*/

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Viewer {

	static JFrame frame;
	private GamePanel gp;
	
	public void createGUI() {
		frame = new JFrame("Viewer");
		gp = new GamePanel(frame);
		frame.setSize(1280, 755);
		frame.setLocationRelativeTo(null);
		frame.add(gp);

//		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void update() {
		gp.update();
	}
	public void drawScreen() {
		gp.drawScreen();
	}
}