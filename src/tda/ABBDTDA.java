package tda;

public interface ABBDTDA {
	
	void inicializarArbol();
	void agregarElem(int x); // Arbol inicializado
	void eliminarElem(int x); // Arbol inicializado
	int raiz(); // Arbol inicializado y no vac�o
	ABBDTDA hijoIzq(); // Arbol inicializado y no vac�o
	ABBDTDA hijoDer(); // Arbol inicializado y no vac�o
	boolean arbolVacio(); // Arbol inicializado

}
