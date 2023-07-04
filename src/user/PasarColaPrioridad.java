package user;

import tda.ColaPrioridadDTDA;
import impl.ColaD;
import impl.ColaPrioridadD;
import tda.ColaDTDA;

public class PasarColaPrioridad {
	
	public static void AColas (ColaPrioridadDTDA origen) {
		
		ColaDTDA valores = new ColaD();
		valores.inicializarCola();
		
		ColaDTDA prioridades = new ColaD();
		prioridades.inicializarCola();
		
		ColaPrioridadDTDA aux = new ColaPrioridadD();
		aux.inicializarColaPrioridad();
		
		aux = origen;
		
		while (!aux.colaPrioridadVacia()) { // Se recorre aux asignando valor y prioridad a las colas creadas
			
			valores.acolar(aux.primero());
			prioridades.acolar(aux.prioridad());
			aux.desacolar();
			
		}
		
		
	}

}
