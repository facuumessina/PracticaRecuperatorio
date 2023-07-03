package tda;

public interface ConjuntoDTDA {
	
	void inicializarConjunto();
	int elegir(); // Conjunto inicializado y no vacío
	void agregar(int x); // Conjunto inicializado
	void sacar(int x); // Conjunto inicializado
	boolean pertenece(int x); // Conjunto inicializado
	boolean conjuntoVacio(); // Conjunto inicializado

}
