package gameOfLife.frontend.gui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import gameOfLife.backend.beam.Cell;
import gameOfLife.backend.beam.CellsBoard;

@SuppressWarnings("deprecation")
public class CellButton extends JButton implements Observer, ActionListener {

	private static final long serialVersionUID = -2241712941561906943L;
	
	private int x, y;
	
	
	
	public CellButton(int x, int y) {
		super();
		this.addActionListener(this);
		this.x = x;
		this.y = y;
		CellsBoard.getInstance().getBoard()[x][y].addObserver(this);
		updateColor();
		this.setSize(new Dimension(5, 5));
	}




	@Override
	public void update(Observable o, Object arg) {
		updateColor();
	}

	private void updateColor() {
		if(CellsBoard.getInstance().getBoard()[x][y].isAlive()) {
			this.setBackground(Color.WHITE);
		}
		else {
			this.setBackground(Color.BLACK);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CellsBoard.getInstance().getBoard()[x][y].setAlive(!CellsBoard.getInstance().getBoard()[x][y].isAlive());
		
	}

	public int getX() {
		return x;
	}




	public int getY() {
		return y;
	}




	

	
	
}
