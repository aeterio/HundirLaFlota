package HundirLaFlota;

public class Bomba extends Arma {

	public Bomba() {
		// TODO - implement Bomba.Bomba
	}
	
	@Override
	public void ejecutarse(Tile pT) {
		pT.revelar();
		if(pT instanceof TBarco) {
			((TBarco) pT).tocar();
		}
	}

}