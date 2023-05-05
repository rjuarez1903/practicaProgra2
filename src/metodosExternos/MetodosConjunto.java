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
}
