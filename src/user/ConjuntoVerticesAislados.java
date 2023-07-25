package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;
import tda.GrafoDTDA;

public class ConjuntoVerticesAislados {
	
	// Dado un Grafo G escribir un método que permita obtener el conjunto de los vértices aislados en G.
	// Se define que un vértice v es aislado si v no tiene aristas entrantes ni salientes.
	
	public static ConjuntoDTDA enGrafo (GrafoDTDA g) {
		
		ConjuntoDTDA aisl = new ConjuntoD();
		aisl.inicializarConjunto();
		
		ConjuntoDTDA aux = new ConjuntoD();
		aux.inicializarConjunto();
		
		aux = g.vertices();
		
		while (!aux.conjuntoVacio()) {
			
			int e = aux.elegir();
			
			aux.sacar(e);
			
			if (!g.existeArista(e, aux.elegir()) && !g.existeArista(aux.elegir(), e)) {
				aisl.agregar(e);
			}
			
		}
		
		return aisl;
	}

}
