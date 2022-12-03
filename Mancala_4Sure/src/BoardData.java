
package src;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * author
 */
public class BoardData {
	final int BOARD_LENGTH = 7;
	private int initialMarbles;
	private ArrayList<ArrayList<Integer>> board;
	private boolean isP1Turn;
	private boolean gameOver;
	private LinkedList<ArrayList<ArrayList<Integer>>> boardStack;
	private boolean isP1PrevTurn;
	private int numUndos;
	private boolean consecUndo;
	private ArrayList<ChangeListener> listeners;

	/**
	 * Constructor generates a default board
	 */
	public BoardData(int initMarbles) {
		initialMarbles = initMarbles;
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		for (int index = 0; index < BOARD_LENGTH - 1; index++) {
			p1.add(initialMarbles);
		}
		p1.add(0);
		ArrayList<Integer> p2 = new ArrayList<Integer>(p1);
		board = new ArrayList<ArrayList<Integer>>();
		// board.get(0) is player 1's side
		board.add(p1);
		// board.get(1) is player 2's side
		board.add(p2);
		isP1Turn = true;
		gameOver = false;
		boardStack = new LinkedList<ArrayList<ArrayList<Integer>>>();
		isP1PrevTurn = true;
		numUndos = 0;
		consecUndo = false;
		listeners = new ArrayList<ChangeListener>();
	}

	public ArrayList<ArrayList<Integer>> getBoard() {
		return board;
	}

	public int getPit(int side, int pit) {
		return board.get(side % 2).get(pit);
	}

	public boolean getTurn() {
		return isP1Turn;
	}

	/**
	 * conducts an action in the game
	 * 
	 * @param pit- pit to make action with
	 */
	public void turn(int pit) {
		if (isP1Turn != isP1PrevTurn) {
			boardStack.clear();
		}
		consecUndo = false;
		boardStack.add(board);
		isP1PrevTurn = isP1Turn;
		// keeps track of the side
		int initSide;
		if (isP1Turn) {
			initSide = 0;
		} else {
			initSide = 1;
		}
		int side = initSide;
		// number of stones grabbed
		int i = board.get(side % 2).get(pit);
		// index of the pits
		int j = pit;
		board.get(side % 2).set(pit, 0);
		while (i > 0) {
			j++;
			if (j == BOARD_LENGTH - 1) {
				if (isP1Turn == (side % 2 == 0)) {
					incPit(side, j, 1);
					i--;
				}
				j = -1;
				side++;
				i++;
			} else {
				incPit(side, j, 1);
			}
			i--;
		}
		j++;
		isP1Turn = !isP1Turn;
		if (j == 0 && ((side % 2 == 0) == isP1Turn)) {
			isP1Turn = !isP1Turn;
		} else if ((initSide == side % 2) && getPit(side, j - 1) == 1) {
			int steal = getPit(side + 1, 6 - j + 1);
			board.get((side + 1) % 2).set(6 - j + 1, 0);
			board.get(side % 2).set(j - 1, 0);
			int sideC;
			if (isP1Turn) {
				sideC = 1;
			} else {
				sideC = 0;
			}
			incPit(sideC, 6, steal + 1);
		}
		endGame();
		change();
	}

	/**
	 * undos a turn
	 */
	public void undo() {
		board = boardStack.pop();
		isP1Turn = isP1PrevTurn;
	}

	public boolean canUndo() {
		if (!(numUndos >= 3) && boardStack.size() > 0 && !consecUndo) {
			numUndos++;
			consecUndo = true;
			return true;
		}
		return false;
	}

	private void incPit(int side, int pit, int inc) {
		int temp = board.get(side % 2).get(pit);
		temp += inc;
		board.get(side % 2).set(pit, temp);
	}

	private void endGame() {
		int r1 = 0;
		int r2 = 0;
		for (int i = 0; i < BOARD_LENGTH - 1; i++) {
			r1 += board.get(0).get(i);
			r2 += board.get(1).get(i);
		}
		if (r1 == 0) {
			boardSweep(1, r2);
		} else if (r2 == 0) {
			boardSweep(0, r1);
		}
	}

	private void boardSweep(int side, int amt) {
		gameOver = true;
		int points = board.get(side).get(BOARD_LENGTH - 1);
		points += amt;
		board.get(side).set(BOARD_LENGTH - 1, points);
		for (int i = 0; i < BOARD_LENGTH - 1; i++) {
			board.get(side).set(i, 0);
		}
	}

	public void addListener(ChangeListener l) {
		listeners.add(l);
	}

	public void change() {
		ChangeEvent e = new ChangeEvent(this);
		for (ChangeListener l : listeners) {
			l.stateChanged(e);
		}
	}
}
