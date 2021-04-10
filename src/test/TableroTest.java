package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Coordenada;
import modelo.Tablero;
import modelo.Tipo;
import utiles.RespuestaTresEnRaya;

class TableroTest {

	Tablero tablero;

	@BeforeEach
	void before() {
		tablero = new Tablero();
	}

	@Test
	void test() {
		int dimension = 3;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				assertEquals(Tipo.blanco, tablero.getValorCasilla(i, j));
			}
		}
	}

	@Test
	void testcomprobarBloqueada() {
		int posX[] = {0,0,1,1,2,2};
		int posY[] = {1,2,2,1,0,1};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i],posY[i]), tipos[i]);
		}
		assertTrue(tablero.comprobarCasillaBloqueada(new Coordenada(0,2)));
		assertFalse(tablero.comprobarCasillaBloqueada(new Coordenada(1,1)));
	}
	
	@Test
	void testTresEnRayaHorizontal() {
		int posX[] = {0,1,0,1,0,2};
		int posY[] = {0,2,2,1,1,1};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.X).equals(tablero.comprobarTresEnRayaHorizontal()));
	}
	
	@Test
	void testDosTresEnRayaHorizontal() {
		int posX[] = {0,1,0,1,2,1};
		int posY[] = {0,2,2,1,1,0};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.O).equals(tablero.comprobarTresEnRayaHorizontal()));
	}
	
	@Test
	void testTerceroTresEnRayaHorizontal() {
		int posX[] = {2,1,2,0,2,1};
		int posY[] = {1,2,2,1,0,0};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.X).equals(tablero.comprobarTresEnRayaHorizontal()));
	}
	
	@Test
	void testTresEnRayaVertical() {
		//TODO
		int posX[] = {1,1,0,2,2,1};
		int posY[] = {0,2,0,1,0,0};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.X).equals(tablero.comprobarTresEnRayaVertical()));
	}
	
	@Test
	void testDosTresEnRayaVertical() {
		//TODO
		int posX[] = {1,0,1,1,2,2};
		int posY[] = {0,1,2,1,0,1};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.O).equals(tablero.comprobarTresEnRayaVertical()));
	}
	
	@Test
	void testTerceroTresEnRayaVertical() {
		//TODO
		int posX[] = {0,2,1,1,2,2};
		int posY[] = {2,1,2,1,2,0};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		

		assertTrue(new RespuestaTresEnRaya(true, Tipo.X).equals(tablero.comprobarTresEnRayaVertical()));
	}
	
	@Test
	void testTresEnRayaDiagonal() {
		//TODO
		int posX[] = {0,0,1,0,2,2};
		int posY[] = {0,1,1,2,2,1};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.X).equals(tablero.comprobarTresEnRayaDiagonal()));
	}
	
	@Test
	void testDosTresEnRayaDiagonal() {
		//TODO
		int posX[] = {1,0,0,1,2,2};
		int posY[] = {0,2,1,1,2,0};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertTrue(new RespuestaTresEnRaya(true, Tipo.O).equals(tablero.comprobarTresEnRayaDiagonal()));
	}
	
	@Test
	void testTerceroTresEnRayaDiagonal() {
		//TODO
		int posX[] = {1,2,0,2,1,1};
		int posY[] = {1,2,1,1,0,2};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i], posY[i]), tipos[i]);
		}
		
		assertFalse(new RespuestaTresEnRaya(true).equals(tablero.comprobarTresEnRayaDiagonal()));
	}
	
	
	

}
