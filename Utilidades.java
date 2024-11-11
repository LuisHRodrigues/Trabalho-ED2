import java.util.Random;

public class Utilidades {

    // Método para gerar um vetor de objetos Item com valores aleatórios
    public static Item[] geraVetorAleatorio(int tam) {
        Item[] vet = new Item[tam];
        Random random = new Random();
        for (int i = 0; i < tam; i++) {
            vet[i] = new Item(random.nextInt(1000)); // Numeros de 0 a 999
        }
        return vet;
    }

    // Método para gerar o Dataset1
    public static Item[][] geraDataset1() {
        // Define os tamanhos dos vetores que serão gerados
        int[] tamanhos = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        // Cria uma matriz de vetores (Item[][]) com os tamanhos definidos
        // O número de linhas da matriz é igual ao número de elementos em 'tamanhos'
        Item[][] dataset1 = new Item[tamanhos.length][];

        // Repete para cada tamanho no array 'tamanhos'
        for (int i = 0; i < tamanhos.length; i++) {
            // Para cada tamanho vai gerar um vetor de 'Item' com o tamanho especificado e
            // armazena esse vetor na matriz 'dataset1'
            dataset1[i] = geraVetorAleatorio(tamanhos[i]);
        }

        // Retorna a matriz de vetores de 'Item'
        return dataset1;
    }

    // Método para gerar o Dataset2
    public static Item[][] geraDataset2() {
        // Define os tamanhos dos vetores que serão gerados
        int[] tamanhos = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };

        // Cria uma matriz de vetores (Item[][]) com os tamanhos definidos
        // O número de linhas da matriz é igual ao número de elementos em 'tamanhos'
        Item[][] dataset2 = new Item[tamanhos.length][];

        // Repete para cada tamanho no array 'tamanhos'
        for (int i = 0; i < tamanhos.length; i++) {

            // Para cada tamanho vai gerar um vetor de 'Item' com o tamanho definido e
            // armazena esse vetor na matriz 'dataset2'
            dataset2[i] = geraVetorAleatorio(tamanhos[i]);
        }

        // Retorna a matriz de vetores de 'Item'
        return dataset2;
    }
}
