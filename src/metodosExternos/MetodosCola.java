package metodosExternos;

import tda.*;
import impl.*;

public class MetodosCola {
	
	public static void imprimirCola(ColaTDA cola) {
		while (!cola.colaVacia()) {
			System.out.println(cola.primero());
			cola.desacolar();
		}
	}
	
	public static ColaTDA pasarCola(ColaTDA cola) {
		ColaTDA cola1 = new ColaSt();
		cola1.inicializarCola();
		while (!cola.colaVacia()) {
			cola1.acolar(cola.primero());
			cola.desacolar();
		}
		return cola1;
	}
	
	
	public static ColaTDA invertirCola(ColaTDA cola) {
		ColaTDA cola1 = new ColaSt();
		PilaTDA pila1 = new PilaSt();
		cola1.inicializarCola();
		pila1.inicializarPila();
		
		while (!cola.colaVacia()) {
			pila1.apilar(cola.primero());
			cola.desacolar();
		}
		
		while (!pila1.pilaVacia()) {
			cola1.acolar(pila1.tope());
			pila1.desapilar();
		}
		
		return cola1;
	}
	
	public static void invertirColaSinAux(ColaTDA cola) {
        if (!cola.colaVacia()) {
			int primero = cola.primero();
			cola.desacolar();
			invertirColaSinAux(cola);
			cola.acolar(primero);
		}
	}
	
	public static boolean coincidenComienzoYFInal(ColaTDA cola1, ColaTDA cola2) {
		PilaTDA pila = new PilaSt();
		pila.inicializarPila();
		
		while (!cola2.colaVacia()) {
			pila.apilar(cola2.primero());
			cola2.desacolar();
		}
		
		return cola1.primero() == pila.tope();
	}
	
	public static boolean esCapicua(ColaTDA cola1) {
		boolean esCapicua = true;
		ColaTDA copia = new ColaSt();
		PilaTDA pila = new PilaSt();
		copia.inicializarCola();
		pila.inicializarPila();
		
		while (!cola1.colaVacia()) {
			copia.acolar(cola1.primero());
			pila.apilar(cola1.primero());
			cola1.desacolar();
		}
		
		while (esCapicua && !copia.colaVacia()) {
			if (copia.primero() != pila.tope()) {
				esCapicua = false;
			}
			copia.desacolar();
			pila.desapilar();
		}
		
		return esCapicua;
	}
	
	public static boolean sonInversas(ColaTDA cola1, ColaTDA cola2) {
		PilaTDA pila = new PilaSt();
		pila.inicializarPila();
		boolean inversas = true;
		
		while (!cola2.colaVacia()) {
			pila.apilar(cola2.primero());
			cola2.desacolar();
		}
		
		while (inversas && !cola1.colaVacia()) {
			if (cola1.primero() != pila.tope()) {
				System.out.println("Entró.");
				inversas = false;
			}
			cola1.desacolar();
			pila.desapilar();
		}
		return inversas;
	}
	
	public static void eliminarRepetidos(ColaTDA cola1) {
		ColaPrioridadTDA colaPrioridad = new ColaPrioridadSt();
		DiccionarioSimple diccionario = new DiccionarioSimpleSt();
		colaPrioridad.inicializarColaPrioridad();
		diccionario.inicializarDiccionario();
		int contador = 0;
		
		while (!cola1.colaVacia()) {
			diccionario.agregar(cola1.primero(), contador);
			cola1.desacolar();
			contador--;
		}
		
		ConjuntoTDA claves = diccionario.claves();
				
		while (!claves.conjuntoVacio()) {
			int valor = claves.elegir();
			int prioridad = diccionario.recuperar(valor);
			colaPrioridad.acolarPrioridad(valor, prioridad);
			claves.sacar(valor);
			diccionario.eliminar(valor);
		}
		
		while (!colaPrioridad.colaVacia()) {
			cola1.acolar(colaPrioridad.primero());
			colaPrioridad.desacolar();
		}
	}
	
	public static ColaTDA[] dividirEnMitades(ColaTDA cola) {
		ColaTDA m1 = new ColaSt();
		ColaTDA m2 = new ColaSt();
		ColaTDA copia = new ColaSt();
		m1.inicializarCola();
		m2.inicializarCola();
		copia.inicializarCola();
		int largoCola = 1;
		
		while (!cola.colaVacia()) {
			largoCola++;
			copia.acolar(cola.primero());
			cola.desacolar();
		}
		
		for (int i = 0; i < largoCola/2; i++) {
			m1.acolar(copia.primero());
			copia.desacolar();
		}
		
		for (int i = 0; i < largoCola/2; i++) {
			m2.acolar(copia.primero());
			copia.desacolar();
		}
		
		ColaTDA[] mitades = {m1, m2};
		
		return mitades;
		
	}
	
}
