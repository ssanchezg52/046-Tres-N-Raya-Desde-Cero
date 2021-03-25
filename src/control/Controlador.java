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
	public boolean colocarFicha(String posicion){
		return this.gestion.colocarFicha(new Coordenada(posicion));
	}

	public String getTipoName() {
		return this.gestion.getTipoActualName();
	}

	public String getTipoAnteriorName() {
		return this.gestion.getTipoAnteriorName();
	}

	public String getErrorName() {
		return this.gestion.getErrorActualName();
	}

}
