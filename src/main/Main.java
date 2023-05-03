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
		
		ColaTDA cola1 = new ColaSt();
		ColaTDA cola2 = new ColaSt();
		cola1.inicializarCola();
		cola2.inicializarCola();
		
		cola1.acolar(0);
		cola1.acolar(4);
		cola1.acolar(6);
		cola1.acolar(8);
		cola1.acolar(6);
		cola1.acolar(8);
		cola1.acolar(7);
		cola1.acolar(10);
		
		cola2.acolar(8);
		cola2.acolar(6);
		cola2.acolar(4);
		cola2.acolar(0);
		
		ColaTDA[] mitades = MetodosCola.dividirEnMitades(cola1);
		ColaTDA mitad1 = mitades[0];
		ColaTDA mitad2 = mitades[1];
		
		MetodosCola.imprimirCola(mitad1);
		MetodosCola.imprimirCola(mitad2);
	}
	
	

}
