package impl;

import tda.ConjuntoDTDA;
import tda.DiccionarioPromedioTDA;

public class DiccionarioPromedio implements DiccionarioPromedioTDA {

	class NodoClavePromedio{
		int valor;
		int clave;
		float valorPromedio;
		float elementosAgregados;
		NodoClavePromedio sigClave;
	}
	
	NodoClavePromedio origen;
	
	@Override
	public void inicializarDiccionario() {
		origen = null;
	}

	private NodoClavePromedio clave2NodoClave (int clave) {
		
		NodoClavePromedio aux = origen;
		
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		
		return aux;
		
	}
	
	@Override
	public void agregar(int clave, int valor) {
		
		NodoClavePromedio nodo = clave2NodoClave (clave);
		
		if (nodo == null) {
			
			nodo = new NodoClavePromedio();
			
			nodo.clave = clave;
			nodo.sigClave = origen;
			origen = nodo;
			
		}else {
			nodo.valorPromedio += valor;
			nodo.elementosAgregados ++;
		}
		
		nodo.valor = valor;
		

	}

	@Override
	public void eliminar(int clave) {
		
		if (origen != null) {
			
			if (origen.clave == clave) {
				
				origen = origen.sigClave;
				
			}else {
				
				NodoClavePromedio aux = origen;
				
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
	public float recuperarPromedio(int clave) {
		
		NodoClavePromedio nodo = clave2NodoClave(clave);
		
		float promedio = nodo.valorPromedio / nodo.elementosAgregados;
		
		
		return promedio;
	}

	@Override
	public ConjuntoDTDA claves() {
		// TODO Auto-generated method stub
		return null;
	}

}
