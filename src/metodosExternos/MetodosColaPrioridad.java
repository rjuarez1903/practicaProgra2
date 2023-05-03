package metodosExternos;

import tda.*;
import impl.*;

public class MetodosColaPrioridad {
	
	public static void imprimirColaPrioridad(ColaPrioridadTDA colaPrioridad) {
		while (!colaPrioridad.colaVacia()) {
			System.out.println(colaPrioridad.primero());
			colaPrioridad.desacolar();
		}
	}
	
	public static ColaPrioridadTDA combinarColas(ColaPrioridadTDA colaPrioridad1, ColaPrioridadTDA colaPrioridad2) {
		ColaPrioridadTDA colasCombinadas = new ColaPrioridadSt();
		colasCombinadas.inicializarColaPrioridad();
		
		while (!colaPrioridad1.colaVacia()) {
			int valor = colaPrioridad1.primero();
			int prioridad = colaPrioridad1.prioridad();
			colasCombinadas.acolarPrioridad(valor, prioridad);
			colaPrioridad1.desacolar();
		}
		
		while (!colaPrioridad2.colaVacia()) {
			int valor = colaPrioridad2.primero();
			int prioridad = colaPrioridad2.prioridad();
			colasCombinadas.acolarPrioridad(valor, prioridad);
			colaPrioridad2.desacolar();
		}
		
		return colasCombinadas;
		
	}
	
}
