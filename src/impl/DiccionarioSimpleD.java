package impl;

import tda.ConjuntoDTDA;
import tda.DiccionarioSimpleDTDA;

public class DiccionarioSimpleD implements DiccionarioSimpleDTDA {

	class NodoClave{
		int clave;
		int valor;
		NodoClave sigClave;
	}

	NodoClave origen;
	
	@Override
	public void inicializarDiccionario() {
		origen = null;

	}
	
	private NodoClave clave2NodoClave(int clave) {
		
		NodoClave aux = origen;
		
		while(aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		
		return aux;
	}

	@Override
	public void agregar(int clave, int valor) {
		NodoClave nodoClave = clave2NodoClave(clave);
		
		if(nodoClave == null) {
			nodoClave = new NodoClave(); // Se añade al diccionario el nodo
			
			nodoClave.clave = clave;
			nodoClave.sigClave = origen;
			origen = nodoClave;
		}
		
		nodoClave.valor = valor;

	}

	@Override
	public void eliminar(int clave) {
		
		if (origen != null) {
			
			if(origen.clave == clave) {
				
				origen = origen.sigClave;
				
			}else {
				
				NodoClave aux = origen;
				
				while(aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				
				if(aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}

	}

	@Override
	public int recuperar(int clave) {
		NodoClave nodo = clave2NodoClave(clave);
		return nodo.valor;
	}

	@Override
	public ConjuntoDTDA claves() {
		ConjuntoDTDA c = new ConjuntoD();
		c.inicializarConjunto();
		
		NodoClave aux = origen;
		
		while(aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		
		return c;
	}

}
