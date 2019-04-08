package gameOfLife.frontend.gui.mainFrame;

import java.awt.GridLayout;

import javax.swing.JFrame;

import gameOfLife.backend.beam.CellsBoard;
import gameOfLife.frontend.gui.components.CellButton;

public class GameOfLifeGUI extends JFrame {

	
	private static final long serialVersionUID = 4149717672757634067L;
	
	private CellButton[][] grid;
	
	public GameOfLifeGUI() {
		super("Game of life");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		initComponents();
	}

	private void initComponents() {
		grid = new CellButton[CellsBoard.getGridWidth()][CellsBoard.getGridHeight()];
		for(int x = 0; x < CellsBoard.getGridWidth(); x++) {
			for(int y = 0; y < CellsBoard.getGridHeight(); y++) {
				grid[x][y] = new CellButton(x, y);
			}
		}
		
		this.setLayout(new GridLayout(CellsBoard.getGridHeight(), CellsBoard.getGridWidth()));
		
		for(int x = 0; x < CellsBoard.getGridWidth(); x++) {
			for(int y = 0; y < CellsBoard.getGridHeight(); y++) {
				this.add(grid[x][y]);
			}
		}
		
//		CellsBoard.getInstance().start();
		
	}

	public static void main(String[] args) {
		new GameOfLifeGUI().setVisible(true);

	}

}
