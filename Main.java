import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "numeros.txt";
            FileHandler.generateRandomNumbers(filePath, 3000);
            List<Integer> numbers = FileHandler.readNumbersFromFile(filePath);

            Integer[] arrayRandom = numbers.toArray(new Integer[0]);
            Integer[] arraySorted = new Integer[3000];
            for (int i = 0; i < 3000; i++) {
                arraySorted[i] = i;
            }

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Mostrar números aleatorios");
                System.out.println("2. Mostrar números ordenados");
                System.out.println("3. Ordenar usando Insertion Sort");
                System.out.println("4. Ordenar usando Merge Sort");
                System.out.println("5. Ordenar usando Quick Sort");
                System.out.println("6. Ordenar usando Radix Sort");
                System.out.println("7. Ordenar usando Heap Sort");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Números aleatorios:");
                        System.out.println(Arrays.toString(arrayRandom));
                        break;
                    case 2:
                        System.out.println("Números ordenados:");
                        System.out.println(Arrays.toString(arraySorted));
                        break;
                    case 3:
                        executeSort(arrayRandom, arraySorted, scanner, SortAlgorithms::insertionSort, "Insertion Sort");
                        break;
                    case 4:
                        executeSort(arrayRandom, arraySorted, scanner, (arr) -> SortAlgorithms.mergeSort(arr, 0, arr.length - 1), "Merge Sort");
                        break;
                    case 5:
                        executeSort(arrayRandom, arraySorted, scanner, (arr) -> SortAlgorithms.quickSort(arr, 0, arr.length - 1), "Quick Sort");
                        break;
                    case 6:
                        executeSort(arrayRandom, arraySorted, scanner, SortAlgorithms::radixSort, "Radix Sort");
                        break;
                    case 7:
                        executeSort(arrayRandom, arraySorted, scanner, SortAlgorithms::heapSort, "Heap Sort");
                        break;
                    case 8:
                        running = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeSort(Integer[] arrayRandom, Integer[] arraySorted, Scanner scanner, SortFunction sortFunction, String sortName) {
        System.out.println("\nSeleccione los datos a ordenar:");
        System.out.println("1. Números aleatorios");
        System.out.println("2. Números ordenados");
        System.out.print("Opción: ");
        int dataChoice = scanner.nextInt();
        Integer[] arrayToSort = (dataChoice == 1) ? arrayRandom.clone() : arraySorted.clone();

        long timeTaken = TimeProfiler.profileSort(() -> sortFunction.sort(arrayToSort));
        System.out.println("Resultado: " + Arrays.toString(arrayToSort));
        System.out.println(sortName + " completado. Tiempo de ejecución: " + timeTaken + " nanosegundos");

        saveResultsToCSV(sortName, dataChoice == 1 ? "Aleatorios" : "Ordenados", timeTaken);
    }

    private static void saveResultsToCSV(String algorithm, String dataType, long timeTaken) {
        String csvFilePath = "ResultadosOrdenamiento.csv";
        try (FileWriter writer = new FileWriter(csvFilePath, true)) {
            writer.append(algorithm)
                  .append(",")
                  .append(dataType)
                  .append(",")
                  .append(String.valueOf(timeTaken))
                  .append("\n");
            System.out.println("Resultados guardados en " + csvFilePath);
        } catch (IOException e) {
            System.out.println("Error al guardar los resultados en el archivo CSV.");
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    interface SortFunction {
        void sort(Comparable[] array);
    }
}
