package by.pavelpavlenko.massives2.SortingAlgorithms;

public class InsertionSort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
                for (int j=i; j>0 && array[j-1]>array[j]; j--){
                    swap(array, j-1, j);
                }
        }
        return array;
    }

    public void swap(int[] array, int firstElement, int secondElement) {
        int temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }
}
