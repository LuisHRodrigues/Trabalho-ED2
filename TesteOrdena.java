public class TesteOrdena {
    public static void main(String[] args) {
        int execucoes = 100;

        // Gerar os datasets
        Item[][] dataset1 = Utilidades.geraDataset1();
        Item[][] dataset2 = Utilidades.geraDataset2();

        // Medir o tempo para o Dataset1
        System.out.println("\nMedição para Dataset1:\n");
        medirTempo(dataset1, execucoes);

        // Medir o tempo para o Dataset2
        System.out.println("\nMedição para Dataset2:\n");
        medirTempo(dataset2, execucoes);
    }

    // Método para medir o tempo de execução dos algoritmos
    public static void medirTempo(Item[][] dataset, int execucoes) {
        // Repete sobre cada vetor de Item no dataset
        for (int y = 0; y <= 2; y++) {
            if (y == 0) {
                System.out.println("=== Bubble sort ===");
                for (Item[] vetor : dataset) {
                    // Inicializa a variável que vai acumular o tempo total de execução
                    long somaTempo = 0;

                    for (int i = 0; i < execucoes; i++) {
                        // Cria uma cópia do vetor para garantir que o mesmo vetor seja usado em cada
                        // execução

                        Item[] vetorCopia = copiarVetor(vetor);

                        long tempInicio = System.nanoTime(); // Captura o tempo inicial
                        Ordena.bubbleSort(vetorCopia);
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
                for (Item[] vetor : dataset) {
                    long somaTempo = 0;

                    for (int i = 0; i < execucoes; i++) {
                        Item[] vetorCopia = copiarVetor(vetor);
                        long tempInicio = System.nanoTime();
                        Ordena.insertionSort(vetorCopia);
                        long tempFim = System.nanoTime();
                        long tempoExecucao = tempFim - tempInicio;
                        somaTempo += tempoExecucao;
                    }

                    long media = somaTempo / execucoes;
                    System.out.printf("Tamanho do vetor: %d, Tempo médio: %d nanosegundos\n", vetor.length, media);
                }
            }
            if (y == 2) {
                System.out.println("=== Selection sort ===");
                for (Item[] vetor : dataset) {
                    long somaTempo = 0;
                    for (int i = 0; i < execucoes; i++) {
                        Item[] vetorCopia = copiarVetor(vetor);
                        long tempInicio = System.nanoTime();
                        Ordena.selectionSort(vetorCopia);
                        long tempFim = System.nanoTime();
                        long tempoExecucao = tempFim - tempInicio;

                        somaTempo += tempoExecucao;
                    }

                    long media = somaTempo / execucoes;
                    System.out.printf("Tamanho do vetor: %d, Tempo médio: %d nanosegundos\n", vetor.length, media);
                }
            }
        }
    }

    public static Item[] copiarVetor(Item[] vetorOriginal) {
        // Cria um novo vetor com o mesmo comprimento do vetor original
        Item[] copia = new Item[vetorOriginal.length];

        // Itera sobre cada elemento do vetor original
        for (int i = 0; i < vetorOriginal.length; i++) {

            // Cria um novo objeto Item para cada elemento do vetor original e copia o valor
            // do Item original para o novo Item
            copia[i] = new Item(vetorOriginal[i].getValor());
        }
        // Retorna a cópia do vetor
        return copia;
    }
}
