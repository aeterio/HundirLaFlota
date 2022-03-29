package HundirLaFlota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

public class Jugador extends Observable{

	private double dinero;
	protected Collection<Barco>[] lBarcos;
	private int cantBomb;
	private int cantMisil;
	protected Panel panel;

	public Jugador() {
		this.dinero = 50;
		this.cantBomb = 40;
		this.cantMisil = 5;
		this.panel=new Panel();
		this.lBarcos = new ArrayList[5];
		for (int i = 1; i<5;i++) {
			this.lBarcos[i]= new ArrayList<Barco>();
		}
		this.addObserver(Vista.getVista());
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
		if (this.lBarcos[pTam].size()<5-pTam && panel.sePuedePoner(x,y,pTam,pCodDir)) { //!!! cOMENTADO PORQUE NO PERMITE PONER BARCOS CUANDO DEBERIA
			int i = 0;
			Barco b = new Barco(pTam);
			this.anadirBarco(b, pTam);
			notifyObservers(pTam);
			if(pCodDir == 0){
				while (i < pTam){
					TBarco tb =  new TBarco(x,y-i,false);
					b.anadirTBarco(tb);
					this.ponerTBPanel(x,y-i,tb);
					i++;
				}
			}
			else if(pCodDir == 1){
				while (i < pTam){
					TBarco tb =  new TBarco(x+i,y,false);
					b.anadirTBarco(tb);
					this.ponerTBPanel(x+i,y,tb);
					i++;
				}
			}
			else if(pCodDir == 2){
				while (i < pTam){
					TBarco tb =  new TBarco(x,y+i,false);
					b.anadirTBarco(tb);
					this.ponerTBPanel(x,y+i,tb);
					i++;
				}
			}
			else{
				while (i < pTam){
					TBarco tb =  new TBarco(x-i,y,false);
					b.anadirTBarco(tb);
					this.ponerTBPanel(x-i,y,tb);
					i++;
				}
			}
			this.comprobarFinAnadirBarcos();
			this.rodearBarco(x, y, pTam, pCodDir);  //!!!!COMENTADO PORQUE EL CHQUEO DE AGUA OCUPADA DESCOMENTAR PARA OCUPAR AGUA
		}

		else{
			//hacer una excepcion oh algo para comunicar al jugador, oh hacer el checkeo de manera previa
			System.out.println(((Agua)this.panel.buscarTileIndice(x, y)).getOcupado());
		}
	}

	/**
	 *
	 * @param pB
	 */
	public void anadirBarco(Barco pB,int pTam) {
		// TODO - implement Jugador.anadirBarco
		lBarcos[pTam].add(pB);
		setChanged();
		notifyObservers(pTam);
	}

	public void comprobarFinAnadirBarcos() { //Comprueba si se ha añadido el máximo de cada tipo de barco y si es así cambia el turno
		boolean lleno = true;
		for(int i = 1; i < this.lBarcos.length; i++) {
			lleno = lleno && (this.lBarcos[i].size() == 5-i);
		}
		if(lleno)Modelo.getModelo().cambioTurno();
	}

	private void rodearBarco(int x, int y, int pTam, int pCodDir) {//Rodear barco de agua ocupada
		this.panel.rodearBarco(x, y, pTam, pCodDir);
	}

	public boolean todosHundidos() {
		boolean b = true;
		Barco aux;
		Iterator<Barco> itr;
		for(int i=1; i<this.lBarcos.length;i++) {
			itr = this.lBarcos[i].iterator();
			while(itr.hasNext()) {
				aux = itr.next();
				b = b && aux.estaHundido();
			}
		}
		return b;
	}

	protected void ponerTBPanel(int x, int y, TBarco tb) {
		this.panel.ponerTileEnPos(x, y, tb);
		this.panel.revelarTileEnPos(x, y);
	}

}