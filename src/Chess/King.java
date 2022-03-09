package Chess;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{

    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public King(int turn, Image img) {
        super(turn, img);
    }

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) {
            int newr = r + directions[i][0], newc = c + directions[i][1];
            if (newr < 0 || newc < 0 || newr > 7 || newc > 7) {
                continue;
            }
            if (board.getBoard()[newr][newc].getTeam() == this.getTeam()) continue;
            moves.add(new int[]{newr, newc});
        }
        return moves;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) {
        return false;
    }
}
