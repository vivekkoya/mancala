import java.util.ArrayList;

import javax.swing.event.InternalFrameEvent;

public class Board {
    final int INITIAL_MARBLES = 4;
    final int BOARD_LENGTH = 7;
    private ArrayList<ArrayList<Integer>> board;
    private boolean isP1Turn;
    public Board(){
        ArrayList<Integer> p1 = new ArrayList<Integer>();
        for (int index = 0; index < BOARD_LENGTH-1; index++) {
            p1.add(INITIAL_MARBLES);
        }
        p1.add(0);
        ArrayList<Integer> p2 = new ArrayList<Integer>(p1);
        board = ArrayList<ArrayList<Integer>>();
        board.add(p1);
        board.add(p2);
        isP1Turn=true;
    }

}
