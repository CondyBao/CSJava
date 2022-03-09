package Chess;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(int turn, Image img) {
        super(turn, img);
    }

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        boolean eligibleF = true, eligibleB = true;
        for (int i = 1; i < 8; i++) { // vertical moves
            int newr = r + i, newbr = r - i;// newr->move forward, newbr->move backward
            if (newr < 0 || newr > 7) eligibleF = false;
            if (newbr < 0 || newbr > 7) eligibleB = false;
            if (board.getBoard()[newr][c].getTeam() == this.getTeam()) eligibleF = false;
            if (board.getBoard()[newbr][c].getTeam() == this.getTeam()) eligibleB = false;
            if (eligibleF) {
                moves.add(new int[]{newr, c});
                if (!board.getBoard()[newr][c].isEmpty()) eligibleF = false;
            }
            if (eligibleB) {
                moves.add(new int[]{newbr, c});
                if (!board.getBoard()[newbr][c].isEmpty()) eligibleB = false;
            }
        }
        eligibleF = true;
        eligibleB = true;
        for (int i = 1; i < 8; i++) { // horizontal moves
            int newc = c + i, newbc = c - i;// newc->move forward, newbc->move backward
            if (newc < 0 || newc > 7) eligibleF = false;
            if (newbc < 0 || newbc > 7) eligibleB = false;
            if (board.getBoard()[r][newc].getTeam() == this.getTeam()) eligibleF = false;
            if (board.getBoard()[r][newbc].getTeam() == this.getTeam()) eligibleB = false;
            if (eligibleF) {
                moves.add(new int[]{r, newc});
                if (!board.getBoard()[r][newc].isEmpty()) eligibleF = false;
            }
            if (eligibleB) {
                moves.add(new int[]{r, newbc});
                if (!board.getBoard()[r][newbc].isEmpty()) eligibleB = false;
            }
        }
        eligibleF = true;
        eligibleB = true;
        boolean eligibleF2 = true, eligibleB2 = true;
        for (int i = 1; i < 8; i++) { // check diagonals
            int newr = r + i, newc = c + i, newbr = r - i, newbc = c - i;
            if (newr < 0 || newr > 7 || newc < 0 || newc > 7) eligibleF = false;
            if (newbr < 0 || newbr > 7 || newbc < 0 || newbc > 7) eligibleB = false;
            if (newr < 0 || newr > 7 || newbc < 0 || newbc > 7) eligibleF2 = false;
            if (newbr < 0 || newbr > 7 || newc < 0 || newc > 7) eligibleB2 = false;
            if (board.getBoard()[newr][newc].getTeam() == this.getTeam()) eligibleF = false;
            if (board.getBoard()[newbr][newbc].getTeam() == this.getTeam()) eligibleB = false;
            if (board.getBoard()[newr][newbc].getTeam() == this.getTeam()) eligibleF2 = false;
            if (board.getBoard()[newbr][newc].getTeam() == this.getTeam()) eligibleB2 = false;
            if (eligibleF) {
                moves.add(new int[]{newr, newc});
                if (!board.getBoard()[newr][newc].isEmpty()) eligibleF = false;
            }
            if (eligibleB) {
                moves.add(new int[]{newbr, newbc});
                if (!board.getBoard()[newbr][newbc].isEmpty()) eligibleB = false;
            }
            if (eligibleF2) {
                moves.add(new int[]{newr, newbc});
                if (!board.getBoard()[newr][newbc].isEmpty()) eligibleF2 = false;
            }
            if (eligibleB2) {
                moves.add(new int[]{newbr, newc});
                if (!board.getBoard()[newbr][newc].isEmpty()) eligibleB2 = false;
            }
        }
        return moves;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) {
        ArrayList<int[]> moves = getMoves(board, r, c);
        boolean flag = false;
        for (int[] m : moves) {
            int newr = r + m[0], newc = c + m[1];
            if (newr == kingr && newc == kingc) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
