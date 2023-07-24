package tda;

public interface GrafoDTDA {
	
	void inicializarGrafo();
	void agregarVertice (int v); // Grafo inicializado y nodo no existente
	void eliminarVertice (int v); // Grafo inicializado y nodo existente
	ConjuntoDTDA vertices (); // Grafo inicializado
	void agregarArista (int v1, int v2, int peso); // Grafo inicializado, arista no existente y existen ambos nodos
	void eliminarArista (int v1, int v2); // Grafo inicializado y arista existente
	boolean existeArista (int v1, int v2); // Grafo inicializado y ambos nodos existentes
	int pesoArista (int v1, int v2); // Grafo inicializado y arista existente
	
}
