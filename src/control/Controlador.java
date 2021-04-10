package control;

import modelo.Coordenada;
import modelo.GestionDatos;
import utiles.RespuestaColocacion;
import utiles.RespuestaTresEnRaya;

public class Controlador {
	private GestionDatos gestion;
	
	public Controlador() {
		super();
		gestion = new GestionDatos();
	}
	
	//void no es
	public RespuestaColocacion realizarJugada(String posicion){
		return this.gestion.realizarJugada(new Coordenada(posicion));
	}

	public String getTipoName() {
		return this.gestion.getTipoActualName();
	}

	public String getTipoAnteriorName() {
		return this.gestion.getTipoAnteriorName();
	}

	public RespuestaTresEnRaya comprobacionTresEnRaya() {
		return this.gestion.comprobacionTresEnRaya();
		
	}

//	public String getErrorName() {
//		return this.gestion.getErrorActualName();
//	}

}
