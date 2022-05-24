package Chess;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chess {
	
	
	/******** DON'T EDIT THIS CLASS ********/
	
		
	// constants that are predefined and won't change
	public static final int WIDTH = 600;
	public static final int SQUARE_WIDTH = WIDTH/8;
	public static final int IMG_WIDTH = SQUARE_WIDTH - 10;
	
	// the board
	private Board board;
	
	// the most recently clicked-on piece and its location
	private Piece last_clicked = null;
	private int lastx = 0,lasty = 0;
	
	// current turn, alternates between 0 and 1
	private int turn = 0;
	
	// game status
	private boolean game_over = false;
	
	// the window
	private JFrame frame;
	

	// very simple main method to get the game going
	public static void main(String[] args) {
		new Chess(); 
	}
 
	// initialize the graphics and listeners
	public Chess() {
		board = new Board();
		frame = new JFrame();
		frame.setSize(WIDTH+2, WIDTH+24);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				board.draw(g, last_clicked);
			}
		};
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
			
				if (!game_over) {
					Piece clicked = board.getBoard()[e.getY()/SQUARE_WIDTH][e.getX()/SQUARE_WIDTH];
					
					if (clicked.getTeam() == turn) {
						lastx = e.getX()/SQUARE_WIDTH;
						lasty = e.getY()/SQUARE_WIDTH;
						last_clicked = clicked;
					}
					
					else if (last_clicked != null)		{	

						if (is_in(e.getY()/SQUARE_WIDTH, e.getX()/SQUARE_WIDTH, last_clicked.getMoves(board, lasty, lastx))) {
								
							int result = board.move(lasty, lastx, e.getY()/SQUARE_WIDTH, e.getX()/SQUARE_WIDTH);
							
							if (result == 2) {
								game_over = true;
								frame.getContentPane().repaint();
								JOptionPane.showMessageDialog(null, "Checkmate. " + (turn == 0 ? "White" : "Black") + " wins!");
								return;
							}
							else if (result == 1) {
								frame.getContentPane().repaint();
								JOptionPane.showMessageDialog(null, "Check");
							}

							
							last_clicked = null;
					
							turn = (turn + 1)%2;
						}
					}
				}

				frame.getContentPane().repaint();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		canvas.setFocusable(true);
		
		frame.add(canvas);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		frame.getContentPane().repaint();
	}

	
	
	public boolean is_in(int x, int y, ArrayList<int[]> moves) {
		for (int[] pair : moves) {
			if (x == pair[0] && y == pair[1])
				return true;
		}
		return false;
	}
}


