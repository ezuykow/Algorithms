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
public class InsertionSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];


            int j = i;
            while (j > 0 && (array[j - 1] > temp)) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = temp;
        }

        long end = System.currentTimeMillis();

        return (end - start);
    }
}
