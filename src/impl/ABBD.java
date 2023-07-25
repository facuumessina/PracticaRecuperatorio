package impl;

import tda.ABBDTDA;

public class ABBD implements ABBDTDA {

	public class NodoABB{
		int info;
		ABBDTDA hijoIzq;
		ABBDTDA hijoDer;
	}
	
	NodoABB raiz;
	
	
	@Override
	public void inicializarArbol() {
		raiz = null;

	}

	@Override
	public void agregarElem(int x) {
		if (raiz == null) { // Caso de arbol vacio
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoIzq = new ABBD();
			raiz.hijoIzq.inicializarArbol();
			raiz.hijoDer = new ABBD();
			raiz.hijoDer.inicializarArbol();
		} else if(raiz.info > x){
			raiz.hijoIzq.agregarElem(x);
		} else if (raiz.info < x) {
			raiz.hijoDer.agregarElem(x);
		}

	}

	@Override
	public void eliminarElem(int x) {
		if (raiz != null) { // verificación de arbol no vacío
			if (raiz.info == x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()) {
				raiz = null;
			} else if (raiz.info == x && !raiz.hijoIzq.arbolVacio()) {
				raiz.info = mayor(raiz.hijoIzq); // Reemplazamos con el mayor de los menores
				raiz.hijoIzq.eliminarElem(raiz.info);
			} else if (raiz.info == x && raiz.hijoIzq.arbolVacio()) {
				raiz.info = menor(raiz.hijoDer); // Reemplazamos con el menor de los mayores
				raiz.hijoDer.eliminarElem(raiz.info);
			} else if (raiz.info < x) { // Seguimos buscando por los mayores (Derecha)
				raiz.hijoDer.eliminarElem(x);
			} else {
				raiz.hijoIzq.eliminarElem(x); // Seguimos buscando por los menores (Izquierda)
			}
		}

	}
	
	private int mayor (ABBDTDA a) {
		if (a.hijoDer().arbolVacio()) {
			return a.raiz();
		}else {
			return mayor(a.hijoDer());
		}
	}
	
	private int menor(ABBDTDA a) {
		if (a.hijoIzq().arbolVacio()) {
			return a.raiz();
		}else {
			return menor (a.hijoIzq());
		}
	}

	@Override
	public int raiz() {
		return raiz.info;
	}

	@Override
	public ABBDTDA hijoIzq() {
		return raiz.hijoIzq;
	}

	@Override
	public ABBDTDA hijoDer() {
		return raiz.hijoDer;
	}

	@Override
	public boolean arbolVacio() {
		return (raiz == null);
	}

}
