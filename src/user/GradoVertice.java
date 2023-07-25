package user;

import impl.ConjuntoD;
import tda.ConjuntoDTDA;
import tda.GrafoDTDA;

public class GradoVertice {
	
	/**
	 * @estrategia Para la realización del ejercicio, se requiere de la realización de 4 métodos auxiliares. El primero, se encargará de retornar un booleano indicando si existe el vertice recibido como parámetro en el grafo indicado, se utilizará como validación para calcular el grado, en caso de que exista, se obtendrán los conjuntos de salidas y entradas adyacentes a través de 2 métodos auxiliares y para finalmente calcular el grado, a través de un cuarto método auxiliar, se obtendrán los tamaños (cantidad de elementos del conjunto) y se restarán salidas menos entradas tal como se solicita, retornando finalmente el grado.
	 * @tarea Calcular el grado de un vertice de un grafo y retornar dicho valor entero.
	 * @parámetros grafo: Grafo recibido el cual pertenece el vertice a calcular su grado. vertice: Vertice recibido a calcular su grado.
	 * @devuelve grado: Valor entero que representa el grado del vertice.
	 * @precondiciones: Grafo inicializado y no vacío.
	 * @postcondiciones Se retorna el valor entero.
	 * @costo Polinomico
	 */
	
//	Dado un Grafo G y un vértice v, calcular el grado de v.
//	Se define el grado de un vértice v como el entero que es igual a la resta entre la cantidad de
//	aristas que salen de v menos la cantidad de aristas que llegan a v.
	
	public static int calcularGradoVertice(GrafoDTDA grafo, int vertice) {
	    
		int grado = 0;
	    
	    if (existeVertice(grafo, vertice)) { // Polinomico (Ya que el método existeVertice tiene costo Polinomico, se asume ya que es el peor costo asumible en el método)
	        
	    	ConjuntoDTDA adyacentesSalida = new ConjuntoD();
	    	adyacentesSalida.inicializarConjunto();
	    	
	    	adyacentesSalida = adyacentesSalida(grafo, vertice);
	    	
	        ConjuntoDTDA adyacentesEntrada = new ConjuntoD();
	        adyacentesEntrada.inicializarConjunto();
	        
	        adyacentesEntrada = adyacentesEntrada(grafo, vertice);
	        
	        grado = tamañoConjunto(adyacentesSalida) - tamañoConjunto(adyacentesEntrada);
	    }
	    
	    return grado;
	}

	/**
	 * @estrategia Para la realización del siguiente método auxiliar, se inicializará un conjunto el cual contendrá los vertices adyacentes de salida, luego se validará si el vertice existe en el grafo recibido y se recorrerá el conjunto de vertices validando si existe una arista entre el vertice recibido y el conjunto de vertices del grafo, en caso afirmativo, se añadirá al conjunto adyacentes. Se retornará dicho conjunto.
	 * @tarea Crear un conjunto con los vertices adyacentes de salida segun el grafo y vertice recibido.
	 * @parámetros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve adyacentes: Conjunto generado que almacenará los vértices adyacentes de salida segun el grafo y vertice recibido.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el conjunto de vertices.
	 * @costo Polinómico
	 */
	
	public static ConjuntoDTDA adyacentesSalida(GrafoDTDA grafo, int vertice) {
	    
		ConjuntoDTDA adyacentes = new ConjuntoD();// Conjunto que almacenar los vértices adyacentes de salida
	    adyacentes.inicializarConjunto();
		
	    if (existeVertice(grafo, vertice)) { // Polinómico (Se asume dicho costo ya que es el peor costo asumible por el método)
	        
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
	 * @estrategia Para la realización del siguiente método auxiliar, se inicializará un conjunto el cual contendrá los vertices adyacentes de entrada, luego se validará si el vertice existe en el grafo recibido y se recorrerá el conjunto de vertices validando si existe una arista entre el vertice recibido y el conjunto de vertices del grafo, en caso afirmativo, se añadirá al conjunto adyacentes. Se retornará dicho conjunto.
	 * @tarea Crear un conjunto con los vertices adyacentes de entrada segun el grafo y vertice recibido.
	 * @parámetros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve adyacentes: Conjunto generado que almacenará los vértices adyacentes de entrada segun el grafo y vertice recibido.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el conjunto de vertices.
	 * @costo Polinómico
	 */

	public static ConjuntoDTDA adyacentesEntrada(GrafoDTDA grafo, int vertice) {
	    
		ConjuntoDTDA adyacentes = new ConjuntoD();// Conjunto que almacena los vértices adyacentes de entrada
		adyacentes.inicializarConjunto();
	    
	    if (existeVertice(grafo, vertice)) {// Polinomico (Se asume dicho costo ya que es el peor costo que podemos asumir en el método)
	        
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
	 * @estrategia Para la realización de este método auxiliar, se inicializará un nuevo conjunto el cual contendrá los vertices del grafo recibido, se utilizará el conjunto como validación mientras este no esté vacío para recorrer el conjunto y validar si el vertice recibido se encuentra en dicho conjunto.
	 * @tarea Validar si existe el vertice recibido en el grafo recibido.
	 * @parámetros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
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
	 * @estrategia Se recibe un conjunto, el cual es igualado a un aux para no modificar la estructura recibida como parámetro, y se recorrerá el conjunto sacando elementos y a su vez, se sumará un contador por cada elemento retirado. Finalmente, se retornará el contador.
	 * @tarea Calcular la cantidad de elementos que posee un conjunto.
	 * @parámetros c: Conjunto recibido a calcular.
	 * @devuelve contador: Cantidad de elementos del conjunto.
	 * @precondiciones: Conjunto inicializado.
	 * @postcondiciones Se retorna el entero solicitado.
	 * @costo Polinomico
	 */
	
	public static int tamañoConjunto(ConjuntoDTDA c) {
		
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
