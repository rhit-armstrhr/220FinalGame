
/**
 * @author Frank LaMantia and Hayden Armstrong
* Used only 220 materials
* Is the viewer that 
*/

import javax.swing.JFrame;

public class Viewer {

	static JFrame frame;
	private GamePanel gp;

	public void createGUI() {
		frame = new JFrame("Viewer");
		gp = new GamePanel(frame);
		frame.setSize(1280, 755);
		frame.setLocationRelativeTo(null);
		frame.add(gp);

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