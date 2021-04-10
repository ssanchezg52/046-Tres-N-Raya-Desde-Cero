package modelo;

import utiles.RespuestaColocacion;
import utiles.RespuestaTresEnRaya;

public class GestionDatos {
	private Tablero tablero;
	private Juego juego;
	private Coordenada antigua = null;
	private RespuestaTresEnRaya respuesta = new RespuestaTresEnRaya();

	public GestionDatos() {
		super();
		this.tablero = new Tablero();
		this.juego = new Juego();
	}

	public RespuestaColocacion realizarJugada(Coordenada coordenada) {
		RespuestaColocacion respuesta = new RespuestaColocacion();
		// A partir de la septima jugada
		if (this.juego.isMover()) {
			if (tablero.borrarCasilla(coordenada, this.juego.getTurnoActual())) {
				this.juego.setMover(false);
				antigua = coordenada;
				return new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
			} else {
				return new RespuestaColocacion(false, "esa casilla no es tuya", tablero.getPosicion(coordenada));
			}
			// luego hay que colocar en un casilla libre contigua
		} else if (this.juego.isJugadaMovimiento()) {
			return colocarFicha(coordenada, antigua);
		} else {
			return colocarFicha(coordenada);
		}

	}
	
	public RespuestaTresEnRaya comprobacionTresEnRaya() {
		if (this.juego.getNumeroJugada() > 5) {
			return comprobarTresEnRaya();
		}
		return new RespuestaTresEnRaya(false);
	}
	
	private RespuestaTresEnRaya comprobarTresEnRaya() {
		if (!respuesta.isTresEnRaya(this.tablero.comprobarTresEnRayaHorizontal())) {
			if (!respuesta.isTresEnRaya(this.tablero.comprobarTresEnRayaVertical())) {
				return this.tablero.comprobarTresEnRayaDiagonal();
			}else {
				return this.tablero.comprobarTresEnRayaVertical();
			}
		}else {
			return this.tablero.comprobarTresEnRayaHorizontal();
		}
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada, Coordenada antigua) {
		if (coordenada.isContigua(antigua)) {
			return colocarFicha(coordenada);
		}
		return new RespuestaColocacion(false, "no es contigua", tablero.getPosicion(coordenada));
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada) {
		boolean colocada = this.tablero.colocarFicha(coordenada, this.juego.getTurnoActual());
		if (colocada) {
			this.juego.incrementaJugada();
			if (this.juego.getNumeroJugada() > 5) {
				RespuestaTresEnRaya comprobarTresEnRaya = comprobarTresEnRaya();
			}
			return new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
		}
		return new RespuestaColocacion(false, "no esta vacia", tablero.getPosicion(coordenada));
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
