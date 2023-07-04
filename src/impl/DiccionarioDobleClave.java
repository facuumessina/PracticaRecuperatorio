package impl;

import tda.ConjuntoDTDA;
import tda.DiccionarioDobleClaveTDA;

public class DiccionarioDobleClave implements DiccionarioDobleClaveTDA {

	class NodoDobleClave{
		int valor;
		int clavePrincipal;
		int claveSecundaria;
		NodoDobleClave sig;
	}
	
	NodoDobleClave origen;
	
	@Override
	public void inicializarDiccionario() {
		origen = null;

	}
	
	private NodoDobleClave clave2NodoDobleClave (int clavePrincipal) {
		
		NodoDobleClave aux = origen;
		
		while (aux != null && aux.clavePrincipal != clavePrincipal) {
			aux = aux.sig;
		}
		
		return aux;
		
	}

	@Override
	public void agregar(int clavePrincipal, int claveSecundaria, int valor) {
		
		NodoDobleClave nodo = clave2NodoDobleClave(clavePrincipal);
		
		if (nodo != null) {
			
			if (nodo.claveSecundaria == claveSecundaria) {
				
				nodo.valor = valor;
				
			}
			
		}else {
			
			NodoDobleClave nuevo = new NodoDobleClave();
			
			nuevo.clavePrincipal = clavePrincipal;
			nuevo.claveSecundaria = claveSecundaria;
			nuevo.sig = origen;
			origen = nuevo;
			
			nuevo.valor = valor;
			
		}

	}

	@Override
	public void eliminar(int clavePrincipal, int claveSecundaria) {
		
		if (origen != null) {
			
			if (origen.clavePrincipal == clavePrincipal && origen.claveSecundaria == claveSecundaria) {
				
				origen = origen.sig;
				
			}else {
				
				NodoDobleClave aux = origen;
				
				while (aux.sig != null && aux.sig.clavePrincipal != clavePrincipal && aux.sig.claveSecundaria != claveSecundaria) {
					aux = aux.sig;
				}
				
				if (aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
				
			}
			
			
		}

	}

	@Override
	public int recuperar(int clavePrincipal, int claveSecundaria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int recuperarClaveSecundaria(int clavePrincipal) {
		
		NodoDobleClave nodo = clave2NodoDobleClave(clavePrincipal);
		
		return nodo.claveSecundaria;
	}

	@Override
	public ConjuntoDTDA claves() {
		
		
		
		return null;
	}

}
