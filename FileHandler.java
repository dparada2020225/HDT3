/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencia de la Computación
 * Autor: Denil José Parada Cabrera - 24761, Joel Nerio, Jose Rivera
 * Fecha: [Fecha actual]
 * Descripción: Clase encargada de manejar la generación, lectura y escritura de archivos CSV
 *              con números aleatorios y ordenados.
 */

 import java.io.*;
 import java.util.*;
 
 public class FileHandler {
 
     /**
      * Genera un archivo CSV con números aleatorios.
      *
      * @param filePath Ruta del archivo CSV a generar.
      * @param amount   Cantidad de números aleatorios a generar.
      * @throws IOException Si ocurre un error al escribir en el archivo.
      */
     public static void generateRandomNumbersCSV(String filePath, int amount) throws IOException {
         Random random = new Random();
         try (FileWriter writer = new FileWriter(filePath)) {
             for (int i = 0; i < amount; i++) {
                 writer.append(String.valueOf(random.nextInt(10000))).append("\n");
             }
         }
     }
 
     /**
      * Lee números desde un archivo CSV y los almacena en una lista.
      *
      * @param filePath Ruta del archivo CSV a leer.
      * @return Lista de números leídos del archivo.
      * @throws IOException Si ocurre un error al leer el archivo.
      */
     public static List<Integer> readNumbersFromCSV(String filePath) throws IOException {
         List<Integer> numbers = new ArrayList<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 numbers.add(Integer.parseInt(line));
             }
         }
         return numbers;
     }
 
     /**
      * Escribe un arreglo de números en un archivo CSV.
      *
      * @param filePath Ruta del archivo CSV a escribir.
      * @param numbers  Arreglo de números a escribir en el archivo.
      * @throws IOException Si ocurre un error al escribir en el archivo.
      */
     public static void writeNumbersToCSV(String filePath, Integer[] numbers) throws IOException {
         try (FileWriter writer = new FileWriter(filePath)) {
             for (Integer number : numbers) {
                 writer.append(String.valueOf(number)).append("\n");
             }
         }
     }
 }
 