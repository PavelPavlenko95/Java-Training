package by.pavelpavlenko.massives2.SortingAlgorithms;

import java.util.Random;

public class Runner {

    public static void main(String[] args) {

        int[] array = new int[10];
        Random randomGenerator = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = randomGenerator.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

//        SelectionSortBidirectional selectionSortBidirectional = new SelectionSortBidirectional();
//        selectionSortBidirectional.sort(array);

//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(array);

//        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.sort(array);

//        CocktailSort cocktailSort = new CocktailSort();
//        cocktailSort.sort(array);

        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        binaryInsertionSort.sort(array);

        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
