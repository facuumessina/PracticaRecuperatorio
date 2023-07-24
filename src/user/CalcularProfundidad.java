package user;

import tda.ABBDTDA;

public class CalcularProfundidad {
	
	// Dado un elemento, calcular su profundidad en el ABB
	
	public static int enABB(ABBDTDA a, int e) {
		
		if (a.arbolVacio()) {
			return 0;
		} else if (a.raiz() == e) {
			return 0;
		} else if (a.raiz() > e) {
			return (1 + CalcularProfundidad.enABB(a.hijoIzq(), e));
		} else {
			return (1 + CalcularProfundidad.enABB(a.hijoDer(), e));
		}
	}

}
