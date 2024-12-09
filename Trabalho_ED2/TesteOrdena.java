package Trabalho_ED2;

/*
Discentes: Laila Bianca, Luís Henrique, Marcus Luan
Data de codificação: 16/08/2024
Nome da disciplina: Estrutura de dados II

Objetivo da classe: Executar algoritmos de ordenação e calcular
tempos de execução com cópias de um mesmo vetor.
 */

public class TesteOrdena {
    public static void main(String[] args) {
        int execucoes = 100;

        // Gerar os datasets
        Item[][] dataset1 = Utilidades.geraDataset1();
        Item[][] dataset2 = Utilidades.geraDataset2();

        // Medir o tempo para o Dataset1
        System.out.println("\nMedição para Dataset1:\n");
        medirTempo(dataset1, execucoes);
        medirTempo(dataset2, execucoes);

    }

    // Método para medir o tempo de execução dos algoritmos
    public static void medirTempo(Item[][] dataset, int execucoes) {
        // Repete sobre cada vetor de Item no dataset
        for (int y = 0; y <= 2; y++) {
            // int[] tamanhos = { 10, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
            int[] tamanhos = { 1000, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };

            if (y == 0) {
                System.out.println("=== Heap sort ===");

                // int[] tamanhos = {10, 20};
                for (int tam : tamanhos) {
                    // Inicializa a variável que vai acumular o tempo total de execução
                    long somaTempo = 0;
                    Item[] vetor = null;
                    for (int i = 0; i < execucoes; i++) {

                        vetor = Utilidades.geraDataset(tam);

                        long tempInicio = System.nanoTime(); // Captura o tempo inicial
                        Ordena.heapSort(vetor, vetor.length);
                        long tempFim = System.nanoTime(); // Captura o tempo final

                        long tempoExecucao = tempFim - tempInicio;

                        // Acumula o tempo de execução em uma variável que armazena a soma total dos
                        // tempos

                        somaTempo += tempoExecucao;
                    }

                    long media = somaTempo / execucoes;
                    System.out.printf("Tamanho do vetor: %d, Tempo médio: %d nanosegundos\n", vetor.length, media);
                }
            }
            if (y == 1) {
                System.out.println("=== Insertion sort ===");
                for (int tam : tamanhos) {
                    // Inicializa a variável que vai acumular o tempo total de execução
                    long somaTempo = 0;
                    Item[] vetor = null;
                    for (int i = 0; i < execucoes; i++) {

                        vetor = Utilidades.geraDataset(tam);

                        long tempInicio = System.nanoTime(); // Captura o tempo inicial
                        Ordena.insertionSort(vetor);
                        long tempFim = System.nanoTime(); // Captura o tempo final

                        long tempoExecucao = tempFim - tempInicio;

                        // Acumula o tempo de execução em uma variável que armazena a soma total dos
                        // tempos

                        somaTempo += tempoExecucao;
                    }

                    long media = somaTempo / execucoes;
                    System.out.printf("Tamanho do vetor: %d, Tempo médio: %d nanosegundos\n", vetor.length, media);
                }
            }
            if (y == 2) {
                System.out.println("=== Quick sort ===");
                for (int tam : tamanhos) {
                    // Inicializa a variável que vai acumular o tempo total de execução
                    long somaTempo = 0;
                    Item[] vetor = null;
                    for (int i = 0; i < execucoes; i++) {

                        vetor = Utilidades.geraDataset(tam);

                        long tempInicio = System.nanoTime(); // Captura o tempo inicial
                        Ordena.quicksort(vetor);
                        long tempFim = System.nanoTime(); // Captura o tempo final

                        long tempoExecucao = tempFim - tempInicio;

                        // Acumula o tempo de execução em uma variável que armazena a soma total dos
                        // tempos

                        somaTempo += tempoExecucao;
                    }

                    long media = somaTempo / execucoes;
                    System.out.printf("Tamanho do vetor: %d, Tempo médio: %d nanosegundos\n", vetor.length, media);
                }
            }
        }
    }

}
