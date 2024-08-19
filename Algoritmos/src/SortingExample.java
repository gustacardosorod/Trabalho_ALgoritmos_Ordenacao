import java.io.*;
import java.util.*;

public class SortingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar a quantidade de números
        System.out.print("Digite a quantidade de números a serem ordenados: ");
        int n = scanner.nextInt();

        // Solicitar o nome do arquivo de entrada
        System.out.print("Digite o nome do arquivo de entrada: ");
        String inputFileName = scanner.next();

        // Solicitar o nome do arquivo de saída
        System.out.print("Digite o nome do arquivo de saída: ");
        String outputFileName = scanner.next();

        // Ler os números do arquivo de entrada
        int[] numbers = new int[n];
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        // Escolher o algoritmo de ordenação
        System.out.print("Escolha o algoritmo de ordenação (1: BubbleSort, 2: InsertionSort): ");
        int choice = scanner.nextInt();

        // Executar o algoritmo de ordenação escolhido
        switch (choice) {
            case 1:
                bubbleSort(numbers);
                break;
            case 2:
                insertionSort(numbers);
                break;
            // Adicione os outros algoritmos aqui...
            default:
                System.out.println("Algoritmo de ordenação inválido.");
                return;
        }

        // Gravar os números ordenados no arquivo de saída
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int number : numbers) {
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }

        System.out.println("Ordenação concluída e salva no arquivo: " + outputFileName);
    }

    // Implementação do Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Implementação do Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
