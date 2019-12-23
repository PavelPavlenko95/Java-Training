package by.pavelpavlenko.massives2.SortingAlgorithms;

public class SelectionSortBidirectional {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int minIndex = i;
            int maxIndex = i;
            int min = array[i];
            int max = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
                if (array[j] > max){
                    max = array[j];
                    maxIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
            if (i != maxIndex){
                int tmp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = tmp;
            }
            System.out.println();
            for (int k = 0; k < 10; k++) {
                System.out.print(array[k] + " ");
            }
        }
        return array;
    }
}
