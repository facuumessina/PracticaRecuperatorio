package user;

import impl.ConjuntoD;
import tda.ABBDTDA;
import tda.ConjuntoDTDA;

public class SumaImparABB {
	
	/**
	 * @estrategia Para la realización de este método, se inicializará un conjunto el cual contendrá a los nodos impares recibidos por el método auxiliar nodosImpares, se declararan dos variables enteras, los cuales una contendrá el elemento extraído del conjunto y la otra la suma de los elementos extraídos del conjunto. Se recorrerá el conjunto obtenido sacando y sumando los valores hasta obtener el total "sum" con todos los valores impares del ABB.
	 * @tarea Crear un metodo que retorne la suma de todos los elementos de valor impar del ABB.
	 * @parámetros a: ABB recibido para realizar el método.
	 * @devuelve sum: Suma de todos los nodos impares del ABB.
	 * @precondiciones: Arbol inicializado.
	 * @postcondiciones Se retorna el valor entero solicitado.
	 * @costo Polinomico
	 */
	
	public static int sumaImparABB(ABBDTDA a) {
		
		ConjuntoDTDA nodosIm = new ConjuntoD();
		nodosIm.inicializarConjunto();
		
		nodosIm = nodosImpares(a); // Polinomico --> se asume ya que es el peor costo asumible por el método
		
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
	 * @estrategia A través de la recursividad, se validará que los nodos del arbol (y sus respectivos sub-arboles) sean impares (resto distinto de 0), en ese caso, se añadirán al conjunto r a retornar. 
	 * @tarea Generar un conjunto el cual contenga todos los nodos impares del arbol.
	 * @parámetros a: ABB recibido para generar el conjunto.
	 * @devuelve r: Conjunto generado a partir de los nodos impares del ABB.
	 * @precondiciones: ABB inicializado.
	 * @postcondiciones Se retorna el conjunto solicitado.
	 * @costo Polinómico
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
			}// --> Polinómico (Ya que se debe a una iteración de un ciclo con operaciones que poseen costo lineal, se asume por ser el peor costo posible)
		
			while (!rD.conjuntoVacio()){
				
				int x = rD.elegir();
				r.agregar(x);
				rD.sacar(x);
		
			}
		
		}
		
		return r;
}

}
