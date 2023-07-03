package tda;

public interface DiccionarioMultipleDTDA {
	
	void inicializarDiccionarioMultiple();
	void agregar(int clave, int valor); // Diccionario multiple inicializado
	void eliminar (int clave); // Diccionario multiple inicializado
	void eliminarValor (int clave, int valor); // Diccionario multiple inicializado
	ConjuntoDTDA recuperar (int clave); // Diccionario multiple inicializado
	ConjuntoDTDA claves(); // Diccionario multiple inicializado

}
