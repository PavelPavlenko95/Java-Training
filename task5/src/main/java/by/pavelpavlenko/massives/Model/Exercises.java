package by.pavelpavlenko.massives.Model;

import by.pavelpavlenko.massives.View.DataPrinter;
import by.pavelpavlenko.massives.View.DataScanner;

public class Exercises extends Methods {


    public void makeExercise4() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        boolean result = true;
        int arrayN = dataScanner.scanArrayN();
        double[] array = dataScanner.scanArray(arrayN);
        result = isElementsIncreasing(array);
        dataPrinter.printResultExercise4(result);
    }

    public void makeExercise9() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        int arrayN = dataScanner.scanArrayN();
        double[] array = dataScanner.scanArray(arrayN);
        dataPrinter.printArrayExercise9(array);
        swapElements(array, maxElement(array), minElement(array));
        dataPrinter.printChangedArrayExercise9(array);
    }

    public void makeExercise14() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        int arrayN = dataScanner.scanArrayN();
        double[] array = dataScanner.scanArray(arrayN);
        dataPrinter.printResultExercise14(maxEven(array), minOdd(array));
    }

    public void makeExercise19() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        int arrayN = dataScanner.scanArrayN();
        int[] array = dataScanner.scanIntArray(arrayN);
        dataPrinter.printResultExercise19(findTheMostFrequentNumber(array));
    }

    public void makeExerciseExtra1() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        int arrayN = dataScanner.scanArrayN();
        int[] array = dataScanner.scanIntArray(arrayN);
        dataPrinter.printArrayExercise1(array);
        reverse(array);
        dataPrinter.printArrayReversed(array);
        int positions = dataScanner.scanPosition();
        move(array, positions);
        dataPrinter.printArrayExercise1(array);
    }
}
