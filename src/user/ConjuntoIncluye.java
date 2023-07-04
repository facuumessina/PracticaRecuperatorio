package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;

public class ConjuntoIncluye {
	
	public static boolean otroConjunto (ConjuntoDTDA c1, ConjuntoDTDA c2) {
		
		ConjuntoDTDA aux1 = new ConjuntoD();
		aux1.inicializarConjunto();
		
		aux1 = c1;
		
		ConjuntoDTDA aux2 = new ConjuntoD();
		aux2.inicializarConjunto();
		
		aux2 = c2;
		
		while (!aux1.conjuntoVacio()) {
			
			int g = aux1.elegir();
			
			if (!aux2.pertenece(g)) {
				return false;
			}
			
			aux1.sacar(g);
			
		}
		
		if (aux1.conjuntoVacio()) {
			return true;
		}else {
			return false;
		}
		
	}

}
