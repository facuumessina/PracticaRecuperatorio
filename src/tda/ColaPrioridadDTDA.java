package tda;

public interface ColaPrioridadDTDA {
	
	void inicializarColaPrioridad();
	void acolarPrioridad(int x, int prioridad); // Cola Prioridad inicializada
	void desacolar(); // Cola prioridad inicializada y no vac�a
	int primero(); // Cola prioridad inicializada y no vac�a
	int prioridad(); // Cola prioridad inicializada y no vac�a
	boolean colaPrioridadVacia(); // Cola prioridad inicializada

}
