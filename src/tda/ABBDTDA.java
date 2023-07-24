package tda;

public interface ABBDTDA {
	
	void inicializarArbol();
	void agregarElem(int x); // Arbol inicializado
	void eliminarElem(int x); // Arbol inicializado
	int raiz(); // Arbol inicializado y no vacío
	ABBDTDA hijoIzq(); // Arbol inicializado y no vacío
	ABBDTDA hijoDer(); // Arbol inicializado y no vacío
	boolean arbolVacio(); // Arbol inicializado

}
