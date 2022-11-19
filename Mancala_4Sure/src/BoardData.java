import java.util.*;

import javax.swing.event.InternalFrameEvent;

public class BoardData {
    final int INITIAL_MARBLES = 4;
    final int BOARD_LENGTH = 7;
    private ArrayList<ArrayList<Integer>> board;
    private boolean isP1Turn;
    private LinkedList<ArrayList<ArrayList<Integer>>> boardStack;
    private LinkedList<Boolean> turnStack;
    /**
     * Constructor generates a default board
     */
    public BoardData(){
        ArrayList<Integer> p1 = new ArrayList<Integer>();
        for (int index = 0; index < BOARD_LENGTH-1; index++) {
            p1.add(INITIAL_MARBLES);
        }
        p1.add(0);
        ArrayList<Integer> p2 = new ArrayList<Integer>(p1);
        board = new ArrayList<ArrayList<Integer>>();
        //board.get(0) is player 1's side
        board.add(p1);
        //board.get(1) is player 2's side
        board.add(p2);
        isP1Turn=true;
        boardStack = new LinkedList<ArrayList<ArrayList<Integer>>>();
        turnStack = new LinkedList<Boolean>();
    }
    public ArrayList<ArrayList<Integer>> getBoard(){
        return board;
    }
    public int getPit(int side, int pit){
        return board.get(side%2).get(pit);
    }
    //conducts an action
    public void turn(int pit){
        //keeps track of the side
        int side;
        if(isP1Turn){
            side=0;
        }
        else{
            side=1;
        }
        //number of stones grabbed
        int i = board.get(side%2).get(pit);
        //index of the pits
        int j = pit;
        board.get(side%2).set(pit, 0);
        while(i>0){
            j++;
            if(j==BOARD_LENGTH-1){
                if(isP1Turn == (side%2==0)){
                    incPit(side, j,1);
                    i--;
                }
                j=-1;
                side++;
                i++;
            }
            else{
                incPit(side, j,1);
            }
            i--;
        }
        j++;
        isP1Turn = !isP1Turn;
        if(j==0 && ((side%2==0)==isP1Turn)){
            isP1Turn = !isP1Turn;
        }
        else if(getPit(side, j-1)==1){
            int steal = getPit(side+1, 6-j+1);
            board.get((side+1)%2).set(6-j+1, 0);
            board.get(side%2).set(j-1, 0);
            int sideC;
            if(isP1Turn){
                sideC=1;
            }
            else{
                sideC=0;
            }
            incPit(sideC, 6, steal+1);
        }
    }
    private void incPit(int side, int pit, int inc){
        int temp = board.get(side%2).get(pit);
        temp+=inc;
        board.get(side%2).set(pit, temp);
    }
}
