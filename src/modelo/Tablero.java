package modelo;

import utiles.RespuestaColocacion;

public class Tablero {

	private int dimension = 3;
	private Tipo matriz[][] = new Tipo[dimension][dimension];
	private String errorActual="";

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

	public RespuestaColocacion colocarFicha(Coordenada coordenada,Tipo tipoActual) {
		RespuestaColocacion respuesta=new RespuestaColocacion();
		if (matriz[coordenada.getX()][coordenada.getY()] == Tipo.blanco) {
			matriz[coordenada.getX()][coordenada.getY()] = tipoActual;
			System.out.println("coordenada puesta");
			respuesta.setRespuesta(true);
			respuesta.setMensaje("");
			return respuesta;
		}
		respuesta.setRespuesta(false);
		respuesta.setMensaje("casilla no vacia");
		return respuesta;
	}

	public String getErrorActual() {
		return this.errorActual;
	}

}
