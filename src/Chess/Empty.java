package Chess;
import java.awt.Graphics;
import java.util.ArrayList;

public class Empty extends Piece {
	
	// represents an empty square on the board. 
	// don't edit this class. 
	
	public Empty() {
		super(-1, null);
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		return null;
	}


	@Override
	public boolean isEmpty() {
		return true;
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		return;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
}
