package control;

import modelo.Coordenada;
import modelo.GestionDatos;

public class Controlador {
	private GestionDatos gestion;

	public Controlador() {
		super();
		gestion = new GestionDatos();
	}
	
	//void no es
	public void XXXX(String posicion){
		this.gestion.XXXX(new Coordenada(posicion));
	}

}
