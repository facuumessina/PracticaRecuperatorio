package user;

import impl.PilaD;
import tda.PilaDTDA;

public class PilaA {
	
	public static float porcentaje(PilaDTDA pila) {
		
		float contadorPares = 0;
		float contadorElementosPila = 0;
		
		PilaDTDA aux = new PilaD();
		aux.inicializarPila();
		
		aux = pila;
		
		while (!aux.pilaVacia()) {
			
			if(aux.tope() % 2 == 0){
				contadorPares++;
			}
			
			contadorElementosPila++;
			aux.desapilar();
		}
		
		float porcentaje = contadorPares / contadorElementosPila;
		
		return porcentaje;
	}

}
