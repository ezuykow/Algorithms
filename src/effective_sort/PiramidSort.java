package effective_sort;

import util.NewArray;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Worst time -> O(n * log(n))
 * Average time -> O(n * log(n))
 * Best time -> O(n * log(n))
 * <p>
 * Memory -> O(n)
 */
public class PiramidSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            array[0] ^= array[i];
            array[i] ^= array[0];
            array[0] ^= array[i];

            heapify(i, 0);
        }

        long end = System.currentTimeMillis();

        return (end - start);
    }

    private static void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if ((left < n) && (array[left] > array[largest])) largest = left;

        if ((right < n) && (array[right] > array[largest])) largest = right;

        if (largest != i) {
            array[i] ^= array[largest];
            array[largest] ^= array[i];
            array[i] ^= array[largest];

            heapify(n, largest);
        }
    }
}
