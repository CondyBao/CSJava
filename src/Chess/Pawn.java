package Chess;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Pawn extends Piece{
	
	// represents a pawn. 
	// getMoves is trickier than other classes because pawns can move 2 squares
	// if still in their starting position.
	// don't edit this class
	
	public Pawn(int turn, Image img) {
		super(turn, img);
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		int i;
		if (getTeam() == 0)
			i = 1;
		else
			i = -1;
		
		if (c+i < 8 && c+i >= 0 && board.getBoard()[r][c+i].getTeam() == -1) {
			int[] move = {r,c+i};
			moves.add(move);
		}
		if (getTeam() == 0 && c == 1 && board.getBoard()[r][c+2].getTeam() == -1 && board.getBoard()[r][c+1].getTeam() == -1) {
			int[] move = {r, c+2};
			moves.add(move);
		}
		if (getTeam() == 1 && c == 6 && board.getBoard()[r][c-2].getTeam() == -1 && board.getBoard()[r][c-1].getTeam() == -1) {
			int[] move = {r, c-2};
			moves.add(move);
		}
		if (r+1 < 8 && c+i < 8 && c+i >= 0)
			if (board.getBoard()[r + 1][c+i].getTeam() == (getTeam()+1)%2) {
				int[] move = {r+1,c+i};
				moves.add(move);
			}
		if (r-1 >= 0 && c+i < 8 && c+i >= 0)
			if (board.getBoard()[r -1][c+i].getTeam() == (getTeam()+1)%2) {
				int[] move = {r-1,c+i};
				moves.add(move);
			}
		
		
		return moves;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		if (getTeam() == 0) {
			if (kingr - r == 1)
				if (Math.abs(kingc - c) == 1)
					return true;
		}
		if (getTeam() == 1) {
			if (kingc - r == -1)
				if (Math.abs(kingc - c) == 1)
					return true;
		}
		return false;
	}

}
