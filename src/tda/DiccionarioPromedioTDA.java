package tda;

public interface DiccionarioPromedioTDA {
	
	void inicializarDiccionario();
	void agregar(int clave, int valor); // Al agregar una clave ya existente, se registra el valor para luego poder recuperar el promedio de valores
	void eliminar (int clave);
	float recuperarPromedio (int clave); // Devuelve un entero que representa el promedio de los valores agregados para dicha clave
	ConjuntoDTDA claves();
	

}
