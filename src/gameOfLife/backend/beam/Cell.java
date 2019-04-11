package gameOfLife.backend.beam;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Cell extends Observable {

	private int x, y;
	private boolean alive;
	private boolean thenAlive;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.alive = false;
		this.thenAlive = false;
	}

	public Cell(int x, int y, boolean alive) {
		super();
		this.x = x;
		this.y = y;
		this.alive = alive;
	}

	public void checkLife() {
		int neighboringAlive = 0;
		
		Cell[][] _board = CellsBoard.getInstance().getBoard();
		try {
			if(_board[x - 1][y - 1].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x][y - 1].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x + 1][y - 1].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x - 1][y].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x + 1][y].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x - 1][y + 1].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x][y + 1].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		try {
			if(_board[x + 1][y + 1].isAlive()) {
				neighboringAlive++;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {}
		
		
		
		if(neighboringAlive == 3) {
			this.thenAlive = true;
		}
		else if(neighboringAlive == 2) {
			
		}
		else {
			this.thenAlive = false;
		}
	}
	
	public void applyChanges() {
		this.setAlive(this.thenAlive);
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		if(this.alive != alive) {
			CellsBoard.getInstance().displaySituation();
			setChanged();
			notifyObservers(this);
		}
		
		this.alive = alive;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
}
