package user;

import impl.ColaD;
import impl.PilaD;
import tda.ColaDTDA;
import tda.PilaDTDA;

public class PasarCola {
	
	// Se realiza el ejercicio propuesto pero la cola retornada debe estar en orden inverso, ya que en el enunciado a través de 2 colas mantienen el orden
	
	public static ColaDTDA igualOrden (ColaDTDA origen) {
		
		ColaDTDA destino = new ColaD();
		destino.inicializarCola();
		
		destino = origen; // Para evitar alteración de estructura recibida
		
		PilaDTDA pila = new PilaD();
		pila.inicializarPila();
		
		while (!destino.colaVacia()) {
			pila.apilar(destino.primero());
			destino.desacolar();
		}
		
		while (!pila.pilaVacia()) {
			destino.acolar(pila.tope());
			pila.desapilar();
		}
		
		return destino;
	}

}
