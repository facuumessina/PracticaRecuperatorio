package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;
import tda.GrafoDTDA;

public class ConjuntoVerticesAdyacentesDobles {
	
	// Dado un Grafo G y un v�rtice v, calcular el conjunto de v�rtices AdyacentesDobles de v.
	// Se define que un v�rtice w es adyacente doble de un v�rtice v, si existe otro v�rtice x y hay
	// una arista que comienza en v y termina en x y otra que comienza en x y termina en w.

	
	public static ConjuntoDTDA grafoConj (GrafoDTDA g, int v) {
		
		ConjuntoDTDA adyDob = new ConjuntoD();
		adyDob.inicializarConjunto();
		
		ConjuntoDTDA vert = new ConjuntoD();
		vert.inicializarConjunto();
		
		vert = g.vertices(); // Para no modificar la estructura recibida como par�metro
		
		while (!vert.conjuntoVacio()) {
			
			int x = vert.elegir();
			vert.sacar(x);
			
			if (g.existeArista(v, x)) {
					
				int w = vert.elegir();
				
				if (g.existeArista(x, w)) {
					
					adyDob.agregar(w);
					
				}
				
			}
			
		}
		
		
		return adyDob;
	}
}
