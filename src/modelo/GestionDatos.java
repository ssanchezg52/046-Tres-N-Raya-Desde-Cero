package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {
	private Tablero tablero;
	private Juego juego;
	
	public GestionDatos() {
		super();
		tablero=new Tablero();
		juego=new Juego();
	}

	public RespuestaColocacion colocarFicha(Coordenada coordenada) {
		RespuestaColocacion respuesta = this.tablero.colocarFicha(coordenada,this.juego.getTurnoActual());
		if(respuesta.isRespuesta()) {
			this.juego.incrementaJugada();
		}
		return respuesta;
	}

	public String getTipoActualName() {
		return this.juego.getTurnoActualName();
	}

	public String getTipoAnteriorName() {
		return this.juego.getTurnoAnteriorName();
	}

//	public RespuestaColocacion getErrorActualName() {
//		return this.tablero.getErrorActual();
//	}
//	
}
