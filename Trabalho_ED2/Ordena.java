package trabalho2_ED2;

/*
Discentes: Laila Bianca, Luís Henrique, Marcus Luan
Data de codificação: 16/12/2024
Nome da disciplina: Estrutura de dados II

Objetivo da classe: Reunião de algoritmos de ordenação para sua aplicação em "TesteOrdena"
 */

public class Ordena {
	//Metodo de ordenação

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

	public static void heapRefaz(Item v[], int esq, int dir) {
		int i= esq;
		int j= i*2 + 1;
		Item aux = v[i];
		while(j<=dir) {
			if(j< dir && v[j].getValor()< v[j+1].getValor())
				j++;
			if(aux.getValor() >= v[j].getValor())
				break;
			v[i]= v[j];
			i=j;
			j= i*2+1;
		}
		v[i]= aux;
	}
	public static void heapConstroi(Item v[], int n) {
		int esq; 
		esq= (n/2)-1;
		while (esq >= 0) { 
			heapRefaz(v, esq, n-1); 
			esq--; 
			} 
		}
	public static void heapSort(Item v[], int n) { 
		Item aux; 
		/*
		System.out.print("\n Antes: ");
		for(int i=0; i< v.length; i++) {
			System.out.print(v[i].getValor() + " - ");
		}
		*/
		heapConstroi(v, n); 
		while (n > 1) { 
			aux = v[n-1]; 
			v[n-1] = v[0]; 
			v[0] = aux; 
			n--; 
			heapRefaz(v, 0, n-1); // refaz o heap } }
		}
		/*
		System.out.print("\n Depois: ");
		for(int i=0; i< v.length; i++) {
			System.out.print(v[i].getValor() + " - ");
		}
		*/
	}



	public static void insertionSort(Item v[]) {
		int j = 0;
		for (int i = 1; i < v.length; i++) { //laco externo divide o vetor
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


