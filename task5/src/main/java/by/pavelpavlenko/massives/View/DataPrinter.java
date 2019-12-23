package by.pavelpavlenko.massives.View;

public class DataPrinter {
    public void printResultExercise4(boolean result) {
        System.out.println("Последовательность является возрастающей: " + result);
    }

    public void printArrayExercise9(double[] array) {
        System.out.println("Массив: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printArrayExercise1(int[] array) {
        System.out.println("Массив: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printArrayReversed(int[] array) {
        System.out.println("Зеркальный массив: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printChangedArrayExercise9(double[] array) {
        System.out.println("Новый массив: ");
        for (int i = 0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printResultExercise14(double maxEven, double minOdd){
        System.out.println("Максимальный четный: " +maxEven + "\nМинимальный нечетный: " + minOdd +"\nСумма: " + (maxEven+minOdd));
    }

    public void printResultExercise19(int theMostFrequentNumber) {
        System.out.println("Наиболее часто встречающееся число: " + theMostFrequentNumber);
    }
}
