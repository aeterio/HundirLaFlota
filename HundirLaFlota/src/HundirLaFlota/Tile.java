package HundirLaFlota;

public class Tile {

	private int coordX;
	private int coordY;
	private boolean oculto;

	/**
	 * 
	 * @param pCoordX
	 * @param pCoordY
	 * @param pOc
	 */
	public Tile(int pCoordX, int pCoordY, boolean pOc) {
		// TODO - implement Tile.Tile
		//throw new UnsupportedOperationException();
		this.coordX=pCoordX;
		this.coordY=pCoordY;
		this.oculto=pOc;
	}

	public void revelar() {
		// TODO - implement Tile.revelar
		//throw new UnsupportedOperationException();
		this.oculto = false;
	}

	public void actVista() {
		// TODO - implement Tile.actVista
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	public void ejecutar(Accion a) {
		// TODO - implement Tile.ejecutar
		//throw new UnsupportedOperationException();
		a.ejecutarse(this);
	}

}