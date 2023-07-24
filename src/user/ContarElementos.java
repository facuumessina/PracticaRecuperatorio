package user;

import tda.ABBDTDA;

public class ContarElementos {
	
	// Contar la cantidad de nodos de un ABB
	
	public static int enABB (ABBDTDA a) {
	
		if (a.arbolVacio()) {
			return 0;
		}else {
			return (1 + ContarElementos.enABB(a.hijoIzq())+ ContarElementos.enABB(a.hijoDer()));
		}
	}
}
