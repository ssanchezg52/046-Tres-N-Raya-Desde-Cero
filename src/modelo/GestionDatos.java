package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {
	private Tablero tablero;
	private Juego juego;
	private Coordenada antigua = null;

	public GestionDatos() {
		super();
		tablero = new Tablero();
		juego = new Juego();
	}

	public RespuestaColocacion realizarJugada(Coordenada coordenada) {
		// A partir de la septima jugada
		if (juego.isMover()) {
			// primero hay que borrar una casilla no bloqueada de tu turno
			if (tablero.isPropiedad(coordenada, this.juego.getTurnoActual())
					&& !tablero.comprobarCasillaBloqueada(coordenada)) {
				tablero.limpiarCasilla(coordenada);
				this.juego.setMover(false);
				antigua = coordenada;
				return new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
			} else {
				return new RespuestaColocacion(false, "esa casilla no es tuya",tablero.getPosicion(coordenada));
			}
			// luego hay que colocar en un casilla libre contigua
		} else {
			return colocarFicha(coordenada, antigua);
		}
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada, Coordenada antigua) {
		if (antigua == null) {
			return colocarFicha(coordenada);
		} else {
			if (coordenada.isContigua(antigua)) {
				return colocarFicha(coordenada);
			}
			return new RespuestaColocacion(false, "no es contigua",tablero.getPosicion(coordenada));
		}
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada) {
		RespuestaColocacion respuesta = this.tablero.colocarFicha(coordenada, this.juego.getTurnoActual());
		if (respuesta.isRespuesta()) {
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
