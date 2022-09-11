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
public class MergeSort {
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        array = new int[NewArray.getArraySize()];
        NewArray.fillArray(array);

        long time = sortArray();

        System.out.println("Sort took: " + time + "ms.");
    }

    private static long sortArray() {
        long start = System.currentTimeMillis();

        int[] tempArr = new int[array.length];
        mergeSort(tempArr, 0, array.length - 1);


        long end = System.currentTimeMillis();

        return (end - start);
    }

    private static void mergeSort(int[] tempArr, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int middle = (endIdx + startIdx) / 2;

            mergeSort(tempArr, startIdx, middle);
            mergeSort(tempArr, middle + 1, endIdx);

            int k = startIdx;
            for (int i = startIdx, j = middle + 1; (i <= middle) || (j <= endIdx); ) {
                if ((j > endIdx) || ((i <= middle) && (array[i] < array[j]))) {
                    tempArr[k] = array[i];
                    i++;
                } else {
                    tempArr[k] = array[j];
                    j++;
                }
                k++;
            }

            for (int i = startIdx; i <= endIdx; i++) {
                array[i] = tempArr[i];
            }
        }
    }
}
