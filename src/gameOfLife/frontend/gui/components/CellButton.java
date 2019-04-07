package gameOfLife.frontend.gui.components;

import java.awt.Graphics;

import javax.swing.JButton;

public class CellButton extends JButton {

	private static final long serialVersionUID = -2241712941561906943L;
	
	private int x, y;
	
	
	
	
	public CellButton(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
