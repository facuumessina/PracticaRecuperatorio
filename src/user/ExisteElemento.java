package user;

import tda.ABBDTDA;

public class ExisteElemento {
	
	// Dado un elemento, determinar si existe en el ABB
	
	public static boolean  enABB (ABBDTDA a, int e) {
		
		if (a.arbolVacio()) {
			return false;
		} else if (a.raiz() == e) {
			return true;
		} else if (a.raiz() > e) {
			return ExisteElemento.enABB(a.hijoIzq(), e);
		} else {
			return ExisteElemento.enABB(a.hijoDer(), e);
		}
		
	}

}
