public class Ordena {
    // Metodo de ordenação
    public static void selectionSort(Item v[]) {
        for (int i = 0; i < v.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j].getValor() < v[min].getValor()) {
                    min = j;
                }
            }
            Item aux = v[min];
            v[min] = v[i];
            v[i] = aux;
        }
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
