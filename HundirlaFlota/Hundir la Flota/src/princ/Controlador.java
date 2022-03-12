package princ;

public class Controlador {
	private static Controlador mControlador;
	
	private Controlador() {}
	
	public static Controlador getControlador() {
		if(mControlador == null) {
			mControlador = new Controlador();
		}
		return mControlador;
	}
	
	
	public void pasarCoords(int pIndice) {
		
	}
	
	public void pasarAcción(int codAcc) {
		
	}

}
