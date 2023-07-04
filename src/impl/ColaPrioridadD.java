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
		 
		NodoPrioridad nuevo = new NodoPrioridad();
		
		nuevo.info = x; // Nodo a acolar creado
		nuevo.prioridad = prioridad;
		
		if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) { // Si la cola está vacía o el nuevo nodo tiene mayor prioridad al primero, se acola al inicio
			
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
			
		}else { // sabemos que la cola no está vacía
			
			NodoPrioridad aux = mayorPrioridad;
			
			while (aux.sig != null && aux.sig.prioridad >= prioridad) {
				aux = aux.sig;
			}
			
			nuevo.sig = aux.sig;
			
			aux.sig = nuevo;
			
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
