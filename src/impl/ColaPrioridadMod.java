package impl;

import tda.ColaPrioridadModTDA;

public class ColaPrioridadMod implements ColaPrioridadModTDA {

	class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	
	@Override
	public void inicializarCola() {
		mayorPrioridad = null;
	}

	@Override
	public void acolarPrioridad(int x, int prioridad) {
		
		NodoPrioridad nuevo = new NodoPrioridad();
		
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		
		if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) { // Validamos si la cola esta vacía o el nuevo nodo tiene mayor prioridad que el primero, se acolará al principio
			
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
			
		}else { // La cola no está vacía, debemos recorrerla a través de un auxiliar
			
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
	public boolean colaVacía() {
		return (mayorPrioridad == null);
	}

	@Override
	public int sumaPrioridades() {
		
		int suma = 0;
		
		NodoPrioridad aux = mayorPrioridad;
		
		
		while (aux != null) {
			suma += aux.prioridad;
			aux = aux.sig;
		}
		
		return suma;
	}

}
