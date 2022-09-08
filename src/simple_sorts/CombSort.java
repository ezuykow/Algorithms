package simple_sorts;

import util.NewArray;

import java.io.FileNotFoundException;

/**
 * Worst time -> O(n^2)
 * Average time -> O(n^2 / 2^p).  (p - increments count)
 * Best time -> O(n * log(n))
 * <p>
 * Memory -> O(1)
 */
public class CombSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        float factor = 1.247F;
        int step = (int) (array.length / factor);
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i + step < array.length; i++) {
                if (array[i] > array[i + step]) {
                    isSorted = false;

                    array[i] ^= array[i + step];
                    array[i + step] ^= array[i];
                    array[i] ^= array[i + step];
                }
            }

            step = (int) (step / factor);
            if (step <= 1) step = 1;
        }

        long end = System.currentTimeMillis();

        return (end - start);
    }
}
