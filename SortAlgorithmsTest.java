import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortAlgorithmsTest {

    @Test
    public void testInsertionSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};

        SortAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSort() {
        Integer[] array = {10, -1, 2, 5, 0, 6, 4};
        Integer[] expected = {-1, 0, 2, 4, 5, 6, 10};

        SortAlgorithms.mergeSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSort() {
        Integer[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        Integer[] expected = {1, 2, 3, 4, 5, 5, 7, 8, 9};

        SortAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testRadixSort() {
        Integer[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};

        SortAlgorithms.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testHeapSort() {
        Integer[] array = {4, 10, 3, 5, 1};
        Integer[] expected = {1, 3, 4, 5, 10};

        SortAlgorithms.heapSort(array);
        assertArrayEquals(expected, array);
    }
}
