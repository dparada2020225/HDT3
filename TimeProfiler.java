/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencia de la Computación
 * Autor: Denil José Parada Cabrera - 24761, Joel Nerio-24253, Jose Rivera
 * Fecha: [Fecha actual]
 * Descripción: Clase que permite medir el tiempo de ejecución de métodos de ordenamiento.
 */

 public class TimeProfiler {

    /**
     * Mide el tiempo de ejecución de un método de ordenamiento.
     *
     * @param sortMethod Método de ordenamiento a ejecutar.
     * @return Tiempo de ejecución en nanosegundos.
     */
    public static long profileSort(Runnable sortMethod) {
        long startTime = System.nanoTime();
        sortMethod.run();
        return System.nanoTime() - startTime;
    }
}
