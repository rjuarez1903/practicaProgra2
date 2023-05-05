package main;

import tda.*;
import metodosExternos.*;
import impl.*;

public class Main {

	public static void main(String[] args) {
		
// 		Pila
		
//		PilaTDA pila1 = new PilaSt();
//		pila1.inicializarPila();
//		
//		pila1.apilar(8);
//		pila1.apilar(1);
//		pila1.apilar(2);
//		pila1.apilar(3);
//		pila1.apilar(2);
//		pila1.apilar(2);
//		pila1.apilar(1);
//		pila1.apilar(4);
//		pila1.apilar(5);
//		pila1.apilar(4);	
		
//		Cola
		
//		ColaTDA cola1 = new ColaSt();
//		ColaTDA cola2 = new ColaSt();
//		cola1.inicializarCola();
//		cola2.inicializarCola();
//		
//		cola1.acolar(0);
//		cola1.acolar(4);
//		cola1.acolar(6);
//		cola1.acolar(0);
//		cola1.acolar(6);
//		cola1.acolar(8);
//		cola1.acolar(7);
//		cola1.acolar(10);
//		cola1.acolar(10);
//		
//		cola2.acolar(8);
//		cola2.acolar(6);
//		cola2.acolar(4);
//		cola2.acolar(0);
		
//		Cola Prioridad
		
//		ColaPrioridadTDA colaPrioridad1 = new ColaPrioridadSt();
//		ColaPrioridadTDA colaPrioridad2 = new ColaPrioridadSt();
//		
//		colaPrioridad1.inicializarColaPrioridad();
//		colaPrioridad2.inicializarColaPrioridad();
//		
//		colaPrioridad1.acolarPrioridad(2, 10);
//		colaPrioridad1.acolarPrioridad(5, 5);
//		colaPrioridad1.acolarPrioridad(1, 15);
//		colaPrioridad1.acolarPrioridad(7, 3);
//		colaPrioridad1.acolarPrioridad(3, 8);
//		
//		colaPrioridad2.acolarPrioridad(20, 5);
//		colaPrioridad2.acolarPrioridad(7, 3);
//		colaPrioridad2.acolarPrioridad(10, 1);
//		colaPrioridad2.acolarPrioridad(3, 7);
//		colaPrioridad2.acolarPrioridad(8, 4);
//		
//		ColaPrioridadTDA combinadas = MetodosColaPrioridad.combinarColas(colaPrioridad1, colaPrioridad2);
//		MetodosColaPrioridad.imprimirColaPrioridad(combinadas);
		
//		Conjunto
		
		ConjuntoTDA conjunto = new ConjuntoSt();
		ConjuntoTDA conjunto2 = new ConjuntoSt();
		conjunto.inicializarConjunto();
		conjunto2.inicializarConjunto();
		
		conjunto.agregar(0);
		conjunto.agregar(1);
		conjunto.agregar(2);
		conjunto.agregar(3);
		conjunto.agregar(4);
		
		conjunto2.agregar(10);
		conjunto2.agregar(9);
		conjunto2.agregar(4);
		conjunto2.agregar(0);
		conjunto2.agregar(-1);
		conjunto2.agregar(1);
		
		ConjuntoTDA diferencia = MetodosConjunto.diferencia(conjunto, conjunto2);
		MetodosConjunto.imprimirConjunto(diferencia);
		
	}
	
	

}
