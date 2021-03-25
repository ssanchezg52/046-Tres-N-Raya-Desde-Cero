package modelo;

public class Tablero {

	private int dimension = 3;
	private Tipo matriz[][] = new Tipo[dimension][dimension];

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

	public boolean colocarFicha(Coordenada coordenada,Tipo tipoActual) {
		if (matriz[coordenada.getX()][coordenada.getY()] == Tipo.blanco) {
			matriz[coordenada.getX()][coordenada.getY()] = tipoActual;
			System.out.println("coordenada puesta");
			return true;
		}
		return false;
	}

}
