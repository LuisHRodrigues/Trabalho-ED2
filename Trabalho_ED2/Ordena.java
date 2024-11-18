package Trabalho_ED2;

public class Ordena {
    // Metodo de ordenação
   public static void quicksort(Item V[]){
		ordena(V, 0, V.length-1);
	}
	// ********************************************
	private static void ordena(Item[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = particao(vetor, inicio, fim);
			ordena(vetor, inicio, posicaoPivo - 1);
			ordena(vetor, posicaoPivo + 1, fim);
		}
	}
	public static int particao(Item[] vetor, int inicio, int fim){
		Item pivo = vetor[inicio];
		int i = inicio + 1;
		int j = fim;
		while (i <= j) {
			if (vetor[i].getValor() <= pivo.getValor())
				i++;
			else if (pivo.getValor() < vetor[j].getValor())
				j--;
			else {
				Item troca = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = troca;
				i++;
				j--;
			}
		}
		vetor[inicio] = vetor[j];
		vetor[j] = pivo;
		return j;
	}


    public static void bubbleSort(Item v[]) {
        for (int k = v.length; k >= 1; k--) {
            for (int j = 1; j < k; j++) {
                if (v[j - 1].getValor() > v[j].getValor())
                    troca(v, j, j - 1);
            }
        }
    }

    public static void troca(Item v[], int m, int n) {
        Item aux = v[m];
        v[m] = v[n];
        v[n] = aux;
    }

    public static void insertionSort(Item v[]) {
        int j = 0;
        for (int i = 1; i < v.length; i++) { // laco externo divide o vetor
            Item aux = v[i];
            j = i;
            while (j > 0 && aux.getValor() <= v[j - 1].getValor()) { // Faça ate encontrar o menor elemento
                v[j] = v[j - 1]; // troca a posição com o de índice anterior
                j--; // volte uma posição no índice
            } // fim do while
            v[j] = aux; // insere o elemento em aux na posição j
        }
    }
}
