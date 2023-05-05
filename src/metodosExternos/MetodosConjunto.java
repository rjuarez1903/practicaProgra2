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
}
