package user;

import tda.ABBDTDA;

public class CalcularSuma {
	
	// Calcular la suma de los elementos que contiene un ABB
	
	public static int nodosEnABB(ABBDTDA a) {
		
		if (a.arbolVacio()) {
			return 0;
		}else {
			return a.raiz() + CalcularSuma.nodosEnABB(a.hijoIzq()) + CalcularSuma.nodosEnABB(a.hijoDer());
		}
	}

}
