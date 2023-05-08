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
	
	public static DiccionarioMultipleTDA colaPrioridadADicMulti(ColaPrioridadTDA colaPrioridad) {
		DiccionarioMultipleTDA dicMultiple = new DiccionarioMultipleSt();
		dicMultiple.inicializarDiccionario();
		while (!colaPrioridad.colaVacia()) {
			int valor = colaPrioridad.primero();
			int prioridad = colaPrioridad.prioridad();
			dicMultiple.agregar(valor, prioridad);
			colaPrioridad.desacolar();
		}
		
		return dicMultiple;
	}
	
	public static ColaPrioridadTDA clavesOrdenadas(DiccionarioMultipleTDA dicMulti) { // Costo polinómico
		ColaPrioridadTDA clavesOrdenadas = new ColaPrioridadSt(); // Constante
		clavesOrdenadas.inicializarColaPrioridad(); // Constante
		ConjuntoTDA claves = dicMulti.claves(); // Polinómico
		while (!claves.conjuntoVacio()) {
			int valor = claves.elegir();
			clavesOrdenadas.acolarPrioridad(valor, valor);
			claves.sacar(valor);
		}
		return clavesOrdenadas;
	}
	
}
