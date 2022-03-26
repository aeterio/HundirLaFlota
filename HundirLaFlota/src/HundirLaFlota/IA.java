package HundirLaFlota;

public class IA extends Jugador {

	public IA() {
		// TODO - implement IA.IA
	}

	public void ponerBarcosInteligente() {
		// TODO - implement IA.ponerBarcosInteligente
		throw new UnsupportedOperationException();
	}

	public void realizarAccionInteligente() {
		// TODO - implement IA.realizarAccionInteligente
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void comprobarFinAnadirBarcos() { //Comprueba si se ha añadido el máximo de cada tipo de barco y si es así cambia el turno
		boolean lleno = true;
		for(int i = 1; i < this.lBarcos.length; i++) {
			lleno = lleno && (this.lBarcos[i].size() == 5-i);
		}
		if(lleno) {
			Modelo.getModelo().cambioTurno();
			Modelo.getModelo().cambioEstado();
		}
	}
	
	/* 
	@Override //METODO PARA QUE NO SE MUESTREN LOS BARCOS PUESTOS POR LA IA
	protected void ponerTBPanel(int x, int y, TBarco tb) {
		this.panel.ponerTileEnPos(x, y, tb);
	}*/

}