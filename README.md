# Proyecto de Ordenamiento en Java

Este proyecto implementa múltiples algoritmos de ordenamiento en Java, permitiendo medir y guardar el tiempo de ejecución para distintos conjuntos de datos. Los resultados se almacenan en un archivo CSV.

## **Instrucciones de ejecución**

1. **Compilación y ejecución:**
   - Asegúrate de tener instalado Java y configurado el entorno.
   - Compila los archivos `.java`.
   ```bash
   javac Main.java FileHandler.java SortAlgorithms.java TimeProfiler.java
   ```
   - Ejecuta el programa principal:
   ```bash
   java Main
   ```

2. **Interfaz del programa:**
   - El programa genera un menú con las siguientes opciones:
     1. Mostrar números aleatorios generados.
     2. Mostrar números ordenados (del 0 al 3000).
     3. Ordenar usando **Insertion Sort**.
     4. Ordenar usando **Merge Sort**.
     5. Ordenar usando **Quick Sort**.
     6. Ordenar usando **Radix Sort**.
     7. Ordenar usando **Heap Sort**.
     8. Salir.

3. **Guardar resultados:**
   - Después de ejecutar un algoritmo de ordenamiento, el programa guarda los resultados en un archivo llamado `ResultadosOrdenamiento.csv`.
   - Los datos almacenados incluyen:
     - Nombre del algoritmo.
     - Tipo de datos utilizados (aleatorios u ordenados).
     - Tiempo de ejecución en nanosegundos.

## **Requisitos del entorno**

- Java 8 o superior.
- Sistema operativo con soporte para archivos CSV (Windows, MacOS, Linux).

## **Descripción de los archivos**

### **Main.java**
Contiene el punto de entrada del programa, el menú principal y la lógica para ejecutar los algoritmos de ordenamiento.

### **FileHandler.java**
Permite generar un archivo de números aleatorios y leer los datos desde dicho archivo.

### **SortAlgorithms.java**
Implementa los algoritmos de ordenamiento:
- Insertion Sort.
- Merge Sort.
- Quick Sort.
- Radix Sort.
- Heap Sort.

### **TimeProfiler.java**
Mide el tiempo de ejecución de un método de ordenamiento.

## **Ejemplo de resultados en CSV**

El archivo `ResultadosOrdenamiento.csv` tendrá un formato similar al siguiente:

```csv
Algoritmo,Tipo de datos,Tiempo de ejecución (ns)
Insertion Sort,Aleatorios,123456789
Merge Sort,Ordenados,98765432
Quick Sort,Aleatorios,456789123
```

## **Mejoras futuras**

- Agregar más algoritmos de ordenamiento.
- Implementar una interfaz gráfica.
- Exportar resultados en otros formatos (por ejemplo, Excel o JSON).

## **Contribución**

Las contribuciones al proyecto son bienvenidas. Puedes crear un fork del repositorio, hacer tus modificaciones y enviar un pull request.

## **Licencia**

Este proyecto está licenciado bajo los términos de la licencia MIT.

