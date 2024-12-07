package Trabalho_ED2;

/*
Discentes: Laila Bianca, Luís Henrique, Marcus Luan
Data de codificação: 16/12/2024
Nome da disciplina: Estrutura de dados II

Objetivo da classe: Reunião de algoritmos de ordenação para sua aplicação em "TesteOrdena"
 */

public class Ordena {

	// Método público para iniciar o QuickSort
	public static void quicksort(Item V[]) {
		// Chama o método recursivo "ordena", passando o vetor inteiro
		ordena(V, 0, V.length - 1);
	}

	// Método recursivo para ordenar o vetor usando o algoritmo QuickSort
	private static void ordena(Item[] vetor, int inicio, int fim) {
		// Verifica se ainda há elementos para ordenar
		if (inicio < fim) {
			// Realiza a partição do vetor e obtém a posição do pivô
			int posicaoPivo = particao(vetor, inicio, fim);
			// Chama recursivamente para ordenar a parte esquerda do pivô
			ordena(vetor, inicio, posicaoPivo - 1);
			// Chama recursivamente para ordenar a parte direita do pivô
			ordena(vetor, posicaoPivo + 1, fim);
		}
	}

	// Método para particionar o vetor e encontrar a posição correta do pivô
	public static int particao(Item[] vetor, int inicio, int fim) {
		// Define o pivô como o primeiro elemento da sublista
		Item pivo = vetor[inicio];
		// Inicializa os índices para percorrer o vetor
		int i = inicio + 1; // Índice da esquerda
		int j = fim; // Índice da direita
		// Loop para reorganizar os elementos em relação ao pivô
		while (i <= j) {
			// Avança o índice da esquerda enquanto o elemento for menor ou igual ao pivô
			if (vetor[i].getValor() <= pivo.getValor())
				i++;
			// Retrocede o índice da direita enquanto o elemento for maior que o pivô
			else if (pivo.getValor() < vetor[j].getValor())
				j--;
			// Caso contrário, troca os elementos das posições i e j
			else {
				Item troca = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = troca;
				i++;
				j--;
			}
		}
		// Coloca o pivô em sua posição correta
		vetor[inicio] = vetor[j];
		vetor[j] = pivo;
		// Retorna a posição do pivô
		return j;
	}

	// Método para restaurar as propriedades do heap máximo
	public static void heapRefaz(Item v[], int esq, int dir) {
		// Inicializa os índices do nó atual (i) e seu filho esquerdo (j)
		int i = esq;
		int j = i * 2 + 1;
		// Guarda o valor do nó atual
		Item aux = v[i];
		// Loop para descer no heap até restaurar a propriedade
		while (j <= dir) {
			// Verifica se o filho direito é maior que o esquerdo
			if (j < dir && v[j].getValor() < v[j + 1].getValor())
				j++;
			// Se o nó atual for maior ou igual ao maior filho, para o loop
			if (aux.getValor() >= v[j].getValor())
				break;
			// Move o maior filho para cima no heap
			v[i] = v[j];
			i = j; // Atualiza o índice do nó atual
			j = i * 2 + 1; // Atualiza o índice do próximo filho
		}
		// Coloca o valor original no local correto
		v[i] = aux;
	}

	// Método para construir o heap máximo a partir de um vetor
	public static void heapConstroi(Item v[], int n) {
		// Calcula o índice do último nó que não é folha
		int esq = (n / 2) - 1;
		// Ajusta o heap a partir dos nós internos até a raiz
		while (esq >= 0) {
			heapRefaz(v, esq, n - 1);
			esq--;
		}
	}

	// Método para ordenar um vetor usando o Heap Sort
	public static void heapSort(Item v[], int n) {
		// Variável auxiliar para realizar trocas
		Item aux;
		// Constroi o heap máximo a partir do vetor
		heapConstroi(v, n);
		// Ordena o vetor removendo o maior elemento do heap
		while (n > 1) {
			// Troca o maior elemento (raiz do heap) com o último elemento
			aux = v[n - 1];
			v[n - 1] = v[0];
			v[0] = aux;
			// Reduz o tamanho do heap
			n--;
			// Restaura a propriedade do heap
			heapRefaz(v, 0, n - 1);
		}
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
