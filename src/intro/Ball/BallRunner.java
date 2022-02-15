package intro.Ball;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallRunner extends JPanel implements Runnable {
	
	ArrayList<Ball> ball_list;
	
	public void run() {

		while (true) {
			
			for (Ball b : ball_list)
				b.move();
				
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (Exception ex) {}

		}
	}
	
	public void setup() {
		ball_list = new ArrayList<Ball>();
		ball_list.add(new Ball(100, 300, 30, 3, 5, Color.BLUE));
		ball_list.add(new BouncingBall(300, 100, 30, -6, -4, Color.BLUE));
		ball_list.add(new ColorBall(400, 200, 40, 6, -2));
		ball_list.add(new SineBall(50, 300, 30, 3, 5, Color.CYAN));
		ball_list.add(new CirclePathBall(400, 400, 30, -5, 4, Color.ORANGE));
		ball_list.add(new CollisionBall(200, 500, 30, 4, 3, ball_list, Color.RED));
		ball_list.add(new ShrinkingBall(300, 300, 30, -3, 5, Color.BLACK));
	}
	
	public void paint(Graphics g) throws ConcurrentModificationException{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		
		
		for (Ball b: ball_list)
			b.draw(g);
	}
	
	public static void main(String[] args) {
		BallRunner game = new BallRunner(); 
		game.start_game();
	}
 
	public void start_game() {
		JFrame frame = new JFrame();
		frame.setSize(600, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		setup();
		
		Thread t = new Thread(this);
		t.start();
	}
}