package gameOfLife.backend.beam;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class CellsBoard extends Observable implements Observer {
	
	private static CellsBoard me;
	
	private static final int GRID_HEIGHT = 100;
	private static final int GRID_WIDTH = 100;

	private Cell[][] board;
	
	private CellsBoard() {
		board = new Cell[GRID_WIDTH][GRID_HEIGHT];
		initBoard();
		startCells();
	}

	public static CellsBoard getInstance() {
		if(me == null) {
			me = new CellsBoard();
		}
		return me;
	}
	
	private void startCells() {
		for(Cell[] cs: board) {
			for(Cell c: cs) {
				new Thread(c).start();
			}
		}
		
	}

	private void initBoard() {
		for(int x = 0; x < GRID_WIDTH; x++) {
			for(int y = 0; y < GRID_HEIGHT; y++) {
				board[x][y] = new Cell(this, x, y);
				board[x][y].addObserver(this);
			}
		}
		
	}

	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Cell) {
			setChanged();
			notifyObservers(arg);
		}
		
	}
	
	
	public Cell[][] getBoard() {
		return board;
	}

	
	
	
	
}
