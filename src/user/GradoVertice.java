package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;
import tda.GrafoDTDA;

public class GradoVertice {
	
	/**
	 * @estrategia Para la realizaci�n del ejercicio, se requiere de la realizaci�n de 4 m�todos auxiliares. El primero, se encargar� de retornar un booleano indicando si existe el vertice recibido como par�metro en el grafo indicado, se utilizar� como validaci�n para calcular el grado, en caso de que exista, se obtendr�n los conjuntos de salidas y entradas adyacentes a trav�s de 2 m�todos auxiliares y para finalmente calcular el grado, a trav�s de un cuarto m�todo auxiliar, se obtendr�n los tama�os (cantidad de elementos del conjunto) y se restar�n salidas menos entradas tal como se solicita, retornando finalmente el grado.
	 * @tarea Calcular el grado de un vertice de un grafo y retornar dicho valor entero.
	 * @par�metros grafo: Grafo recibido el cual pertenece el vertice a calcular su grado. vertice: Vertice recibido a calcular su grado.
	 * @devuelve grado: Valor entero que representa el grado del vertice.
	 * @precondiciones: Grafo inicializado y no vac�o.
	 * @postcondiciones Se retorna el valor entero.
	 * @costo Polinomico
	 */
	
//	Dado un Grafo G y un v�rtice v, calcular el grado de v.
//	Se define el grado de un v�rtice v como el entero que es igual a la resta entre la cantidad de
//	aristas que salen de v menos la cantidad de aristas que llegan a v.
	
	public static int calcularGradoVertice(GrafoDTDA grafo, int vertice) {
	    
		int grado = 0;
	    
	    if (existeVertice(grafo, vertice)) { // Polinomico (Ya que el m�todo existeVertice tiene costo Polinomico, se asume ya que es el peor costo asumible en el m�todo)
	        
	    	ConjuntoDTDA adyacentesSalida = new ConjuntoD();
	    	adyacentesSalida.inicializarConjunto();
	    	
	    	adyacentesSalida = adyacentesSalida(grafo, vertice);
	    	
	        ConjuntoDTDA adyacentesEntrada = new ConjuntoD();
	        adyacentesEntrada.inicializarConjunto();
	        
	        adyacentesEntrada = adyacentesEntrada(grafo, vertice);
	        
	        grado = tama�oConjunto(adyacentesSalida) - tama�oConjunto(adyacentesEntrada);
	    }
	    
	    return grado;
	}

	/**
	 * @estrategia Para la realizaci�n del siguiente m�todo auxiliar, se inicializar� un conjunto el cual contendr� los vertices adyacentes de salida, luego se validar� si el vertice existe en el grafo recibido y se recorrer� el conjunto de vertices validando si existe una arista entre el vertice recibido y el conjunto de vertices del grafo, en caso afirmativo, se a�adir� al conjunto adyacentes. Se retornar� dicho conjunto.
	 * @tarea Crear un conjunto con los vertices adyacentes de salida segun el grafo y vertice recibido.
	 * @par�metros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve adyacentes: Conjunto generado que almacenar� los v�rtices adyacentes de salida segun el grafo y vertice recibido.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el conjunto de vertices.
	 * @costo Polin�mico
	 */
	
	public static ConjuntoDTDA adyacentesSalida(GrafoDTDA grafo, int vertice) {
	    
		ConjuntoDTDA adyacentes = new ConjuntoD();// Conjunto que almacenar los v�rtices adyacentes de salida
	    adyacentes.inicializarConjunto();
		
	    if (existeVertice(grafo, vertice)) { // Polin�mico (Se asume dicho costo ya que es el peor costo asumible por el m�todo)
	        
	    	ConjuntoDTDA vertices = new ConjuntoD();
	    	vertices.inicializarConjunto();
	        
	        vertices = grafo.vertices();
	        
	        while (!vertices.conjuntoVacio()) {
	            int verticeActual = vertices.elegir();
	            
	            if (grafo.existeArista(vertice, verticeActual)) {
	                adyacentes.agregar(verticeActual);
	            }
	            
	            vertices.sacar(verticeActual);
	        }
	    }
	    
	    return adyacentes;
	}
	
