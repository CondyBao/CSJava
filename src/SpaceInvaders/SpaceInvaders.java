package SpaceInvaders;

// Space Invaders Filler Code by Mr. David

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvaders {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35, PLAYERHEIGHT = 55, PLAYERWIDTH = 70, ROWS = 2, SHIELD_DURABILITY = 1, IMG_DI = 60;

	private final int IMG_HEIGHT = WIDTH / 5;

	private int special_attack;

	// determines the difficulty. The closer to 1.0, the easier the game 
	private final double DIFFICULTY = .99;

	private boolean shielded = false;
	private int shield_used = 0;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<AlienLaser> alienLasers = new ArrayList<AlienLaser>();
	private ArrayList<PlayerLaser> playerLasers = new ArrayList<PlayerLaser>();
	
	// the player
	private SpaceThing player;
	private final Image pausedIMG = ImageIO.read(new File("src/SpaceInvaders/Images/paused.png")).getScaledInstance(WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);
	
	// the current speed of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0, alienHitBoundary = 0, playerYSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost, paused, won;
	private SpaceThing SP;
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens

	public void SPAttack() { // use skill
		if (special_attack < 1 || paused) return; // if the game is paused or there is no attack left then return
		for (int i = 0; i < aliens.size(); i++) { // loop through aliens
			Random random = new Random();
			if (random.nextInt(3) > 1) { // remove aliens by random (1 in a 3 chance)
				aliens.remove(i);
				i--; // maintain the array
			}
		}
		special_attack--; // use 1 special attack
	}
	public void move() {
		if (won || lost) return; // stop all movemeets if game stopping condition is reached
		if (aliens.isEmpty()) { // win if there are no more enemies
			won = true;
			return;
		}
		if (lives < 1) { // lose if there are no more lives
			lost = true;
			return;
		}
		for (SpaceThing i : aliens) { // loop through aliens
			i.moveX(ALIENSPEED); // move horizontally according to the alien speed
			if (i.getX() >= WIDTH) { // if it reaches the right boundary
				i.moveY((int)(PLAYERENEMYHEIGHT * 1.5)); // move to the next row
				i.moveX(-WIDTH); // move to the other end
			}
			if (i.getY() >= (HEIGHT - PLAYERENEMYHEIGHT * 1.5)) { // if it reaches the low boundary
				lost = true; // player loses
				return;
			}
		}
		for (SpaceThing i : aliens) { // loop through aliens to randomly shoot lasers
			Random rand = new Random(); // declare random
			if (rand.nextDouble(1) > DIFFICULTY) { // the random condition based on difficulty
				alienLasers.add(new AlienLaser((int) i.getX(),(int) i.getY())); // add a new laser
			}
		}
		if (!(player.getX() >= (WIDTH - PLAYERWIDTH) && playerSpeed > 0) && !(player.getX() <= 0 && playerSpeed < 0)) { // if player is not at right/left boundary
			player.moveX(playerSpeed); // move horizontally according to speed
		}
		if (!(player.getY() >= (HEIGHT - PLAYERHEIGHT * 1.5) && playerYSpeed > 0) && !(player.getY() <= 0 && playerYSpeed < 0)) { // if player is up/down boundary
			player.moveY(playerYSpeed); // move vertically according to speed
		}
		for (AlienLaser i : alienLasers) { // move alien lasers
			i.move();
		}
		for (PlayerLaser i : playerLasers) { // move player lasers
			i.move();
		}
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		for (int l = 0; l < aliens.size(); l++) { // loop through aliens
			for (int k = 0; k < playerLasers.size(); k++) { // loop through player lasers
				SpaceThing i = aliens.get(l);
				PlayerLaser j = playerLasers.get(k);
				if (j.getX() >= i.getX() && j.getX() <= (i.getX() + PLAYERENEMYWIDTH) && j.getY() >= i.getY() && j.getY() <= (i.getY() + PLAYERENEMYHEIGHT)) { // if current laser collides with current alien
					aliens.remove(l); // remove alien
					playerLasers.remove(k); // remove laser
					l--; // maintain the variable due to varied aliens.size()
					break; // go to the next alien
				}
			}
		}
		for (int l = 0; l < alienLasers.size(); l++) { // loop through the alien lasers
			AlienLaser i = alienLasers.get(l);
			if (i.getX() >= player.getX() && i.getX() <= (player.getX() + PLAYERWIDTH) && i.getY() >= player.getY() && i.getY() <= (player.getY() + PLAYERHEIGHT)) { // if current alien laser collides with the player
				if (!shielded) {
					lives--; // reduce player life
					Random rand = new Random();
					if (rand.nextDouble(2) <= DIFFICULTY) { // random immunity
						shielded = true;
						shield_used = 0;
					}
				}
				else {
					shield_used++;
					if (shield_used == SHIELD_DURABILITY) { // update immunity
						shielded = false;
					}
				}
				alienLasers.remove(l); // remove the current laser
				l--; // maintain the looping variable due to varied arraylist size
			}
		}
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		paused = true;
		won = false;
		lost = false;
		special_attack = 3;
		SP = new SpaceThing(IMG_DI, HEIGHT - IMG_DI * 2, IMG_DI, IMG_DI, "sattack.png");
		player = new SpaceThing(WIDTH / 2 - PLAYERWIDTH, HEIGHT - PLAYERHEIGHT * 2, PLAYERWIDTH, PLAYERHEIGHT, "playerCannon.png"); // spawn a new player
		int XInterval = WIDTH / (NUMALIENS / ROWS); // get the x interval between aliens depending on the number of aliens and rows
		for (int i = 0; i < NUMALIENS; i++) { // loop through the aliens
			int yTimes = i / (NUMALIENS / ROWS); // variable determining the row of the current alien
			aliens.add(new SpaceThing(XInterval * (i % (NUMALIENS / ROWS)) + PLAYERENEMYWIDTH / 2, (int)(PLAYERENEMYHEIGHT + yTimes * (PLAYERENEMYHEIGHT * 1.5)), PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "alien.png")); // spawn a new alien
		}
	}
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		if (paused || won || lost) return;
		if (playerLasers.size() == 4) { // if there are already four lasers
			playerLasers.remove(0); // remove the first laser
		}
		playerLasers.add(new PlayerLaser(player.x, player.y)); // add a new laser
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT); // fill the background in black
		SP.draw(g);

		// your code here
		for (SpaceThing i : aliens) {
			i.draw(g); // draw all the aliens
		}

		if (shielded) {
			SpaceThing temp_shielded = new SpaceThing((int)(player.x - 0.25 * PLAYERWIDTH), (int)(player.y - 0.3 * PLAYERHEIGHT), (int)(1.5 * PLAYERWIDTH), (int)(1.5 * PLAYERWIDTH), "shielded.png"); // draw the shield
			temp_shielded.draw(g);
		}
		player.draw(g); // draw the player

		for (AlienLaser i : alienLasers) {
			i.draw(g); // draw the alien lasers
		}

		for (PlayerLaser i : playerLasers) {
			i.draw(g); // draw the player lasers
		}

		if (paused) {
			g.drawImage(pausedIMG, 0, (HEIGHT - IMG_HEIGHT) / 2, null); // if it is paused then display the paused image
		}

		g.setColor(Color.red);
		g.drawString("Lives: " + lives, 15, 15); // draw the remaining lives
		g.drawString("Special Attacks Left: " + special_attack, (int)(2.5 * IMG_DI),  (int)(HEIGHT - IMG_DI * 1.5)); // draw the remaining lives

		if (lost)
			g.drawString("You lose", WIDTH / 2 - 25, HEIGHT / 2); // draw the losing string
		if (won)
			g.drawString("You win!", WIDTH / 2 - 25, HEIGHT / 2); // draw the winning string
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvaders() throws IOException {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Up");
		canvas.getActionMap().put("Up", new UpAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UpRelease");
		canvas.getActionMap().put("UpRelease", new UpReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Down");
		canvas.getActionMap().put("Down", new DownAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DownRelease");
		canvas.getActionMap().put("DownRelease", new DownReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0, false), "R");
		canvas.getActionMap().put("R", new RAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
			}
			frame.getContentPane().repaint();
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}

	private class UpAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerYSpeed = -PLAYERSPEED;
		}
	}
	private class DownAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerYSpeed = PLAYERSPEED;
		}
	}
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class UpReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerYSpeed = 0;
		}
	}
	private class DownReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerYSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			if (!won && !lost)paused = !paused;
		}
	}

	private class RAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			SPAttack();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new SpaceInvaders();
	}
}
