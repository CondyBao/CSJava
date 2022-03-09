package Chess;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public abstract class Piece {
	
	// generic class to represent any chess piece
	// don't edit this class
	
	private int team; // either 0 or 1
	private Image img; 
	
	public Piece(int turn, Image img) {
		team = turn;
		this.img = img;
	}
	
	public int getTeam() {
		return team;
	}
	
	// given this piece's location, returns a list of 2-element arrays (coordinates) 
	// containing all the possible legal squares this piece can move to.
	public abstract ArrayList<int[]> getMoves(Board board, int r, int c);
	
	public void draw(Graphics g, int x, int y) {
		g.drawImage(img, x, y, Chess.IMG_WIDTH, Chess.IMG_WIDTH, null);
	}
	
	// returns whether this is an empty square
	public abstract boolean isEmpty();
	
	public boolean isKing() {
		return false;
	}
	
	// given the location of the opponent's king and this piece's location,
	// determines if this piece has put the king in check.
	public abstract boolean check(int kingr, int kingc, int r, int c, Board board);

}
