package tda;

public interface DiccionarioDobleClaveTDA {
	
	void inicializarDiccionario();
	void agregar (int clavePrincipal, int claveSecundaria, int valor); // Agrega un nuevo elemento. Si la clave principal existe, y coincide con la clave secundaria, se sobrescribe el valor. Si la clave principal existe pero no coincide con la secundaria, no se realiza ninguna acción.
	void eliminar (int clavePrincipal, int claveSecundaria); // Elimina un elemento, de no coincidir ambas claves, no se realiza nada
	int recuperar (int clavePrincipal, int claveSecundaria); // Recupera el valor asociado a ambas claves. Si la clave principal no existe o no coincide con la secundaria, se retorna la clave secundaria.
	int recuperarClaveSecundaria (int clavePrincipal); // Devuelve la clave secundaria a partir de la clave principal que se presupone que existe
	ConjuntoDTDA claves(); // devuelve el conjunto de claves principales

}
