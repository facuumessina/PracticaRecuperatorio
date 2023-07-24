package user;

import impl.ConjuntoD;
import tda.ABBDTDA;
import tda.ConjuntoDTDA;

public class NodosPares {
	
	// Dado un ABB, devolver el conjunto de todos los nodos pares del mismo
	
	public static ConjuntoDTDA enABB (ABBDTDA a) {
		
		ConjuntoDTDA pares = new ConjuntoD();
		pares.inicializarConjunto();
		
		if (!a.arbolVacio()) {
			
			if (a.raiz() % 2 == 0) {
				pares.agregar(a.raiz());
			}
			
			ConjuntoDTDA rI = NodosPares.enABB(a.hijoIzq());
			ConjuntoDTDA rD = NodosPares.enABB(a.hijoDer());
			
			while (!rI.conjuntoVacio()) {
				
				int e = rI.elegir();
				pares.agregar(e);
				rI.sacar(e);
				
			}
			
			while (!rD.conjuntoVacio()) {
				
				int e = rD.elegir();
				pares.agregar(e);
				rD.sacar(e);
			}
		}
		
		return pares;
	}

}
