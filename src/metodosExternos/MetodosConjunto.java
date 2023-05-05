package metodosExternos;

import tda.*;
import impl.*;

public class MetodosConjunto {
	public static void imprimirConjunto(ConjuntoTDA conjunto) {
		while (!conjunto.conjuntoVacio()) {
			int valor = conjunto.elegir();
			System.out.println(valor);
			conjunto.sacar(valor);
		} 
	}
	
	public static ConjuntoTDA interseccion(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
		ConjuntoTDA conj = new ConjuntoSt();
		conj.inicializarConjunto();
		while (!conjunto1.conjuntoVacio()) {
			int valor = conjunto1.elegir();
			if (conjunto2.pertenece(valor)) {
				conj.agregar(valor);
			}
			conjunto1.sacar(valor);
		}
		return conj;
	}
	
	public static ConjuntoTDA union(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
		ConjuntoTDA conj = new ConjuntoSt();
		conj.inicializarConjunto();
		while (!conjunto1.conjuntoVacio()) {
			int valor = conjunto1.elegir();
			conj.agregar(valor);
			conjunto1.sacar(valor);
		}
		while (!conjunto2.conjuntoVacio()) {
			int valor = conjunto2.elegir();
			conj.agregar(valor);
			conjunto2.sacar(valor);
		}
		return conj;
	}
	
	public static ConjuntoTDA diferencia(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
		ConjuntoTDA conj = new ConjuntoSt();
		conj.inicializarConjunto();
		while (!conjunto1.conjuntoVacio()) {
			int valor = conjunto1.elegir();
			if (!conjunto2.pertenece(valor)) {
				conj.agregar(valor);
			}
			conjunto1.sacar(valor);
		}
		return conj;
	}
	
	public static boolean sonIguales(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
		boolean iguales = true;
		while (iguales && !conjunto1.conjuntoVacio()) {
			int valor = conjunto1.elegir();
			if (!conjunto2.pertenece(valor)) {
				iguales = false;
			}
			conjunto1.sacar(valor);
			conjunto2.sacar(valor);
		}
		
		if (!conjunto2.conjuntoVacio()) {
			iguales = false;
		}

		return iguales;
	}
	
	public static int cardinalidad(ConjuntoTDA conjunto) {
		int contador = 0;
		while (!conjunto.conjuntoVacio()) {
			conjunto.sacar(conjunto.elegir());
			contador++;
		}
		return contador;
	} 
	
	public static ConjuntoTDA conjuntoPilaCola(PilaTDA pila, ColaTDA cola) {
		ConjuntoTDA conjuntoPila = new ConjuntoSt();
		ConjuntoTDA conjuntoCola = new ConjuntoSt();
		conjuntoPila.inicializarConjunto();
		conjuntoCola.inicializarConjunto();
		while (!pila.pilaVacia()) {
			conjuntoPila.agregar(pila.tope());
			pila.desapilar();
		}
		while (!cola.colaVacia()) {
			conjuntoCola.agregar(cola.primero());
			cola.desacolar();
		}
		return interseccion(conjuntoPila, conjuntoCola);
	}
	
	public static boolean pilaColaIgualesElem(PilaTDA pila, ColaTDA cola) {
		ConjuntoTDA conjuntoPila = new ConjuntoSt();
		ConjuntoTDA conjuntoCola = new ConjuntoSt();
		conjuntoPila.inicializarConjunto();
		conjuntoCola.inicializarConjunto();
		while (!pila.pilaVacia()) {
			conjuntoPila.agregar(pila.tope());
			pila.desapilar();
		}
		while (!cola.colaVacia()) {
			conjuntoCola.agregar(cola.primero());
			cola.desacolar();
		}
		return sonIguales(conjuntoPila, conjuntoCola);
	}
		
	public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjunto, ConjuntoTDA conjunto2) {
		ConjuntoTDA diferencia1 = new ConjuntoSt();
		ConjuntoTDA copia = new ConjuntoSt();
		diferencia1.inicializarConjunto();
		copia.inicializarConjunto();
		while (!conjunto.conjuntoVacio()) {
			int valor = conjunto.elegir();
			if (!conjunto2.pertenece(valor)) {
				diferencia1.agregar(valor);
			}
			copia.agregar(valor);
			conjunto.sacar(valor);
		}
		ConjuntoTDA diferencia2 = diferencia(conjunto2, copia);
		return union(diferencia1, diferencia2);
	}
	
}
