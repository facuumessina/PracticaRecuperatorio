package impl;

import tda.ColaPrioridadDTDA;

public class ColaPrioridadD implements ColaPrioridadDTDA {

	class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	
	@Override
	public void inicializarColaPrioridad() {
		mayorPrioridad = null;

	}

	@Override
	public void acolarPrioridad(int x, int prioridad) {
		 
		NodoPrioridad aux = new NodoPrioridad();
		
		aux.prioridad = prioridad;
		aux.info = x; // Nodo a acolar creado
		
		if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) { // Si la cola está vacía o el nuevo nodo tiene mayor prioridad al primero, se acola al inicio
			
			aux.sig = mayorPrioridad;
			mayorPrioridad = aux;
		}else { // sabemos que la cola no está vacía
			
			NodoPrioridad aux2 = mayorPrioridad;
			
			while (aux2.sig != null && aux.sig.prioridad >= prioridad) {
				aux2 = aux2.sig;
			}
			
			aux.sig = aux2.sig;
			
			aux2 = aux;
			
		}
		
		

	}

	@Override
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;

	}

	@Override
	public int primero() {
		return mayorPrioridad.info;
	}

	@Override
	public int prioridad() {
		return mayorPrioridad.prioridad;
	}

	@Override
	public boolean colaPrioridadVacia() {
		return (mayorPrioridad == null);
	}

}
