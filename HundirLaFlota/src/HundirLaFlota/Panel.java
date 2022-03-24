package HundirLaFlota;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Panel {

	private Tile[][] lTiles;

	public Panel() {
		// TODO - implement Panel.Panel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	private Tile buscarTileIndice(int x, int y) {
		// TODO - implement Panel.buscarTileIndice
		return Arrays.stream(lTiles) // Stream<Tile[]>
					.flatMap(Arrays::stream)
						.filter(t -> t.coordX == x && t.coordY == y).findFirst().orElse(null);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param pTam
	 * @param pCodDIr
	 */
	public boolean sePuedePoner(int x, int y, int pTam, int pCodDIr) {
		// TODO - implement Panel.sePuedePoner
		boolean z = false;
		if (pCodDIr == 0){
			if (y - pTam >= 0){
				z = Arrays.stream(lTiles) // Stream<Tile[]>
						.flatMap(Arrays::stream)
						.filter(t -> t.coordY <= y - pTam + 1).allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == true);
			}
		}
		else if (pCodDIr == 1){
			if (x + pTam <= 10){
				z = Arrays.stream(lTiles) // Stream<Tile[]>
						.flatMap(Arrays::stream)
						.filter(t -> t.coordY <= x + pTam - 1).allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == true);
			}
		}
		else if(pCodDIr == 2){
			if (y + pTam <= 10){
				z = Arrays.stream(lTiles) // Stream<Tile[]>
						.flatMap(Arrays::stream)
						.filter(t -> t.coordY <= y + pTam - 1).allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == true);
			}
		}
		else if(pCodDIr == 3){
			if (x - pTam >= 0){
				z = Arrays.stream(lTiles) // Stream<Tile[]>
						.flatMap(Arrays::stream)
						.filter(t -> t.coordY <= x - pTam + 1).allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == true);
			}
		}
		return z;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void ponerTileEnPos(int x, int y, TBarco tB) {
		// TODO - implement Panel.ponerTileEnPos
		Tile t = buscarTileIndice(x,y);
		t = tB;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param a
	 */
	public void accionarTile(int x, int y, Accion a) {
		// TODO - implement Panel.accionarTile
		throw new UnsupportedOperationException();
	}
	public void llenarAgua(){
		Arrays.stream(lTiles).flatMap(Arrays::stream).forEach(v -> v = new Agua());
	}
}