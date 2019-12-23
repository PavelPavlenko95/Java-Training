package by.pavelpavlenko.massives2.SortingAlgorithms;

public class CocktailSort {

    public int[] sort(int[] array){

        int left = 0;
        int right = array.length-1;
        int k = 0; //индекс последнего обмена

        while (left<right){
            for (int j =left; j<right; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    k = j;
                }
            }
            right = k;
            for (int j = right-1; j>=left; j--){
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    k = j;
                }
            }
            left = k+1;
        }
        return array;
    }



}
