package metodosExternos;

import tda.*;
import impl.*;

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
	
	public static DiccionarioMultipleTDA clavesDicMulti1(DiccionarioMultipleTDA dicMulti, DiccionarioMultipleTDA dicMulti2) {
		DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultipleSt();
		diccionarioMultiple.inicializarDiccionario();
		ConjuntoTDA claves1 = dicMulti.claves();
		ConjuntoTDA claves2 = dicMulti2.claves();
		while (!claves1.conjuntoVacio()) {
			int clave = claves1.elegir();
			ConjuntoTDA valores = dicMulti.recuperar(clave);
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				diccionarioMultiple.agregar(clave, valor);
				valores.sacar(valor);
			}
			claves1.sacar(clave);
		}
		while (!claves2.conjuntoVacio()) {
			int clave = claves2.elegir();
			ConjuntoTDA valores = dicMulti.recuperar(clave);
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				diccionarioMultiple.agregar(clave, valor);
				valores.sacar(valor);
			}
			claves2.sacar(clave);
		}
		return diccionarioMultiple; 
	}
	
	public static DiccionarioMultipleTDA clavesDicMulti4(DiccionarioMultipleTDA dicMulti, DiccionarioMultipleTDA dicMulti2) {
		DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultipleSt();
		diccionarioMultiple.inicializarDiccionario();
		ConjuntoTDA claves1 = dicMulti.claves();
		ConjuntoTDA claves2 = dicMulti2.claves();
		
		ConjuntoTDA claves = MetodosConjunto.interseccion(claves1, claves2);
		
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			ConjuntoTDA valores1 = dicMulti.recuperar(clave);
			ConjuntoTDA valores2 = dicMulti2.recuperar(clave);
			
			while (!valores1.conjuntoVacio()) {
				int valor = valores1.elegir();
				diccionarioMultiple.agregar(clave, valor);
				valores1.sacar(valor);
			}
			
			while (!valores2.conjuntoVacio()) {
				int valor = valores2.elegir();
				diccionarioMultiple.agregar(clave, valor);
				valores2.sacar(valor);
			}
			
			claves.sacar(clave);
		}
		
		return diccionarioMultiple;
	}
	
	
	
	public static DiccionarioMultipleTDA diccionarioSinonimos(DiccionarioSimple diccionario) {
		DiccionarioMultipleTDA ds = new DiccionarioMultipleSt();
		ds.inicializarDiccionario();
		ConjuntoTDA claves = diccionario.claves();
		
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			int valor = diccionario.recuperar(clave);
			ds.agregar(valor, clave);
			claves.sacar(clave);
		}
		return ds;
	}
	
}
