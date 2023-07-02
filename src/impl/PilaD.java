package impl;

import tda.PilaEDTDA;

public class PilaD implements PilaEDTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo origen;
	
	@Override
	public void inicializarPila() {
		origen = null;
	}

	@Override
	public void apilar(int x) {
		Nodo aux = new Nodo();
		
		aux.info = x;
		aux.sig = origen;
		origen = aux;

	}

	@Override
	public void desapilar() {
		origen = origen.sig;

	}

	@Override
	public int tope() {
		return origen.info;
	}

	@Override
	public boolean pilaVacia() {
		return (origen == null);
	}

}
