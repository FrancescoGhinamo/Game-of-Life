package gameOfLife.backend.beam;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Cell extends Observable implements Runnable {

	private int x, y;
	private boolean alive;
	private CellsBoard owner;

	public Cell(CellsBoard owner, int x, int y) {
		super();
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.alive = false;
	}

	public Cell(CellsBoard owner, int x, int y, boolean alive) {
		super();
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.alive = alive;
	}
	
	
	@Override
	public void run() {
		while(true) {
			checkLife();
		}
		
	}

	public void checkLife() {
		int neighboringAlive = 0;
		
		Cell[][] _board = owner.getBoard();
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
			this.setAlive(true);
		}
		else if(neighboringAlive == 2) {
			
		}
		else {
			this.setAlive(false);
		}
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		if(this.alive != alive) {
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
