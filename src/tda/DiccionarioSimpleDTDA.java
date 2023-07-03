package tda;

public interface DiccionarioSimpleDTDA {
	
	void inicializarDiccionario();
	void agregar(int clave, int valor);  // Diccionario inicializado
	void eliminar (int clave); // Diccionario inicializado
	int recuperar (int clave); // Diccionario inicializado y clave existente
	ConjuntoDTDA claves(); // Diccionario inicializado

}
