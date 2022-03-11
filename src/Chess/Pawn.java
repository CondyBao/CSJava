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
		if (getTeam() == 1)
			i = 1; // if it is black, it can only move down
		else
			i = -1; // if it is white, it can only move up

		if (r == 1 && getTeam() == 1 && board.getBoard()[r + 1][c].getTeam() == -1 && board.getBoard()[r + 2][c].getTeam() == -1) { // check if it is the first move for black pawns
			moves.add(new int[]{r + 2, c}); // add move: two steps down
		}

		if (r == 6 && getTeam() == 0 && board.getBoard()[r - 1][c].getTeam() == -1 && board.getBoard()[r - 2][c].getTeam() == -1) { // check if it is the first move for white pawns
			moves.add(new int[]{r - 2, c}); // add move: two steps up
		}

		if (r + i < 8 && r + i >= 0 && board.getBoard()[r + i][c].getTeam() == -1) { // check if the new coordinate is in bound and empty
			moves.add(new int[]{r + i, c}); // move up/down one step depending on the pawn's color(refer to earlier)
		}
		// check if the two diagonal steps for a pawn has an opponent's piece and are in bound
		if (r + i < 8 && r + i >= 0 && c + 1 < 8) {
			if (board.getBoard()[r + i][c + 1].getTeam() == (getTeam() + 1) % 2) {
				moves.add(new int[]{r + i, c + 1}); // add move one diagonal step
			}
		}

		if (r + i < 8 && r + i >= 0 && c - 1 >= 0) {
			if (board.getBoard()[r + i][c - 1].getTeam() == (getTeam() + 1) % 2) {
				moves.add(new int[]{r + i, c - 1}); // add the other diagonal step (refer to the last if statement)
			}
		}

		return moves; // return all the moves
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) { // check method for pawn
		if (getTeam() == 1) { // if it is black team
			if (kingr - r == 1)
				if (Math.abs(kingc - c) == 1) // the white king is on either diagonal steps
					return true; // it is a check
		}
		if (getTeam() == 0) { // if it is white team
			if (kingr - r == -1)
				if (Math.abs(kingc - c) == 1) // the black king is on either diagonal steps
					return true;  // it is a check
		}
		return false; // it is not a check
	}

}
