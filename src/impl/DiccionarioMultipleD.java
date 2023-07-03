package impl;

import tda.ConjuntoDTDA;
import tda.DiccionarioMultipleDTDA;

public class DiccionarioMultipleD implements DiccionarioMultipleDTDA {

	class NodoClave{
		int clave;
		NodoClave sigClave;
		NodoValor valores;
	}
	
	class NodoValor{
		int valor;
		NodoValor sigValor;
	}
	
	NodoClave origen;
	
	@Override
	public void inicializarDiccionarioMultiple() {
		origen = null;
	}

	private NodoClave clave2NodoClave (int clave) {
		
		NodoClave aux = origen;
		
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		
		return aux;
	}
	
	@Override
	public void agregar(int clave, int valor) {
		
		NodoClave nc = clave2NodoClave(clave);
		
		if (nc == null) {
			nc = new NodoClave(); // Se crea el nodo en el diccionario Multiple
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		
		NodoValor aux = nc.valores;
		
		while(aux != null && aux.valor != valor) {
			aux = aux.sigValor;
		}
		
		if (aux == null) {
			NodoValor nuevoNodoValor = new NodoValor();
			nuevoNodoValor.valor = valor;
			nuevoNodoValor.sigValor = nc.valores;
			nc.valores = nuevoNodoValor;
		}

	}

	private void eliminarValorEnNodo(NodoClave nodo, int valor) {
		
		if(nodo.valores != null) {
			
			if (nodo.valores.valor == valor) {
				nodo.valores = nodo.valores.sigValor;
			}else {
				NodoValor aux = nodo.valores;
				
				while(aux.sigValor != null && aux.sigValor.valor != valor) {
					aux = aux.sigValor;
				}
				
				if(aux.sigValor != null) {
					aux.sigValor = aux.sigValor.sigValor;
				}
			}
		}
	}
	
	@Override
	public void eliminar(int clave) {
		
		if(origen != null) {
			
			if(origen.clave == clave) {
				origen = origen.sigClave;
			}else {
				NodoClave aux = origen;
				
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
			
			
		}

	}

	@Override
	public void eliminarValor(int clave, int valor) {
		if(origen != null) {
			
			if(origen.clave == clave) {
				eliminarValorEnNodo(origen,valor);
				
				if(origen.valores == null) {
					origen = origen.sigClave;
				}
			}else {
				NodoClave aux = origen;
				
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				
				if (aux.sigClave != null) {
					eliminarValorEnNodo(aux.sigClave, valor);
					if(aux.sigClave.valores == null) {
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}

	}

	@Override
	public ConjuntoDTDA recuperar(int clave) {
		
		NodoClave n = clave2NodoClave(clave);
		
		ConjuntoDTDA c = new ConjuntoD();
		c.inicializarConjunto();
		
		if(n != null) {
			NodoValor aux = n.valores;
			
			while (aux != null) {
				c.agregar(aux.valor);
				aux = aux.sigValor;
			}
		}
		
		return c;
	}

	@Override
	public ConjuntoDTDA claves() {
		
		ConjuntoDTDA c = new ConjuntoD();
		c.inicializarConjunto();
		
		NodoClave aux = origen;
		
		while (aux != null) {
		
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		
		return c;
	}

}
