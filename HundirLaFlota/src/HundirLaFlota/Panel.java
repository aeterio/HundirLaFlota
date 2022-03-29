package HundirLaFlota;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Panel {

	private Tile[][] lTiles;

	public Panel() {
		this.lTiles=new Tile[10][10];
		this.llenarAgua();
	}

	/**
	 *
	 * @param x
	 * @param y
	 */
	/*private*/ public Tile buscarTileIndice(int x, int y) {
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
			if (y - pTam +1 >= 0){
				z=
						Arrays.stream(lTiles) // Stream<Tile[]>
								.flatMap(Arrays::stream)
								.filter(t -> t.coordY >= y - pTam + 1 && t.coordY <= y && t.coordX == x)
								//.forEach(e -> System.out.println("set0:" + e.coordX + " " + e.coordY + "<= La Y:"+ y + " - " + pTam));
								.allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == false);
			}
		}
		else if (pCodDIr == 1){
			if (x + pTam <= 10){
				z =
						Arrays.stream(lTiles) // Stream<Tile[]>
								.flatMap(Arrays::stream)
								.filter(t -> t.coordX <= x + pTam - 1 && t.coordX >= x && t.coordY == y)
								//.forEach(e -> System.out.println("set1:" +e.coordX + " " + e.coordY + "<= la X:"+ x + " + " + pTam));
								.allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == false);
			}
		}
		else if(pCodDIr == 2){
			if (y + pTam <= 10){
				z =
						Arrays.stream(lTiles) // Stream<Tile[]>
								.flatMap(Arrays::stream)
								.filter(t -> t.coordY <= y + pTam - 1 && t.coordY >= y  && t.coordX == x)
								//.forEach(e -> System.out.println("set2:" +e.coordX + " " + e.coordY + "<= la Y:"+ y + " + " + pTam));
								.allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == false);
			}
		}
		else if(pCodDIr == 3){
			if (x - pTam +1 >= 0){
				z =
						Arrays.stream(lTiles) // Stream<Tile[]>
								.flatMap(Arrays::stream)
								.filter(t -> t.coordX >= x - pTam + 1 && t.coordX <= x && t.coordY == y)
								//.forEach(e -> System.out.println("set3:" +e.coordX + " " + e.coordY + "<= La X:"+ x + " - " + pTam));
								.allMatch(t -> t instanceof Agua && ((Agua) t).getOcupado() == false);
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
		this.lTiles[x][y]=tB;
	}

	public void revelarTileEnPos(int x, int y) {
		this.lTiles[x][y].revelar();
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @param a
	 */
	public void accionarTile(int x, int y, Accion a) {
		this.lTiles[x][y].ejecutar(a);
	}
	public void llenarAgua(){
//		Arrays.stream(lTiles).flatMap(Arrays::stream).forEach(v -> v = new Agua(v.getCoordX(),v.getCoordY(),true));
//		Tal cual estaba no funcionaba asi que lo haré con iterador y lo podemos revisar para java8 luego
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				this.lTiles[i][j]=new Agua(i,j,true);
				this.lTiles[i][j].revelar();
			}
		}
	}

	public void rodearBarco(int x, int y, int pTam, int pCodDir) {//Ocupa agua entorno a barco
		int indx;
		int indy;
		int xinic;
		int xfin;
		int yinic;
		int yfin;
		pTam--;
		if(pCodDir==3) {
			xinic=x-pTam;
			xfin=x;
			yinic=y;
			yfin=y;
		}
		else if (pCodDir==1) {
			xinic=x;
			xfin=x+pTam;
			yinic=y;
			yfin=y;
		}
		else if (pCodDir==0){
			xinic=x;
			xfin=x;
			yinic=y-pTam;
			yfin=y;
		}
		else {
			xinic=x;
			xfin=x;
			yinic=y;
			yfin=y+pTam;
		}

		System.out.println("%%"+xinic+ " "+ yinic);
		indx=xinic-1;
		while(indx<=xfin+1) {
			if(indx>=0&&indx<10) {
				indy=yinic-1;
				while(indy<=yfin+1) {
					if(indy>=0 && indy<10) {
						if(this.lTiles[indx][indy] instanceof Agua) {
							((Agua)this.lTiles[indx][indy]).setOcupado(true);
							System.out.println(""+indx+ " "+ indy);
						}
					}
					indy++;
				}
			}
			indx++;
		}
		System.out.println("%%"+xfin+ " "+ yfin);
	}
}