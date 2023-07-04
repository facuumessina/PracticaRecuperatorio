package user;

import impl.ColaPrioridadD;
import impl.ConjuntoD;
import tda.DiccionarioMultipleDTDA;
import tda.ColaPrioridadDTDA;
import tda.ConjuntoDTDA;

public class PasarDiccionarioMultiple {
	
	public static void clavesOrdenadas (DiccionarioMultipleDTDA dm) {
		
		ColaPrioridadDTDA cp = new ColaPrioridadD();
		cp.inicializarColaPrioridad();
		
		ConjuntoDTDA claves = new ConjuntoD();
		claves.inicializarConjunto();
		
		claves = dm.claves();
		
		while (!claves.conjuntoVacio()) {
			
			int g = claves.elegir();
			cp.acolarPrioridad(g, g);
			claves.sacar(g);
			
		}
		
		while (!cp.colaPrioridadVacia()) {
			System.out.println(cp.prioridad());
			cp.desacolar();
		}
		
	}

}
