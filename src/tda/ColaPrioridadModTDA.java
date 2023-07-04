package tda;

public interface ColaPrioridadModTDA {
	
	void inicializarCola();
	void acolarPrioridad(int x, int prioridad); // cola inicializada
	void desacolar(); // cola inicializada y no vacía
	int primero(); // cola inicializada y no vacía
	int prioridad(); // cola inicializada y no vacía
	boolean colaVacía(); // cola inicializada
	int sumaPrioridades(); // cola inicializada y no vacía

}
