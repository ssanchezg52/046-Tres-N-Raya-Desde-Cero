package modelo;

import utiles.RespuestaTresEnRaya;

public class Tablero {

	private int dimension = 3;
	private Tipo matriz[][] = new Tipo[dimension][dimension];
	private String errorActual = "";

	public Tipo getValorCasilla(int x, int y) {
		return matriz[x][y];
	}

	public Tablero() {
		super();
		inicializarMatriz();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Tipo.blanco;
			}
		}
	}

	public boolean limpiarCasilla(Coordenada coordenada) {
		if (getPosicion(coordenada) != Tipo.blanco) {
			setPosicion(coordenada, Tipo.blanco);
			return true;
		}
		return false;
	}

	private void setPosicion(Coordenada coordenada, Tipo blanco) {
		matriz[coordenada.getX()][coordenada.getY()] = blanco;

	}

	public boolean borrarCasilla(Coordenada coordenada, Tipo tipo) {
		// primero hay que borrar una casilla no bloqueada de tu turno
		if (isPropiedad(coordenada, tipo) && !comprobarCasillaBloqueada(coordenada)) {
			limpiarCasilla(coordenada);
			return true;
		}
		return false;
	}

	public boolean colocarFicha(Coordenada coordenada, Tipo tipoActual) {

		if (matriz[coordenada.getX()][coordenada.getY()] == Tipo.blanco) {
			matriz[coordenada.getX()][coordenada.getY()] = tipoActual;
//			System.out.println("coordenada puesta");
			return true;
		}
		return false;
	}

	public Tipo getPosicion(Coordenada coordenada) {
		return matriz[coordenada.getX()][coordenada.getY()];
	}

	private boolean isLibre(Coordenada coordenada) {
		return getPosicion(coordenada) == Tipo.blanco;
	}

	/**
	 * 
	 * @param coordenada
	 * @return false si encuentra una libre y true en caso contrario
	 */
	public boolean comprobarCasillaBloqueada(Coordenada coordenada) {
		for (int x = coordenada.getX() - 1; x <= coordenada.getX() + 1; x++)
			for (int y = coordenada.getY() - 1; y <= coordenada.getY() + 1; y++)
				if (x >= 0 && x < this.dimension && y >= 0 && y < this.dimension)
					if (this.isLibre(new Coordenada(x, y)))
						return false;
		return true;
	}

	public String getErrorActual() {
		return this.errorActual;
	}

	public boolean isPropiedad(Coordenada coordenada, Tipo tipo) {
		return getPosicion(coordenada) == tipo;
	}

	public RespuestaTresEnRaya comprobarTresEnRayaHorizontal() {
		boolean tresEnRaya = true;
		for (int i = 0; i < matriz.length; i++) {
			tresEnRaya = true;
			for (int j = 0; j < matriz[i].length - 1 && tresEnRaya; j++) {
				if (matriz[i][j] != matriz[i][j + 1] || matriz[i][j] == Tipo.blanco) {
					tresEnRaya = false;
				}
				if (j == 1 && tresEnRaya) {
					return new RespuestaTresEnRaya(tresEnRaya, this.matriz[i][j]);
				}
			}
		}
		return new RespuestaTresEnRaya(tresEnRaya);

	}

	public RespuestaTresEnRaya comprobarTresEnRayaVertical() {
		boolean TresEnRaya = true;
		for (int i = 0; i < matriz.length;i++) {
			TresEnRaya = true;
			for (int j = 0; j < matriz.length - 1 && TresEnRaya; j++) {
				if (matriz[j][i] != matriz[j+1][i] || matriz[j][i] == Tipo.blanco) {
					TresEnRaya = false;
				}
				if (j == 1 && TresEnRaya) {
					return new RespuestaTresEnRaya(TresEnRaya, this.matriz[j][i]);
				}
			}
		}
		return new RespuestaTresEnRaya(TresEnRaya);
	}

	public RespuestaTresEnRaya comprobarTresEnRayaDiagonal() {
		boolean TresEnRaya = true;
		for (int i = 0; i < matriz.length - 1 && TresEnRaya;) {
			for (int j = 0; j < matriz.length - 1 && TresEnRaya; j++, i++) {
				if (matriz[i][j] != matriz[i + 1][j + 1] || matriz[i][j] == Tipo.blanco) {
					TresEnRaya = false;
				}
				if (j == 1 && TresEnRaya) {
					return new RespuestaTresEnRaya(TresEnRaya, this.matriz[i][j]);
				}
			}
		}
		if (!TresEnRaya) {
			TresEnRaya = true;
			for (int i = 0; i < matriz.length - 1 && TresEnRaya;) {
				for (int j = 2; j >= 1 && TresEnRaya; j--, i++) {
					if (matriz[i][j] != matriz[i + 1][j - 1] || matriz[i][j] == Tipo.blanco) {
						TresEnRaya = false;
					}
					if (j == 1 && TresEnRaya) {
						return new RespuestaTresEnRaya(TresEnRaya, this.matriz[i][j]);
					}
				}
			}
		}
		return new RespuestaTresEnRaya(TresEnRaya);

	}

}
