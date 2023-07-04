package impl;

import tda.ColaDTDA;

public class ColaD implements ColaDTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero; // primer elemento de la cola
	Nodo ultimo; // ultimo elemento agregado a la cola
	
	@Override
	public void inicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void acolar(int x) {
		Nodo aux = new Nodo();
		
		aux.info = x;
		aux.sig = null;
		
		if(ultimo != null) { // Si la cola no está vacía
			ultimo.sig = aux;
		}
		
		ultimo = aux;
		
		if (primero == null) { // Si la cola está vacía
			primero = ultimo;
		}

	}

	@Override
	public void desacolar() {
		
		primero = primero.sig;
		
		if(primero == null) { // Si la cola queda vacía
			ultimo = null;
		}
		
	}

	@Override
	public int primero() {
		return primero.info;
	}

	@Override
	public boolean colaVacia() {
		return (ultimo == null);
	}

}
