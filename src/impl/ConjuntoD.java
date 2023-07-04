package impl;

import tda.ConjuntoDTDA;

public class ConjuntoD implements ConjuntoDTDA {
	
	class Nodo {
		int info;
		Nodo sig;
	}
	
	Nodo c;

	@Override
	public void inicializarConjunto() {
		c = null;
	}

	@Override
	public int elegir() {
		return c.info;
	}

	@Override
	public void agregar(int x) {
		
		if(!this.pertenece(x)) { // verificamos que el valor no pertenezca al conjunto
			
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = c;
			c = aux;
		}

	}

	@Override
	public void sacar(int x) {
		
		if (c != null) { 
			
			if(c.info == x) { // Validamos si es el primer elemento del conjunto
				c = c.sig;
			}else {
				Nodo aux = c;
				
				while(aux.sig != null && aux.sig.info != x) {
					aux = aux.sig;
				}
				
				if(aux.sig != null) {
					aux.sig = aux.sig.sig;
					
				}
				
			}
			
			
		}

	}

	@Override
	public boolean pertenece(int x) {
		
		Nodo aux = c;
		
		while ((aux != null) && (aux.info != x)) {
			aux = aux.sig;
		}
		
		return (aux != null);
	}

	@Override
	public boolean conjuntoVacio() {
		return (c == null);
	}

}
