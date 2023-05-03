package metodosExternos;

import tda.*;
import impl.*;

public class MetodosPila {

	public static void pasarPila(PilaTDA pila1, PilaTDA pila2) { // Costo lineal
		while(!pila1.pilaVacia()) {
			pila2.apilar(pila1.tope());
			pila1.desapilar();
		}
	}
	
	public static PilaTDA copiarPila(PilaTDA pila) { // Costo lineal
		PilaTDA pila1 = new PilaSt();
		PilaTDA pilaCopia = new PilaSt();
		pila1.inicializarPila();
		pilaCopia.inicializarPila();
		
		while(!pila.pilaVacia()) {
			pila1.apilar(pila.tope());
			pila.desapilar();
		}
		
		while (!pila1.pilaVacia()) {
			pilaCopia.apilar(pila1.tope());
			pila1.desapilar();
		}
		
		return pilaCopia;
	}
	
	public static void invertirPila(PilaTDA pila) { // Costo lineal
		PilaTDA copia = copiarPila(pila);
		while(!copia.pilaVacia()) {
			pila.apilar(copia.tope());
			copia.desapilar();
		}
	} 
	
	public static int contarPila(PilaTDA pila) { // Costo lineal
		int contador = 0;
		while (!pila.pilaVacia()) {
			contador++;
			pila.desapilar();
		}
		
		return contador;
	}
	
	public static int sumarPila(PilaTDA pila) { // Costo lineal
		int suma = 0;
		while (!pila.pilaVacia()) {
			suma += pila.tope();
			pila.desapilar();
		}
		
		return suma;
	}
	
	public static double promedioPila(PilaTDA pila) { // Costo lineal
		double promedio = 0;
		int contador = 0;
		while (!pila.pilaVacia()) {
			promedio += pila.tope();
			contador++;
			pila.desapilar();
		}
		return promedio / contador;
	}
	
	public static boolean pilaEsCapicua(PilaTDA pila) { // Costo lineal
		boolean capicua = true;
		PilaTDA pila1 = new PilaSt();
		PilaTDA pilaCopia = new PilaSt();
		ColaTDA cola = new ColaSt();
		pila1.inicializarPila();
		pilaCopia.inicializarPila();
		cola.inicializarCola(); 
		
		while (!pila.pilaVacia()) {
			pila1.apilar(pila.tope());
			cola.acolar(pila.tope());
			pila.desapilar();
		}
				
		while (capicua && !pila1.pilaVacia()) {
			if (cola.primero() != pila1.tope()) {
				capicua = false;
			}
			cola.desacolar();
			pila1.desapilar();
		}
		
		return capicua;
	}
	
	public static void eliminarRepetidos(PilaTDA pila) { // Costo polinómico
		DiccionarioSimple diccionario = new DiccionarioSimpleSt();
		ColaPrioridadTDA colaPrioridad = new ColaPrioridadSt();
		diccionario.inicializarDiccionario();
		colaPrioridad.inicializarColaPrioridad();
		int contador = 0;
		
		while (!pila.pilaVacia()) {
			diccionario.agregar(pila.tope(), contador);
			pila.desapilar();
			contador++;
		}
		
		ConjuntoTDA claves = diccionario.claves();
		
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			int valor = diccionario.recuperar(clave);
			colaPrioridad.acolarPrioridad(clave, valor);
			claves.sacar(clave);
			diccionario.eliminar(clave);
		}
		
		while (!colaPrioridad.colaVacia()) {
			pila.apilar(colaPrioridad.primero());
			colaPrioridad.desacolar();
		}
		
		invertirPila(pila);
		
	}
	
	public static ConjuntoTDA conjuntoDeRepetidos(PilaTDA pila) { // Costo lineal
		ConjuntoTDA conjunto = new ConjuntoSt();
		ConjuntoTDA conjuntoRep = new ConjuntoSt();
		conjunto.inicializarConjunto();
		conjuntoRep.inicializarConjunto();
		while (!pila.pilaVacia()) {
			if (conjunto.pertenece(pila.tope())) {
				conjuntoRep.agregar(pila.tope());
			} else {
				conjunto.agregar(pila.tope());
			}
			pila.desapilar();
		}
		return conjuntoRep;
	}
	
	public static PilaTDA[] separarEnMitades(PilaTDA pila) {
		PilaTDA[] arrPilas = new PilaTDA[2];
		ColaTDA cola = new ColaSt();
		PilaTDA m1 = new PilaSt();
		PilaTDA m2 = new PilaSt();
		cola.inicializarCola();
		m1.inicializarPila();
		m2.inicializarPila();
		int contador = 1;
		
		while (!pila.pilaVacia()) {
			cola.acolar(pila.tope());
			pila.desapilar();
			contador++;
		}
		
		for (int i = 1; i <= contador/2; i++) {
			m1.apilar(cola.primero());
			cola.desacolar();
		}
		
		for (int i = 1; i <= contador/2; i++) {
			m2.apilar(cola.primero());
			cola.desacolar();
		}
		
		arrPilas[0] = m1;
		arrPilas[1] = m2;
		
		return arrPilas;
	}
	
}