	/**
	 * @estrategia Para la realizaci�n del siguiente m�todo auxiliar, se inicializar� un conjunto el cual contendr� los vertices adyacentes de entrada, luego se validar� si el vertice existe en el grafo recibido y se recorrer� el conjunto de vertices validando si existe una arista entre el vertice recibido y el conjunto de vertices del grafo, en caso afirmativo, se a�adir� al conjunto adyacentes. Se retornar� dicho conjunto.
	 * @tarea Crear un conjunto con los vertices adyacentes de entrada segun el grafo y vertice recibido.
	 * @par�metros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve adyacentes: Conjunto generado que almacenar� los v�rtices adyacentes de entrada segun el grafo y vertice recibido.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el conjunto de vertices.
	 * @costo Polin�mico
	 */

	public static ConjuntoDTDA adyacentesEntrada(GrafoDTDA grafo, int vertice) {
	    
		ConjuntoDTDA adyacentes = new ConjuntoD();// Conjunto que almacena los v�rtices adyacentes de entrada
		adyacentes.inicializarConjunto();
	    
	    if (existeVertice(grafo, vertice)) {// Polinomico (Se asume dicho costo ya que es el peor costo que podemos asumir en el m�todo)
	        
	    	ConjuntoDTDA vertices = new ConjuntoD();
	        vertices.inicializarConjunto();
	        
	        vertices = grafo.vertices();
	        
	        while (!vertices.conjuntoVacio()) {
	            int verticeActual = vertices.elegir();
	            
	            if (grafo.existeArista(verticeActual, vertice)) {
	                adyacentes.agregar(verticeActual);
	            }
	            
	            vertices.sacar(verticeActual);
	        }
	    }
	    
	    return adyacentes;
	}
	
	/**
	 * @estrategia Para la realizaci�n de este m�todo auxiliar, se inicializar� un nuevo conjunto el cual contendr� los vertices del grafo recibido, se utilizar� el conjunto como validaci�n mientras este no est� vac�o para recorrer el conjunto y validar si el vertice recibido se encuentra en dicho conjunto.
	 * @tarea Validar si existe el vertice recibido en el grafo recibido.
	 * @par�metros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve boolean: retorna true si se encuentra el vertice en el conjunto de vertices, de lo contrario, false.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el booleano solicitado.
	 * @costo Polinomico
	 */
	
	public static boolean existeVertice(GrafoDTDA grafo, int vertice) {
	    
		ConjuntoDTDA vertices = new ConjuntoD();
		vertices.inicializarConjunto();
		
		vertices = grafo.vertices();
	    
	    while (!vertices.conjuntoVacio()) {// Constante
	        int verticeActual = vertices.elegir(); // Constante
	        vertices.sacar(verticeActual); // Lineal
	        
	        if (verticeActual == vertice) { // Constante
	            return true;
	        }
	    }// --> Polinomico
	    
	    return false;
	}
	
	/**
	 * @estrategia Se recibe un conjunto, el cual es igualado a un aux para no modificar la estructura recibida como par�metro, y se recorrer� el conjunto sacando elementos y a su vez, se sumar� un contador por cada elemento retirado. Finalmente, se retornar� el contador.
	 * @tarea Calcular la cantidad de elementos que posee un conjunto.
	 * @par�metros c: Conjunto recibido a calcular.
	 * @devuelve contador: Cantidad de elementos del conjunto.
	 * @precondiciones: Conjunto inicializado.
	 * @postcondiciones Se retorna el entero solicitado.
	 * @costo Polinomico
	 */
	
	public static int tama�oConjunto(ConjuntoDTDA c) {
		
		int contador = 0;
		
		ConjuntoDTDA aux = new ConjuntoD();
		aux.inicializarConjunto();
		
		aux = c;
		
		while (!aux.conjuntoVacio()) {// Constante
	        	aux.sacar(aux.elegir()); // Lineal
	        	contador++;
	    }// --> Polinomico
		
		return contador;
		
	}

}
