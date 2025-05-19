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
		Timer animation = new Timer(20, e -> getAndHandleEvents());
		animation.start();
		addListeners();

	}

	private void addListeners() {
		// TODO Auto-generated method stub
		float angleOfAiming = 2 * (float)(Math.PI/180);
		System.out.println(angleOfAiming + " is ");
		frame.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					// canvas.moveDelta(10);
					player.moveAim(angleOfAiming);
					System.out.println("right");
					break;
				case KeyEvent.VK_LEFT:
//					canvas.moveDelta(-10);
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

	private void getAndHandleEvents() {
		// TODO Auto-generated method stub
//System.out.println("run");
	}

	public void addFrame(JFrame frame) {
		// TODO Auto-generated method stub
		this.frame = frame;
	}

}
