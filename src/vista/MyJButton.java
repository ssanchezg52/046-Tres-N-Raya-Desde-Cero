package vista;

import javax.swing.JButton;

public class MyJButton extends JButton {
	//Un envoltorio que le da mas funcionalidad a una clase 
	private int x,y;

	public MyJButton(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

}
