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

	public RespuestaColocacion realizarJugada(Coordenada coordenada) {
		//A partir de la septima jugada
		if(juego.isMover()) {
			//primero hay que borrar una casilla no bloqueada de tu turno
			if(!tablero.comprobarCasillaBloqueada(coordenada)) {
				tablero.colocarFicha(coordenada, Tipo.blanco);
				return new RespuestaColocacion(true,"");
			}
			return null;
			//luego hay que colocar en un casilla libre contigua
		}else {
			return colocarFicha(coordenada);
		}
	}
	
	private RespuestaColocacion colocarFicha(Coordenada coordenada) {
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
