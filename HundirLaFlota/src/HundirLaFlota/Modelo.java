package HundirLaFlota;

import java.util.Observable;

public class Modelo extends Observable {

	private static Modelo mModelo;
	private Accion accionCargada;
	private boolean turnoUsuario;  //Indica si quien realiza la acción es el usuario
	private Jugador usuario;
	private IA ia;
	private int bapCoordX;
	private int bapCoordY;
	private int bapTamaño;
	private int estado;				//Estado 0: colocoar barcos, estado 1: bombardear

	private Modelo() {
		// TODO - implement Modelo.Modelo
		this.addObserver(Vista.getVista());
	}

	public static Modelo getModelo() {
		// TODO - implement Modelo.getModelo
		if (mModelo == null) {
			mModelo = new Modelo();
		}
		return mModelo;
	}

	public void cargarAccion(int pCodAcc) {
		// TODO - implement Modelo.cargarAccion
		//throw new UnsupportedOperationException();
		if (pCodAcc==0) {
			this.accionCargada = new Bomba();
		}else if(pCodAcc==1) {
			this.accionCargada = new Misil();
		}
	}

	private void actuarSobreTile(int x, int y) {
		// Dependiendo del turno uno realiza y el otro consume
		Jugador j1, j2;
		if (turnoUsuario) {
			j1 = this.usuario;
			j2 = this.ia;
		}else {
			j1 = this.ia;
			j2 = this.usuario;
		}
		j1.consumirRecuro(this.accionCargada);
		j2.actuarSobre(this.accionCargada, x, y);
	}

	public void recibirPos(int x, int y) {
		// Si estamos en estado de colocar barcos guardamos las coordenadas, sino mandamos la acción 
		// a cada jugador para que la traten segun les toque.
		//throw new UnsupportedOperationException();
		if (estado ==0) {
			this.bapCoordX=x;
			this.bapCoordY=y;
		}else if (estado == 1) {
			this.actuarSobreTile(x, y);
		}
		System.out.println(x+" "+y);
	}

	public void recibirDir(int pCodDIr) {
		//En comparacion con el resto de los Recibires este no se alamacena, sino que pasa directamente al jugador
		// 0 = Norte
		// 1 = Este
		// 2 = Sur
		// 3 = Oeste
		if (estado == 0){
			this.usuario.ponerBarco(this.bapCoordX,this.bapCoordY,this.bapTamaño, pCodDIr);
		}
	}

	public void recibirTamaño(int pTam) {
		//Almacenamos el Tamaño, el tipo, de barco para posterior uso en la colocacion
		if(estado == 0){
			this.bapTamaño = pTam;
		}
	}

	public void cambioTurno() {
		this.turnoUsuario = !this.turnoUsuario;
		notifyObservers(this.turnoUsuario);
	}
	
	public void cambioEstado() {
		this.estado++;
		notifyObservers(estado);
	}
}