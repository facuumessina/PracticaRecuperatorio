package user;

import tda.GrafoDTDA;
import impl.ConjuntoD;
import tda.ConjuntoDTDA;

public class CalcularMayorCosto {
	
	// Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes.
	
	public static int aristasSalientes (GrafoDTDA g, int v) {
		
		int costo = 0;
		
		ConjuntoDTDA vert = new ConjuntoD();
		vert.inicializarConjunto();
		
		vert = g.vertices();
		
		if (perteneceAGrafo(g, v)) {
			
			while (!vert.conjuntoVacio()) {
				
				int e = vert.elegir();
				
				if (g.existeArista(v, e)) {
					
					if (g.pesoArista(v, e) > costo) {
						costo = g.pesoArista(v, e);
					}
					
				}
				
				vert.sacar(e);
				
			}
			
		}
		
		
		return costo;
	}
	
	private static boolean perteneceAGrafo (GrafoDTDA g, int v) {
		
		ConjuntoDTDA vert = new ConjuntoD();
		vert.inicializarConjunto();
		
		vert = g.vertices();
		
		boolean existe = false;
		
		while (!vert.conjuntoVacio()) {
			
			int e = vert.elegir();
			
			if (e == v) {
				existe = true;
			}
			
			vert.sacar(e);
			
		}
		
		return existe;
		
	}

}
