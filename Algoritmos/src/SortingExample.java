import java.io.*;
import java.util.*;

import OrdenacaoCrescente.OrdenacaoCrescente;
import OrdenacaoDecrescente.OrdenacaoDecrescente;

public class SortingExample {

    public static OrdenacaoCrescente ordenacaoCrescente = new OrdenacaoCrescente();
    public static OrdenacaoDecrescente ordenacaoDecrescente = new OrdenacaoDecrescente();

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

        System.out.print("Escolha o algoritmo: ordenação crescente->(1: BubbleSort, 2: InsertionSort, 3: SelectionSort, 4: MergeSort, 5: QuickSort, 6: HeapSort), ordenação descrecente->(7: BubbleSort, 8: InsertionSort, 9: SelectionSort, 10: MergeSort, 11: QuickSort, 12: HeapSort) ");
        int choice = scanner.nextInt();
        

        switch (choice) {
            //Ordenação Crescente
            case 1:
                ordenacaoCrescente.bubbleSort(numbers);
                break;
            case 2:
                ordenacaoCrescente.insertionSort(numbers);
                break;
            case 3:
                ordenacaoCrescente.selectionSort(numbers);
                break;
            case 4:
                ordenacaoCrescente.mergeSort(numbers, n, choice);
                break;
            case 5:
                ordenacaoCrescente.quickSort(numbers, n, choice);
                break;
            case 6:
                ordenacaoCrescente.heapSort(numbers);
                break;

            //Ordenação Decrescente  
            case 7:
                ordenacaoDecrescente.bubbleSort(numbers);
                break;
            case 8:
                ordenacaoDecrescente.insertionSort(numbers);
                break;
            case 9:
                ordenacaoDecrescente.selectionSort(numbers);
                break;
            case 10:
                ordenacaoDecrescente.mergeSort(numbers, n, choice);
                break;
            case 11:
                ordenacaoDecrescente.quickSort(numbers, n, choice);
                break;
            case 12:
                ordenacaoDecrescente.heapSort(numbers);
                break;    
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
}
