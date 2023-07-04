package user;

import impl.ConjuntoD;
import impl.DiccionarioMultipleD;
import impl.DiccionarioSimpleD;
import impl.PilaD;
import tda.DiccionarioSimpleDTDA;
import tda.ConjuntoDTDA;
import tda.PilaDTDA;
import tda.DiccionarioMultipleDTDA;

public class PasarDiccionarioSimple {
	
	public static void aPilaValores (DiccionarioSimpleDTDA d) {
		
		DiccionarioSimpleDTDA aux = new DiccionarioSimpleD();
		aux.inicializarDiccionario();
		
		aux = d;
		
		PilaDTDA valores = new PilaD();
		valores.inicializarPila();	
		
		ConjuntoDTDA claves = new ConjuntoD();
		claves.inicializarConjunto();
		
		claves = aux.claves();
		
		while (!claves.conjuntoVacio()) {
			
			int g = claves.elegir();
			valores.apilar(aux.recuperar(g));
			claves.sacar(g);

		}
		
		
	}
	
	public static void aDiccionarioMultiple (DiccionarioSimpleDTDA d) {
		
		DiccionarioSimpleDTDA aux = new DiccionarioSimpleD();
		aux.inicializarDiccionario();
		
		aux = d;
		
		DiccionarioMultipleDTDA dM = new DiccionarioMultipleD();
		dM.inicializarDiccionarioMultiple();
		
		ConjuntoDTDA claves = new ConjuntoD();
		claves.inicializarConjunto();
		
		claves = aux.claves();
		
		while (!claves.conjuntoVacio()) {
			
			int g = claves.elegir();
			dM.agregar(g, aux.recuperar(g));
			claves.sacar(g);
			
		}
		
	}

}
