/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencia de la Computación
 * Autor: Denil José Parada Cabrera - 24761, Joel Nerio, Jose Rivera
 * Fecha: [Fecha actual]
 * Descripción: Clase principal del programa que permite al usuario generar, ordenar y visualizar números
 *              aleatorios y ordenados. Incluye la ejecución de varios algoritmos de ordenamiento y el 
 *              almacenamiento de los resultados en un archivo CSV.
 */

 import java.io.*;
 import java.util.*;
 
 public class Main {
     public static void main(String[] args) {
         try {
             Scanner scanner = new Scanner(System.in);
 
             // Solicitar al usuario la cantidad de números
             System.out.print("Ingrese la cantidad de números a ordenar: ");
             int numCount = scanner.nextInt();
 
             // Generar números aleatorios y guardarlos en el archivo 'numerosAleatorios.csv'
             String randomFilePath = "numerosAleatorios.csv";
             FileHandler.generateRandomNumbersCSV(randomFilePath, numCount);
 
             // Leer los números aleatorios del archivo
             List<Integer> numbers = FileHandler.readNumbersFromCSV(randomFilePath);
 
             // Crear un arreglo ordenado y guardarlo en 'numerosOrdenados.csv'
             Integer[] arrayRandom = numbers.toArray(new Integer[0]);
             Integer[] arraySorted = new Integer[numCount];
             for (int i = 0; i < numCount; i++) {
                 arraySorted[i] = i;
             }
             FileHandler.writeNumbersToCSV("numerosOrdenados.csv", arraySorted);
 
             // Menú interactivo
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
                         executeSort(arrayRandom, arraySorted, numCount, scanner, SortAlgorithms::insertionSort, "Insertion Sort");
                         break;
                     case 4:
                         executeSort(arrayRandom, arraySorted, numCount, scanner, (arr) -> SortAlgorithms.mergeSort(arr, 0, arr.length - 1), "Merge Sort");
                         break;
                     case 5:
                         executeSort(arrayRandom, arraySorted, numCount, scanner, (arr) -> SortAlgorithms.quickSort(arr, 0, arr.length - 1), "Quick Sort");
                         break;
                     case 6:
                         executeSort(arrayRandom, arraySorted, numCount, scanner, SortAlgorithms::radixSort, "Radix Sort");
                         break;
                     case 7:
                         executeSort(arrayRandom, arraySorted, numCount, scanner, SortAlgorithms::heapSort, "Heap Sort");
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
 
     /**
      * Ejecuta el algoritmo de ordenamiento seleccionado y guarda los resultados en un archivo CSV.
      *
      * @param arrayRandom  Arreglo de números aleatorios.
      * @param arraySorted  Arreglo de números ordenados.
      * @param numCount     Cantidad de números a ordenar.
      * @param scanner      Objeto Scanner para la entrada del usuario.
      * @param sortFunction Función del algoritmo de ordenamiento a ejecutar.
      * @param sortName     Nombre del algoritmo de ordenamiento.
      */
     private static void executeSort(Integer[] arrayRandom, Integer[] arraySorted, int numCount, Scanner scanner, SortFunction sortFunction, String sortName) {
         System.out.println("\nSeleccione los datos a ordenar:");
         System.out.println("1. Números aleatorios");
         System.out.println("2. Números ordenados");
         System.out.print("Opción: ");
         int dataChoice = scanner.nextInt();
         Integer[] arrayToSort = (dataChoice == 1) ? arrayRandom.clone() : arraySorted.clone();
 
         long timeTaken = TimeProfiler.profileSort(() -> sortFunction.sort(arrayToSort));
         System.out.println("Resultado: " + Arrays.toString(arrayToSort));
         System.out.println(sortName + " completado. Tiempo de ejecución: " + timeTaken + " nanosegundos");
 
         saveResultsToCSV(sortName, dataChoice == 1 ? "Aleatorios" : "Ordenados", timeTaken, numCount);
     }
 
     /**
      * Guarda los resultados del ordenamiento en un archivo CSV.
      *
      * @param algorithm  Nombre del algoritmo de ordenamiento.
      * @param dataType   Tipo de datos utilizados (aleatorios u ordenados).
      * @param timeTaken  Tiempo de ejecución en nanosegundos.
      * @param numCount   Cantidad de números ordenados.
      */
     private static void saveResultsToCSV(String algorithm, String dataType, long timeTaken, int numCount) {
         String csvFilePath = "ResultadosOrdenamiento.csv";
         try (FileWriter writer = new FileWriter(csvFilePath, true)) {
             writer.append(algorithm)
                   .append(",")
                   .append(dataType)
                   .append(",")
                   .append(String.valueOf(numCount))
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
 