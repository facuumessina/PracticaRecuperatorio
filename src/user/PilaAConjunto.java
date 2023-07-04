package user;

import impl.ConjuntoD;
import impl.PilaD;
import tda.ConjuntoDTDA;
import tda.PilaDTDA;

public class PilaAConjunto {
	
	public static ConjuntoDTDA elementosRepetidos (PilaDTDA pila) {
		
		ConjuntoDTDA c = new ConjuntoD();
		c.inicializarConjunto();
		
		ConjuntoDTDA repet = new ConjuntoD();
		repet.inicializarConjunto();
		
		PilaDTDA aux = new PilaD();
		aux.inicializarPila();
		
		aux = pila;
		
		while (!aux.pilaVacia()) {
			
			int g = aux.tope();
			aux.desapilar();
			
			if (!c.pertenece(g)) {
				c.agregar(g);
			}else {
				repet.agregar(g);
			}
		}
		
		return repet;
		
	}

}
