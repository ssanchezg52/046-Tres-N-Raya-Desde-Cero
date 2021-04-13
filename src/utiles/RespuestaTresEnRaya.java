package utiles;

import modelo.Tipo;

public class RespuestaTresEnRaya {

	private boolean respuesta;
	private Tipo tipo;
	private String mensajeGanador;
	
	public RespuestaTresEnRaya() {
		super();
	}
	
	public RespuestaTresEnRaya(boolean respuesta, Tipo tipo) {
		super();
		this.respuesta = respuesta;
		this.tipo = tipo;
	}
	
	public RespuestaTresEnRaya(boolean respuesta) {
		super();
		this.respuesta = respuesta;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RespuestaTresEnRaya))
			return false;
		RespuestaTresEnRaya local = (RespuestaTresEnRaya) obj;
		return (this.respuesta == local.respuesta && this.tipo.equals(local.tipo));
	}
	
	public boolean isTresEnRaya(RespuestaTresEnRaya respuesta) {
		return respuesta.isRespuesta() == true;
	}
	
	public String Mensajeganador() {
		return this.mensajeGanador = "TRES EN RAYA!!! HA GANADO " + this.getTipo();
	}
	
	public boolean isRespuesta() {
		return this.respuesta;
	}

	public Tipo getTipo() {
		return this.tipo;
	}
	
	
	

}
