package gameOfLife.frontend.gui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import gameOfLife.backend.beam.Cell;
import gameOfLife.backend.beam.CellsBoard;

@SuppressWarnings("deprecation")
public class CellButton extends JButton implements Observer {

	private static final long serialVersionUID = -2241712941561906943L;
	
	private int x, y;
	private Cell linkedCell;
	
	
	
	public CellButton(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		CellsBoard.getInstance().getBoard()[x][y].addObserver(this);
		this.linkedCell = CellsBoard.getInstance().getBoard()[x][y];
		this.setSize(new Dimension(5, 5));
	}




	@Override
	public void update(Observable o, Object arg) {
		if(this.linkedCell.isAlive()) {
			this.setBackground(Color.WHITE);
		}
		else {
			this.setBackground(Color.BLACK);
		}
		
	}




	public int getX() {
		return x;
	}




	public int getY() {
		return y;
	}

	
	
}
