package HundirLaFlota;

public class TBarco extends Tile {

	private Barco barco;
	private boolean tocado;

	public TBarco() {
		// TODO - implement TBarco.TBarco
		throw new UnsupportedOperationException();
	}

	public boolean getTocado() {
		return this.tocado;
	}

	public void tocar() {
		// TODO - implement TBarco.tocar
		if (this.barco.estaProtegido()) {
			this.barco.setProtegido(false);
		}else {
			this.tocado = true;
			notifyObservers(1);
		}
	}

}