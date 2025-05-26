import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MenuKeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;

public class Controller {

	private JFrame frame;
	private Player player;
	private PowerBar pb;

	public Controller(JFrame jFrame, Player p, PowerBar pb) {
		// TODO Auto-generated constructor stub
		this.frame = jFrame;
		this.player = p;
		this.pb = pb;
		addListeners();

	}

	private void addListeners() {

		double angleOfAiming = 0.1; // about 20 deg in radians

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
					if (pb.isHitting()) {
						player.swing(pb.getPower());
						System.out.println("Swing: " + player.getStrokes());
					} else
						pb.startSwing();

					break;
				case KeyEvent.VK_SHIFT:
					player.switchClub();
					System.out.println("Switch Clubs");
					break;
				case KeyEvent.VK_P:
					Point mousePosition = MouseInfo.getPointerInfo().getLocation();
					int x = (int) mousePosition.getX();
					int y = (int) mousePosition.getY();
					System.out.println((x - 134) + ", " + (y - 109));
				}
			};
		});
	}

	public void addFrame(JFrame frame) {
		// TODO Auto-generated method stub
		this.frame = frame;
	}

}
