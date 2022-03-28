package HundirLaFlota;

public class Seleccion extends Accion{
	
	public Seleccion() {
		
	}
	
	@Override
	public void ejecutarse(Tile pT) {
		pT.seleccionar();
	}
	
}
