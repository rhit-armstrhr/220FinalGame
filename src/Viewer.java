
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

	public static void createGUI() {
		frame = new JFrame("Viewer");
		GamePanel gp = new GamePanel(frame);
		frame.setSize(1280, 755);
		frame.setLocationRelativeTo(null);

		frame.add(gp);

//		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}