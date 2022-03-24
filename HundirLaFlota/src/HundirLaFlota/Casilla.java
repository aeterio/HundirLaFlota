package HundirLaFlota;

import javax.swing.JLabel;

public class Casilla extends JLabel{ //Adapter??
	private int coordX;
	private int coordY;
	
	public Casilla(int x, int y) {
		this.coordX=x;
		this.coordY=y;
	}
	
	public int getX() {return this.coordX;}
	public int getY() {return this.coordY;}
	
}
