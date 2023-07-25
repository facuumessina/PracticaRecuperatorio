package user;

import impl.ConjuntoD;
import tda.ABBDTDA;
import tda.ConjuntoDTDA;

public class SumaImparABB {
	
	/**
	 * @estrategia Para la realizaci�n de este m�todo, se inicializar� un conjunto el cual contendr� a los nodos impares recibidos por el m�todo auxiliar nodosImpares, se declararan dos variables enteras, los cuales una contendr� el elemento extra�do del conjunto y la otra la suma de los elementos extra�dos del conjunto. Se recorrer� el conjunto obtenido sacando y sumando los valores hasta obtener el total "sum" con todos los valores impares del ABB.
	 * @tarea Crear un metodo que retorne la suma de todos los elementos de valor impar del ABB.
	 * @par�metros a: ABB recibido para realizar el m�todo.
	 * @devuelve sum: Suma de todos los nodos impares del ABB.
	 * @precondiciones: Arbol inicializado.
	 * @postcondiciones Se retorna el valor entero solicitado.
	 * @costo Polinomico
	 */
	
	public static int sumaImparABB(ABBDTDA a) {
		
		ConjuntoDTDA nodosIm = new ConjuntoD();
		nodosIm.inicializarConjunto();
		
		nodosIm = nodosImpares(a); // Polinomico --> se asume ya que es el peor costo asumible por el m�todo
		
		int sum = 0;
		int g;
		
		while(!nodosIm.conjuntoVacio()) {
			
			g = nodosIm.elegir();
			sum += g;
			nodosIm.sacar(g);
		}
		
		return sum;
	}
	
	/**
	 * @estrategia A trav�s de la recursividad, se validar� que los nodos del arbol (y sus respectivos sub-arboles) sean impares (resto distinto de 0), en ese caso, se a�adir�n al conjunto r a retornar. 
	 * @tarea Generar un conjunto el cual contenga todos los nodos impares del arbol.
	 * @par�metros a: ABB recibido para generar el conjunto.
	 * @devuelve r: Conjunto generado a partir de los nodos impares del ABB.
	 * @precondiciones: ABB inicializado.
	 * @postcondiciones Se retorna el conjunto solicitado.
	 * @costo Polin�mico
	 */
	
	public static ConjuntoDTDA nodosImpares(ABBDTDA a){
		
		ConjuntoDTDA r = new ConjuntoD();
		r.inicializarConjunto();
		
		if (!a.arbolVacio()){// constante
			
			if (a.raiz() % 2 != 0){
				r.agregar(a.raiz());
			}
			
			ConjuntoDTDA rI = new ConjuntoD();
			rI.inicializarConjunto();
					
			rI = nodosImpares(a.hijoIzq());
		
			ConjuntoDTDA rD = new ConjuntoD();
			rD.inicializarConjunto();
					
			rD = nodosImpares(a.hijoDer());
		
			while (!rI.conjuntoVacio()){// constante
				
				int x = rI.elegir();
				r.agregar(x);
				rI.sacar(x);// lineal
			}// --> Polin�mico (Ya que se debe a una iteraci�n de un ciclo con operaciones que poseen costo lineal, se asume por ser el peor costo posible)
		
			while (!rD.conjuntoVacio()){
				
				int x = rD.elegir();
				r.agregar(x);
				rD.sacar(x);
		
			}
		
		}
		
		return r;
}

}
