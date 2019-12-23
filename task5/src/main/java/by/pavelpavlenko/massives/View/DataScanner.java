package by.pavelpavlenko.massives.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {

    private Scanner in = new Scanner(System.in);

    public int scanExerciseNumber() {
        int result = 0;
        System.out.println("Введите номер задачи(4,9,14,19,1(дополнительное). Для выхода - любое другое значение):");
        try {
            do {
                switch (in.nextInt()) {
                    case 4:
                        result = 1;
                        break;
                    case 9:
                        result = 2;
                        break;
                    case 14:
                        result = 3;
                        break;
                    case 19:
                        result = 4;
                        break;
                    case 1:
                        result = 5;
                    default:
                        break;
                }
            } while (result == 0);
        } catch (InputMismatchException e) {
        }
        return result;
    }

    public int scanArrayN() {
        int arrayN = 0;
        try {
            System.out.println("Введите количество элементов в массиве: ");
            arrayN = in.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return arrayN;
    }

    public double[] scanArray(int arrayN) {
        double[] array = new double[arrayN];
        for (int i = 0; i < arrayN; i++) {
            try {
                System.out.println("Введите " + (i + 1) + " элемент массива:");
                array[i] = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Данные введены некорректно!");
            }
        }
        return array;
    }

    public int[] scanIntArray(int arrayN) {
        int[] array = new int[arrayN];
        for (int i = 0; i < arrayN; i++) {
            try {
                System.out.println("Введите " + (i + 1) + " элемент массива:");
                array[i] = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Данные введены некорректно!");
            }
        }
        return array;
    }

    public int scanPosition() {
        int position = 0;
        try {
            System.out.println("Введите количество элементов для сдвига: ");
            position = in.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return position;
    }
}
