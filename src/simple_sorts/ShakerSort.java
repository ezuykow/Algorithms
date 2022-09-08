package simple_sorts;

import util.NewArray;
import java.io.FileNotFoundException;

/**
 * Worst time -> O(n^2)
 * Average time -> O(n^2)
 * Best time -> O(n)
 * <p>
 * Memory -> O(1)
 */
public class ShakerSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = 0; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    array[i] ^= array[i - 1];
                    array[i - 1] ^= array[i];
                    array[i] ^= array[i - 1];
                }
            }
            left++;
        } while (left <= right);

        long end = System.currentTimeMillis();

        return (end - start);
    }
}
