package HundirLaFlota;

public class Misil extends Arma {

	public Misil() {
		// TODO - implement Misil.Misil
	}
	
	@Override
	public void ejecutarse(Tile pT) {
		pT.revelar();
		if(pT instanceof TBarco) {
			((TBarco) pT).tocarEntero();
		}
		
	}

}