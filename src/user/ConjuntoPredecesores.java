package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;
import tda.GrafoDTDA;

public class ConjuntoPredecesores {
	
	public static ConjuntoDTDA predecesores (GrafoDTDA g, int v) {
		
		ConjuntoDTDA resp = new ConjuntoD();
		resp.inicializarConjunto();
		
		ConjuntoDTDA nodos = new ConjuntoD();
		nodos.inicializarConjunto();
		
		nodos = g.vertices(); // Obtenemos todos los vertices
		
		while (!nodos.conjuntoVacio()) { // Recorremos todos los vertices
			
			int e = nodos.elegir();
			
			if (g.existeArista(e, v)) { // Preguntamos si existe arista entre el que itera y el de parámetro
				resp.agregar(e);
			}
			
			nodos.sacar(e);
		}
		
		return resp;
	}

}
