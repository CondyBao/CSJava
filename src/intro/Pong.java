// filler code for pong provided by Mr. David

package intro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 15, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 4, max_speed = 4;
	private int paddle1_y = 0, paddle2_y = 0;
	private int pong_x, pong_y;
	private int pong_x_velocity = 3, pong_y_velocity;
	private int p1_score, p2_score;
	private int turn = -1;
	private int pong_state = 0, paddle1_state = 0, paddle2_state = 0;

	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false; //boolean to keep track of playing mode
	
	// this method moves the ball at each timestep
	public void move_ball() {
		pong_x += Math.min(max_speed, pong_x_velocity) * turn; //turn determines the way that the ball goes
		if (pong_y_velocity > 0){
			pong_y += Math.min(max_speed, Math.abs(pong_y_velocity)); //a precaution to avoid ball going to fast
		}
		else if (pong_y_velocity < 0){
			pong_y -= Math.min(max_speed, Math.abs(pong_y_velocity)); //a precaution to avoid ball going to fast
		}
		// your code here //
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		
		// your code here //
		if (up1 && paddle1_y >= 4) paddle1_y -= PADDLE_SPEED; //
		if (up2 && paddle2_y >= 4 && !solo) paddle2_y -= PADDLE_SPEED;
		if (down1 && paddle1_y <= 500) paddle1_y += PADDLE_SPEED;
		if (down2 && paddle2_y <= 500 && !solo) paddle2_y += PADDLE_SPEED;
		if (solo) {
			if (pong_y > paddle2_y) {
				if (pong_state % 6 != 5) {
					if (pong_y <=  HEIGHT - PADDLE_HEIGHT) {
						paddle2_y += PADDLE_SPEED;
					}
				}
				else {
					if (pong_y <= (paddle2_y + PADDLE_HEIGHT)) {
						paddle2_y -= PADDLE_SPEED;
					}
				}
			}
			else if (pong_y < paddle2_y) {
				if (pong_state % 6 != 5) {
					if (pong_y >= 0) {
						paddle2_y -= PADDLE_SPEED;
					}
				}
				else {
					if (pong_y >= paddle2_y && pong_y <= (paddle2_y + PADDLE_HEIGHT)) {
						paddle2_y += PADDLE_SPEED;
					}
				}
			}
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		// your code here
		if (pong_y <= 0) {
			pong_y_velocity = Math.abs(pong_y_velocity);
		}
		if (pong_y >= HEIGHT) {
			pong_y_velocity = -Math.abs(pong_y_velocity);
		}
		if (pong_x <= PADDLE_WIDTH && pong_y >= paddle1_y && pong_y <= (paddle1_y + PADDLE_HEIGHT)) {
			if (pong_state % 6 == 5) {
				paddle1_state = 1;
				p2_score++;
				repaint();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {}
				run();
			}
			turn *= -1;
			pong_y_velocity += (pong_y - (paddle1_y + PADDLE_HEIGHT / 2)) / 5 * 5 * 0.3;
			pong_x_velocity += Math.abs((pong_y - (paddle1_y + PADDLE_HEIGHT / 2))) / 5 * 5 * 0.3;
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
			pong_state ++;
		}
		if (pong_x >= (WIDTH - PADDLE_WIDTH - DIAM) && pong_y >= paddle2_y && pong_y <= (paddle2_y + PADDLE_HEIGHT)) {
			if (pong_state % 6 == 5) {
				paddle2_state = 1;
				p1_score++;
				repaint();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {}
				run();
			}
			turn *= -1;
			pong_y_velocity += (pong_y - (paddle2_y + PADDLE_HEIGHT / 2) / 5 * 5) * 0.3;
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
			pong_state++;
		}

		if (pong_x <= 0) {
			if (pong_state % 6 != 5) {
				p2_score ++;
				turn = 1;
				run();
			}
			turn *= -1;
			pong_state++;
		}

		if (pong_x >= (WIDTH - DIAM)) {
			if (pong_state % 6 != 5) {
				p1_score ++;
				turn = -1;
				run();
			}
			turn *= -1;
			pong_state++;
		}
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		// .......
		g.setColor(Color.orange);
		if (paddle1_state == 1) {
			g.setColor(Color.red);
		}
		g.fillRect(0, paddle1_y, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.setColor(Color.orange);
		if (paddle2_state == 1) {
			g.setColor(Color.red);
		}
		g.fillRect(WIDTH - PADDLE_WIDTH, paddle2_y, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.setColor(Color.pink);
		if (pong_state % 6 == 5) {
			g.setColor(Color.red);
		}
		g.fillOval(pong_x, pong_y, DIAM, DIAM);
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Times", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		String str1 = "P1 Score: " + p1_score, str2 = "P2 Score: " + p2_score;
		g.drawString(str1, WIDTH/5, 20);
		g.drawString(str2, WIDTH*3/5, 20);
	}

	// defines what we want to happen if a keyboard button has
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) 
			// fill this in
			down2 = true;
		
		if (keyCode == KeyEvent.VK_UP) 
			// fill this in
			up2 = true;

		if (e.getKeyChar() == 'w')
			// move paddle down
			up1 = true;
		
		if (e.getKeyChar() =='s')
			down1 = true;
			// fill this in
			
		// turn 1-player mode on
		if (e.getKeyChar() == '1')
			// fill this in
			solo = false;
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2')
			// fill this in
			solo = true;
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) 
			// fill this in
			up2 = false;

		if (keyCode == KeyEvent.VK_DOWN) 
			// fill this in
			down2 = false;
  
		if(e.getKeyChar() == 'w') up1 = false;
			// fill this in
		
		if (e.getKeyChar() == 's') down1 = false;
			// fill this in
	}
	
	// restarts the game, including scores
	public void restart() {
		p1_score = 0;
		p2_score = 0;
		paddle1_y = 0;
		paddle2_y = 0;
		paddle1_state = 0;
		paddle2_state = 0;
		pong_x = (WIDTH - DIAM) / 2;
		pong_y = (HEIGHT - DIAM) / 2;
		pong_x_velocity = 3;
		pong_y_velocity = 0;
		pong_state = 0;
		repaint();
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {}
		// your code here
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {
		paddle1_y = 0;
		paddle2_y = 0;
		paddle1_state = 0;
		paddle2_state = 0;
		pong_x = (WIDTH - DIAM) / 2;
		pong_y = (HEIGHT - DIAM) / 2;
		pong_x_velocity = 3;
		pong_y_velocity = 0;
		pong_state = 0;
		repaint();
		try {
			Thread.sleep(100);
		} catch (Exception ex) {}

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}