
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

	public void createGUI() {
		frame = new JFrame("Viewer");
		JPanel panel = new JPanel();
		Courses c = new Courses();
		panel.add(c.getHole());
		
		frame.add(panel);
		frame.setSize(600, 400);
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}
}