import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Controller {

	private JFrame frame;
	private Player player;

	public Controller(JFrame jFrame, Player p) {
		// TODO Auto-generated constructor stub
		this.frame = jFrame;
		this.player = p;
		addListeners();

	}

	private void addListeners() {

		double angleOfAiming = 0.15; // about 20 deg in radians

		frame.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					player.moveAim(angleOfAiming);
					System.out.println("right");
					break;
				case KeyEvent.VK_LEFT:
					player.moveAim(-1 * angleOfAiming);
					System.out.println("left");
					break;
				case KeyEvent.VK_SPACE:
					double power = 1;
					player.swing(power);
					System.out.println("Swing: " + player.getStrokes());
					break;
				case KeyEvent.VK_SHIFT:
					player.switchClub();
					System.out.println("Switch Clubs");
					break;
				}
			};
		});
	}

	public void addFrame(JFrame frame) {
		// TODO Auto-generated method stub
		this.frame = frame;
	}

}
