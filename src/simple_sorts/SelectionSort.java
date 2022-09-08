package simple_sorts;

import util.NewArray;

import java.io.FileNotFoundException;

/**
 * Worst time -> O(n^2)
 * Average time -> O(n^2)
 * Best time -> O(n^2)
 * <p>
 * Memory -> O(1)
 */
public class SelectionSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        int tempIdx;
        for (int i = 0; i < array.length - 1; i++) {
            tempIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[tempIdx]) tempIdx = j;
            }

            array[i] ^= array[tempIdx];
            array[tempIdx] ^= array[i];
            array[i] ^= array[tempIdx];
        }

        long end = System.currentTimeMillis();

        return (end - start);
    }
}
