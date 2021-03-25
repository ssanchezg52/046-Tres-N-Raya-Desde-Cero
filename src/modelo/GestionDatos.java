package modelo;

public class GestionDatos {
	private Tablero tablero;
	private Juego juego;
	
	public GestionDatos() {
		super();
		tablero=new Tablero();
		juego=new Juego();
	}

	public boolean colocarFicha(Coordenada coordenada) {
		if(this.tablero.colocarFicha(coordenada,this.juego.getTurnoActual())) {
			this.juego.incrementaJugada();
			return true;
		}
		return false;
	}

	public String getTipoActualName() {
		return this.juego.getTurnoActualName();
	}

	public String getTipoAnteriorName() {
		return this.juego.getTurnoAnteriorName();
	}
	
}
