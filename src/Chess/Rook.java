package Chess;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(int turn, Image img) {
        super(turn, img);
    } // inheritance constructor

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>(); // retrive all the moves
        boolean eligibleF = true, eligibleB = true; // the eligibility variables that check for if there is a piece moving further forward/backward
        for (int i = 1; i < 8; i++) { // vertical moves
            boolean temp1 = true, temp2 = true; // temporary variables that check for out of bounds
            int newr = r + i, newbr = r - i;// newr->move forward, newbr->move backward
            if (newr < 0 || newr > 7) temp1 = false; // if either of the coordinates is out of bounds, set temp to false
            if (newbr < 0 || newbr > 7) temp2 = false;
            if (temp1 && board.getBoard()[newr][c].getTeam() == this.getTeam()) eligibleF = false; // set eligibility to false if there is a piece from the same team in the way
            if (temp2 && board.getBoard()[newbr][c].getTeam() == this.getTeam()) eligibleB = false;
            if (temp1 && eligibleF) { // if fulfills both requirements, add the new move
                moves.add(new int[]{newr, c});
                if (!board.getBoard()[newr][c].isEmpty()) eligibleF = false; // if there is an opponent's piece at this new coordinate, prevent any further movements in this direction
            }
            if (temp2 && eligibleB) {
                moves.add(new int[]{newbr, c});
                if (!board.getBoard()[newbr][c].isEmpty()) eligibleB = false;
            }
        }
        eligibleF = true; // reset the eligibility variables
        eligibleB = true;
        for (int i = 1; i < 8; i++) { // horizontal moves' check method that does the same thing
            boolean temp1 = true, temp2 = true;
            int newc = c + i, newbc = c - i;// newc->move forward, newbc->move backward
            if (newc < 0 || newc > 7) temp1 = false;
            if (newbc < 0 || newbc > 7) temp2 = false;
            if (temp1 && board.getBoard()[r][newc].getTeam() == this.getTeam()) eligibleF = false;
            if (temp2 && board.getBoard()[r][newbc].getTeam() == this.getTeam()) eligibleB = false;
            if (temp1 && eligibleF) {
                moves.add(new int[]{r, newc});
                if (!board.getBoard()[r][newc].isEmpty()) eligibleF = false;
            }
            if (temp2 && eligibleB) {
                moves.add(new int[]{r, newbc});
                if (!board.getBoard()[r][newbc].isEmpty()) eligibleB = false;
            }
        }
        return moves;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) { // comments refer to the bishop's check method
        ArrayList<int[]> moves = getMoves(board, r, c);
        boolean flag = false;
        for (int[] m : moves) {
            int newr = m[0], newc = m[1];
            if (newr == kingr && newc == kingc) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
