package gameOfLife.backend.beam;


public class CellsBoard extends Thread {
	
	private static CellsBoard me;
	
	private static final int GRID_HEIGHT = 3;
	private static final int GRID_WIDTH = 3;

	private volatile Cell[][] board;
	
	private boolean stopped;
	
	private CellsBoard() {
		board = new Cell[GRID_WIDTH][GRID_HEIGHT];
		initBoard();
	}

	public static CellsBoard getInstance() {
		if(me == null) {
			me = new CellsBoard();
		}
		return me;
	}
	
	public void run() {
		this.stopped = false;
		while(!stopped) {
			for(Cell[] cs: board) {
				for(Cell c: cs) {
					c.checkLife();
				}
			}
			
			for(Cell[] cs: board) {
				for(Cell c: cs) {
					c.applyChanges();
				}
			}
		}
		
		
	}

	public void displaySituation() {
		for(int x = 0; x < GRID_WIDTH; x++) {
			for(int y = 0; y < GRID_HEIGHT; y++) {
				if(board[x][y].isAlive()) {
					System.out.print("A ");
				}
				else {
					System.out.print("D ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	private void initBoard() {
		for(int x = 0; x < GRID_WIDTH; x++) {
			for(int y = 0; y < GRID_HEIGHT; y++) {
				board[x][y] = new Cell(x, y);
			}
		}
		
	}

	public void pause() {
		this.stopped = true;
	}
	
	
	public Cell[][] getBoard() {
		return board;
	}

	public static int getGridHeight() {
		return GRID_HEIGHT;
	}

	public static int getGridWidth() {
		return GRID_WIDTH;
	}

	
	
	
	
	
}
