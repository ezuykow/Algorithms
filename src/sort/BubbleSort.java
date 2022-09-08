package sort;

import util.NewArray;

import java.io.FileNotFoundException;

/**
 * Worst time -> O(n^2)
 * Average time -> O(n^2)
 * Best time -> O(n)
 * <p>
 * Memory -> O(1)
 */
public class BubbleSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                }
            }
        }

        long end = System.currentTimeMillis();

        return (end - start);
    }
}
