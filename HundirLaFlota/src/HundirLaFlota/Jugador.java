package HundirLaFlota;

import java.util.Collection;
import java.util.Observable;

public class Jugador extends Observable{

	private double dinero;
	private Collection<Barco>[] lBarcos;
	private int cantBomb;
	private int cantMisil;
	private Panel panel;

	public Jugador() {
		// TODO - implement Jugador.Jugador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	public void consumirRecuro(Accion a) {
		// TODO - implement Jugador.consumirRecuro
		//throw new UnsupportedOperationException();
		if (a instanceof Bomba) {
			cantBomb--;
		}else if (a instanceof Misil) {
			cantMisil--;
		}
	}

	/**
	 * 
	 * @param a
	 * @param x
	 * @param y
	 */
	public void actuarSobre(Accion a, int x, int y) {
		// TODO - implement Jugador.actuarSobre
		//throw new UnsupportedOperationException();
		this.panel.accionarTile(x, y, a);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param pTam
	 * @param pCodDir
	 */
	public void ponerBarco(int x, int y, int pTam, int pCodDir) {
		// TODO - implement Jugador.ponerBarco
		if (panel.sePuedePoner(x,y,pTam,pCodDir)) {
			int i = 0;
			int z;
			Barco b = new Barco(pTam);
			this.anadirBarco(b, pTam);
			notifyObservers(pTam);
			if(pCodDir == 0){
				while (i < pTam){
					TBarco tb =  new TBarco();
					b.anadirTBarco(tb);
					panel.ponerTileEnPos(x,y-i,tb);
					i++;
				}
			}
			else if(pCodDir == 1){
				while (i < pTam){
					TBarco tb =  new TBarco();
					b.anadirTBarco(tb);
					panel.ponerTileEnPos(x+i,y,tb);
					i++;
				}
			}
			else if(pCodDir == 2){
				while (i < pTam){
					TBarco tb =  new TBarco();
					b.anadirTBarco(tb);
					panel.ponerTileEnPos(x,y+i,tb);
					i++;
				}
			}
			else{
				while (i < pTam){
					TBarco tb =  new TBarco();
					b.anadirTBarco(tb);
					panel.ponerTileEnPos(x-i,y,tb);
					i++;
				}
			}
		}
		else{
			//hacer una excepcion oh algo para comunicar al jugador, oh hacer el checkeo de manera previa
		}
	}

	/**
	 * 
	 * @param pB
	 */
	public void anadirBarco(Barco pB,int pTam) {
		// TODO - implement Jugador.anadirBarco
		lBarcos[pTam].add(pB);
	}

}