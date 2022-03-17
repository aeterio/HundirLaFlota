package HundirLaFlota;

public class Modelo {

	private static Modelo mModelo;
	private Accion accionCargada;
	private boolean turnoUsuario;  //Indica si quien realiza la acción es el usuario
	private Usuario usuario;
	private IA ia;
	private int bapCoordX;
	private int bapCoordY;
	private int bapTamaño;
	private int estado;				//Estado 0: colocoar barcos, estado 1: bombardear

	private Modelo() {
		// TODO - implement Modelo.Modelo
		throw new UnsupportedOperationException();
	}

	public static Modelo getModelo() {
		// TODO - implement Modelo.getModelo
		throw new UnsupportedOperationException();
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

	/**
	 * 
	 * @param x
	 * @param y
	 */
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

	/**
	 * 
	 * @param x
	 * @param y
	 */
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
	}

	/**
	 * 
	 * @param pCodDIr
	 */
	public void recibirDir(int pCodDIr) {
		// TODO - implement Modelo.recibirDir
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pTam
	 */
	public void recibirTamaño(int pTam) {
		// TODO - implement Modelo.recibirTamaño
		throw new UnsupportedOperationException();
	}

}