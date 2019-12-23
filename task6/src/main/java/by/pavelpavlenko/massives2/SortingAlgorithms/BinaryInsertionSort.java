package by.pavelpavlenko.massives2.SortingAlgorithms;

import java.util.Arrays;

public class BinaryInsertionSort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int j = Math.abs(Arrays.binarySearch(array,0 , i, x) +1);
            System.arraycopy(array, j, array, j+1, i-j);
            array[j]=x;
        }
        return array;
    }
}
