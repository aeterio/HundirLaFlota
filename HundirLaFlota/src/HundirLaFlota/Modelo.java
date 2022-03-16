package HundirLaFlota;

public class Modelo {

	private static Modelo mModelo;
	private Accion accionCargada;
	private boolean turnoUsuario;
	private Usuario usuario;
	private IA ia;
	private int bapCoordX;
	private int bapCoordY;
	private int bapTamaño;
	private boolean estado;

	private Modelo() {
		// TODO - implement Modelo.Modelo
		throw new UnsupportedOperationException();
	}

	public static Modelo getModelo() {
		// TODO - implement Modelo.getModelo
		throw new UnsupportedOperationException();
	}

	public void cargarAccion() {
		// TODO - implement Modelo.cargarAccion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void actuarSobreTile(int x, int y) {
		// TODO - implement Modelo.actuarSobreTile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void recibirPos(int x, int y) {
		// TODO - implement Modelo.recibirPos
		throw new UnsupportedOperationException();
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
	 * @param x
	 * @param y
	 */
	private void actuar(int x, int y) {
		// TODO - implement Modelo.actuar
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