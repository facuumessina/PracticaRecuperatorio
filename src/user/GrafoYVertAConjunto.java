package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;
import tda.GrafoDTDA;

public class GrafoYVertAConjunto {
	
	/**
	* @estrategia Para la realizacion de este ejercicio se opto por: Crear 2 metodos a parte, uno que verifique si el vertice (que luego que pasaremos por paramentro el vertice actual encontrado) es puente de los vertices que nosotros definimos como origen y destino. El otro chequea que existan vertices dentro de nuestro grafo.
	* @tarea Busca vertices, los almacena  dn verticeActual y con el metodo esVerticePuente verifica si es puente del vertice origen o no.
	* @parámetros Grafo creado donde buscar los vertices, 2 numeros enteros del vertice origen y vertice destino.
	* @devuelve Retorna el conjunto VerticesPuente que contiene los vertices que si fueron puente entre el origen y el destino.
	* @precondiciones Conjunto donde almacenar vertices inicializado y grafo inicializado.
	* @postcondiciones Se retorna el conjunto de vertices puente.
	* @costo Polinomico
	*/
	
//	Dado un Grafo G y dos vértices v1 y v2, escribir un método que permita obtener el conjunto
//	de todos los vértices puente entre v1 y v2.
//	Se define que un vértice p es puente entre dos vértices o y d, si hay una arista que
//	comienza en o y termina en p y otra que comienza en p y termina en d.

	
		public static ConjuntoDTDA encontrarVerticesPuente(GrafoDTDA grafo, int verticeOrigen, int verticeDestino) {
	    
			ConjuntoDTDA verticesPuente = new ConjuntoD();
			verticesPuente.inicializarConjunto();

			if (existeVertice(grafo,verticeOrigen) && existeVertice(grafo,verticeDestino)) {
		
				ConjuntoDTDA vertices = new ConjuntoD();
				vertices.inicializarConjunto();
		
				vertices = grafo.vertices();
    
				while (!vertices.conjuntoVacio()) {
				
					int verticeActual = vertices.elegir();
					vertices.sacar(verticeActual); // Lineal
        
					// Verificar si el vértice actual es un vértice puente entre el vértice origen y el vértice destino
			
					if (esVerticePuente(grafo, verticeActual, verticeOrigen, verticeDestino)) {
					
						verticesPuente.agregar(verticeActual);
					}
				} // --> Polinomico ya que se debe a una iteración de un ciclo con operaciones que poseen costo lineal, se asume por ser el peor costo posible
			}

			return verticesPuente;
		}// --> Polinomico

		public static boolean existeVertice(GrafoDTDA grafo, int vertice) {
    
			ConjuntoDTDA vertices = new ConjuntoD();
			vertices.inicializarConjunto();
	
			vertices = grafo.vertices();
    
			while (!vertices.conjuntoVacio()) {// Constante
				int verticeActual = vertices.elegir(); // Constante
				vertices.sacar(verticeActual); // Lineal
        
				if (verticeActual == vertice) { // Constante
					return true;
				}
			}// --> Polinomico
    
			return false;
		}

		public static boolean esVerticePuente(GrafoDTDA grafo, int vertice, int verticeOrigen, int verticeDestino) {
	
			return (grafo.existeArista(verticeOrigen, vertice) && grafo.existeArista(vertice, verticeDestino)); // Lineal
		} //--> Lineal

}
