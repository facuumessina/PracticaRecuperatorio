package user;

import impl.ColaD;
import tda.ColaDTDA;

public class Main {

	// Pruebas de validación de funcionamiento //
	
	public static void main(String[] args) {

		// Ejercicio uso cola//
		
		
		ColaDTDA origen  = new ColaD();
		origen.inicializarCola();
		
		origen.acolar(1);
		origen.acolar(2);
		origen.acolar(3);
		origen.acolar(4);
		origen.acolar(5);
		
		/*
		
		ColaDTDA destino = new ColaD();
		destino.inicializarCola();
		
		destino = PasarCola.igualOrden(origen);
		
		while (!destino.colaVacia()) {
			System.out.println(destino.primero() + "\n");
			destino.desacolar();
		}
		
		*/
		
		
		
		
		
		
	}

}
