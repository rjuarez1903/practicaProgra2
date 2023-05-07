package impl;

import tda.ConjuntoTDA;

public class ConjuntoDyn implements ConjuntoTDA {
	
	public class Nodo {
		public int info;
		public Nodo sig;
	}
	
	Nodo c;

	@Override
	public void inicializarConjunto() { 
		c = null; 

	}

	@Override
	public void agregar(int x) {
		// Verifica que x no esté en el conjunto
		if (!this.pertenece(x)) {
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = c;
			c = aux;
		}

	}

	@Override
	public void sacar(int x) { 
		if (c != null) { 
			// Si es el primer elemento de la lista
			if (c.info == x) { 
				c = c.sig;   
			}
		} else {
			Nodo aux = c;  
			while (aux.sig != null && aux.sig.info != x) 
				aux = aux.sig; 
			if (aux.sig != null) 
				aux.sig = aux.sig.sig;
		}
	}

	@Override
	public int elegir() { 
		return c.info; 
	}

	@Override
	public boolean pertenece(int x) {
		Nodo aux = c;
		while ((aux.sig != null) && (aux.info != x)) {
			aux = aux.sig;
		}
		return aux != null;
	}

	@Override
	public boolean conjuntoVacio() {
		return c == null;
	}

}
