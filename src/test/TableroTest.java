package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Tablero;
import modelo.Tipo;

class TableroTest {

	@Test
	void test() {
		Tablero tablero=new Tablero();
		int dimension = 3;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				assertEquals( Tipo.blanco,tablero.getValorCasilla(i, j));
			}
		}
		
	}

}
