package effective_sort;

import util.NewArray;

import java.io.FileNotFoundException;

/**
 * Worst time -> O(n^2)
 * Average time -> O(n * log(n))
 * Best time -> O(n)
 * <p>
 * Memory -> O(n)
 */
public class QuickSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        quickSort(0, array.length - 1);

        long end = System.currentTimeMillis();

        return (end - start);
    }

    private static void quickSort(int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int middle = partition(startIdx, endIdx);
            quickSort(startIdx, middle - 1);
            quickSort(middle + 1, endIdx);
        }
    }

    private static int partition(int startIdx, int endIdx) {
        int support = array[endIdx];
        int low = startIdx;

        for (int i = startIdx; i < endIdx; i++) {
            if (array[i] <= support) {
                swap(i, low);
                low++;
            }
        }

        swap(low, endIdx);
        return low;
    }

    private static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
