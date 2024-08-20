import java.io.*;
import java.util.*;

public class SortingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números a serem ordenados: ");
        int n = scanner.nextInt();

        System.out.print("Digite o nome do arquivo de entrada: ");
        String inputFileName = scanner.next();

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

        }

        System.out.print("Escolha o algoritmo de ordenação (1: BubbleSort, 2: InsertionSort, 3: SelectionSort, 4:MergeSort, 5:QuickSort, 6:HeapSort): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bubbleSort(numbers);
                break;
            case 2:
                insertionSort(numbers);
                break;
            case 3:
                selectionSort(numbers);
                break;
            case 4:
                mergeSort(numbers, n, choice);
                break;
            case 5:
                quickSort(numbers, n, choice);
                break;
            case 6:
                heapSort(numbers);
            default:
                System.out.println("Algoritmo de ordenação inválido.");
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

        scanner.close();
    }

    // Implementação do Bubble Sort
    public static void bubbleSort(int[] arr) {
        double tempoInicial = System.currentTimeMillis();

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

        double tempoFinal = System.currentTimeMillis();
        double tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }

    // Implementação do Insertion Sort
    public static void insertionSort(int[] arr) {
        long tempoInicial = System.currentTimeMillis();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }

    //Implementação do Selection Sort
    public static void selectionSort(int[] arr) {
        long tempoInicial = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }
    
    //Implementação do Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        long tempoInicial = System.currentTimeMillis();

        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Implementação do Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        double tempoInicial = System.currentTimeMillis();

        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi);
            quickSort(arr, pi + 1, high);
        }

        double tempoFinal = System.currentTimeMillis();
        double tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    //Implementação do Heap Sort
    public static void heapSort(int[] arr) {
        long tempoInicial = System.currentTimeMillis();

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + tempoExecucao);
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
