package impl;

import tda.ConjuntoTDA;

public class ConjuntoSt implements ConjuntoTDA {
	
	private int[] arr;
	private int indice;

	@Override
	public void inicializarConjunto() {
		arr = new int[100];
		indice = 0;
	}

	@Override
	public void agregar(int x) {
		if (!this.pertenece(x)) {
			arr[indice] = x;
			indice++;
		}
	}
	@Override
	public int elegir() { // Costo Constante
		return arr[indice -1];
	}

	@Override
	public void sacar(int x) { // Costo Lineal
		int i = 0;
		while (i < indice && arr[i] != x) {
			i++;
		}
		if (i < indice) {
			arr[i] = arr[indice - 1];
			indice--;
		}
	}

	@Override
	public boolean pertenece(int x) { // Costo lineal
		boolean pertenece = false;
		for (int i = 0; i < indice; i++) {
			if (arr[i] == x) {
				pertenece = true;
			}
		}
		return pertenece;
	}

	@Override
	public boolean conjuntoVacio() { // Costo Constante
		return indice == 0;
	}

}
