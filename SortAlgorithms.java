/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencia de la Computación
 * Autor: Denil José Parada Cabrera - 24761, Joel Nerio, Jose Rivera
 * Fecha: [Fecha actual]
 * Descripción: Clase que implementa varios algoritmos de ordenamiento, incluyendo Insertion Sort,
 *              Merge Sort, Quick Sort, Radix Sort y Heap Sort.
 */

 import java.util.Arrays;

 public class SortAlgorithms {
 
     /**
      * Ordena un arreglo utilizando el algoritmo Insertion Sort.
      *
      * @param array Arreglo a ordenar.
      */
     public static void insertionSort(Comparable[] array) {
         for (int i = 1; i < array.length; i++) {
             Comparable key = array[i];
             int j = i - 1;
             while (j >= 0 && array[j].compareTo(key) > 0) {
                 array[j + 1] = array[j];
                 j--;
             }
             array[j + 1] = key;
         }
     }
 
     /**
      * Ordena un arreglo utilizando el algoritmo Merge Sort.
      *
      * @param array Arreglo a ordenar.
      * @param left  Índice inicial del subarreglo.
      * @param right Índice final del subarreglo.
      */
     public static void mergeSort(Comparable[] array, int left, int right) {
         if (left < right) {
             int middle = (left + right) / 2;
             mergeSort(array, left, middle);
             mergeSort(array, middle + 1, right);
             merge(array, left, middle, right);
         }
     }
 
     /**
      * Realiza la mezcla de dos subarreglos en un arreglo ordenado.
      *
      * @param array  Arreglo a mezclar.
      * @param left   Índice inicial del primer subarreglo.
      * @param middle Índice medio que separa los subarreglos.
      * @param right  Índice final del segundo subarreglo.
      */
     private static void merge(Comparable[] array, int left, int middle, int right) {
         int n1 = middle - left + 1;
         int n2 = right - middle;
         Comparable[] leftArray = new Comparable[n1];
         Comparable[] rightArray = new Comparable[n2];
 
         System.arraycopy(array, left, leftArray, 0, n1);
         System.arraycopy(array, middle + 1, rightArray, 0, n2);
 
         int i = 0, j = 0, k = left;
         while (i < n1 && j < n2) {
             if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                 array[k] = leftArray[i];
                 i++;
             } else {
                 array[k] = rightArray[j];
                 j++;
             }
             k++;
         }
 
         while (i < n1) {
             array[k] = leftArray[i];
             i++;
             k++;
         }
 
         while (j < n2) {
             array[k] = rightArray[j];
             j++;
             k++;
         }
     }
 
     /**
      * Ordena un arreglo utilizando el algoritmo Quick Sort.
      *
      * @param array Arreglo a ordenar.
      * @param low   Índice inicial del subarreglo.
      * @param high  Índice final del subarreglo.
      */
     public static void quickSort(Comparable[] array, int low, int high) {
         if (low < high) {
             int pivotIndex = partition(array, low, high);
             quickSort(array, low, pivotIndex - 1);
             quickSort(array, pivotIndex + 1, high);
         }
     }
 
     /**
      * Realiza la partición del arreglo en el algoritmo Quick Sort.
      *
      * @param array Arreglo a particionar.
      * @param low   Índice inicial del subarreglo.
      * @param high  Índice final del subarreglo.
      * @return Índice del pivote después de la partición.
      */
     private static int partition(Comparable[] array, int low, int high) {
         Comparable pivot = array[high];
         int i = low - 1;
         for (int j = low; j < high; j++) {
             if (array[j].compareTo(pivot) < 0) {
                 i++;
                 swap(array, i, j);
             }
         }
         swap(array, i + 1, high);
         return i + 1;
     }
 
     /**
      * Intercambia dos elementos en un arreglo.
      *
      * @param array Arreglo donde se realiza el intercambio.
      * @param i     Índice del primer elemento.
      * @param j     Índice del segundo elemento.
      */
     private static void swap(Comparable[] array, int i, int j) {
         Comparable temp = array[i];
         array[i] = array[j];
         array[j] = temp;
     }
 
     /**
      * Ordena un arreglo utilizando el algoritmo Radix Sort.
      *
      * @param array Arreglo a ordenar.
      */
     public static void radixSort(Comparable[] array) {
         if (array.length == 0) return;
 
         int max = Arrays.stream(array).mapToInt(num -> (Integer) num).max().orElse(0);
         for (int exp = 1; max / exp > 0; exp *= 10) {
             countingSortByDigit(array, exp);
         }
     }
 
     /**
      * Realiza una ordenación por dígitos en el algoritmo Radix Sort.
      *
      * @param array Arreglo a ordenar.
      * @param exp   Dígito significativo actual.
      */
     private static void countingSortByDigit(Comparable[] array, int exp) {
         int n = array.length;
         Integer[] output = new Integer[n];
         int[] count = new int[10];
 
         for (Comparable num : array) {
             int digit = ((Integer) num / exp) % 10;
             count[digit]++;
         }
 
         for (int i = 1; i < 10; i++) {
             count[i] += count[i - 1];
         }
 
         for (int i = n - 1; i >= 0; i--) {
             int num = (Integer) array[i];
             int digit = (num / exp) % 10;
             output[count[digit] - 1] = num;
             count[digit]--;
         }
 
         System.arraycopy(output, 0, array, 0, n);
     }
 
     /**
      * Ordena un arreglo utilizando el algoritmo Heap Sort.
      *
      * @param array Arreglo a ordenar.
      */
     public static void heapSort(Comparable[] array) {
         int n = array.length;
 
         for (int i = n / 2 - 1; i >= 0; i--) {
             heapify(array, n, i);
         }
 
         for (int i = n - 1; i >= 0; i--) {
             swap(array, 0, i);
             heapify(array, i, 0);
         }
     }
 
     /**
      * Mantiene la propiedad de montón en el arreglo.
      *
      * @param array Arreglo a reorganizar.
      * @param n     Tamaño del montón.
      * @param i     Índice del nodo actual.
      */
     private static void heapify(Comparable[] array, int n, int i) {
         int largest = i;
         int left = 2 * i + 1;
         int right = 2 * i + 2;
 
         if (left < n && array[left].compareTo(array[largest]) > 0) {
             largest = left;
         }
 
         if (right < n && array[right].compareTo(array[largest]) > 0) {
             largest = right;
         }
 
         if (largest != i) {
             swap(array, i, largest);
             heapify(array, n, largest);
         }
     }
 }
 