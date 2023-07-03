package tda;

public interface ColaPrioridadDTDA {
	
	void inicializarColaPrioridad();
	void acolarPrioridad(int x, int prioridad); // Cola Prioridad inicializada
	void desacolar(); // Cola prioridad inicializada y no vacía
	int primero(); // Cola prioridad inicializada y no vacía
	int prioridad(); // Cola prioridad inicializada y no vacía
	boolean colaPrioridadVacia(); // Cola prioridad inicializada

}
