package metodosExternos;

import tda.*;

public class MetodosDiccionarioMultiple {
	
	public static void imprimirDiccionarioMuliple(DiccionarioMultipleTDA dicMulti) {
		ConjuntoTDA claves = dicMulti.claves();
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			System.out.println("Clave " + clave + ".");
			ConjuntoTDA valores = dicMulti.recuperar(clave);
			System.out.println("Valores: ");
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				System.out.println(valor);
				valores.sacar(valor);
			}
			claves.sacar(clave);
		}
	}
	
}
