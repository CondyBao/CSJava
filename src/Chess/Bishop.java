package Chess;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(int turn, Image img) { // inheritance constructor
        super(turn, img);
    }

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) { // function to get all the available moves for the current piece
        ArrayList<int[]> moves = new ArrayList<int[]>();
        boolean eligibleF = true, eligibleB = true, eligibleF2 = true, eligibleB2 = true; // the four diagonals, each variable determines if there is a piece in the way to deeper moves on the diagonal
        for (int i = 1; i < 8; i++) { // check all four diagonals
            boolean temp1 = true, temp2 = true, temp3 = true, temp4 = true; // the four temporary variables to determine if the current grid is out of bound
            int newr = r + i, newc = c + i, newbr = r - i, newbc = c - i; // the four possible new r, c values
            if (newr < 0 || newr > 7 || newc < 0 || newc > 7) temp1 = false; // check the four diagonals for out of bounds
            if (newbr < 0 || newbr > 7 || newbc < 0 || newbc > 7) temp2 = false;
            if (newr < 0 || newr > 7 || newbc < 0 || newbc > 7) temp3 = false;
            if (newbr < 0 || newbr > 7 || newc < 0 || newc > 7) temp4 = false;
            if (temp1 && board.getBoard()[newr][newc].getTeam() == this.getTeam()) eligibleF = false; // check the four diagonals for pieces of the same team
            if (temp2 && board.getBoard()[newbr][newbc].getTeam() == this.getTeam()) eligibleB = false;
            if (temp3 && board.getBoard()[newr][newbc].getTeam() == this.getTeam()) eligibleF2 = false;
            if (temp4 && board.getBoard()[newbr][newc].getTeam() == this.getTeam()) eligibleB2 = false;
            if (temp1 && eligibleF) { // if each of the four diagonals is eligible
                moves.add(new int[]{newr, newc}); // add the new move to the arraylist
                if (!board.getBoard()[newr][newc].isEmpty()) eligibleF = false; // if there is an opponent piece, prevent future search from moving further in this direction
            }
            if (temp2 && eligibleB) {
                moves.add(new int[]{newbr, newbc});
                if (!board.getBoard()[newbr][newbc].isEmpty()) eligibleB = false;
            }
            if (temp3 && eligibleF2) {
                moves.add(new int[]{newr, newbc});
                if (!board.getBoard()[newr][newbc].isEmpty()) eligibleF2 = false;
            }
            if (temp4 && eligibleB2) {
                moves.add(new int[]{newbr, newc});
                if (!board.getBoard()[newbr][newc].isEmpty()) eligibleB2 = false;
            }
        }
        return moves; // return all the possible moves
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) {
        ArrayList<int[]> moves = getMoves(board, r, c); // retrieve the moves
        boolean flag = false; // a check boolean to see if there is check
        for (int[] m : moves) { // go through all the possible moves
            int newr = m[0], newc = m[1]; // get the new coordinates
            if (newr == kingr && newc == kingc) { // if the new coordinates correspond to the opponent's king, then it is a check
                flag = true;
                break;
            }
        }
        return flag; // return the check boolean
    }
}
