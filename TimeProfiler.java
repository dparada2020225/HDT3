public class TimeProfiler {
    public static long profileSort(Runnable sortMethod) {
        long startTime = System.nanoTime();
        sortMethod.run();
        return System.nanoTime() - startTime;
    }
}