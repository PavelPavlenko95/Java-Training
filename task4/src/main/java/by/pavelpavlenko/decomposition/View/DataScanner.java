package by.pavelpavlenko.decomposition.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {
    private Scanner in = new Scanner(System.in);

    public int scanExerciseNumber() {


        int result = 0;
        System.out.println("Введите номер задачи(4,9,14,19 для выхода - любое другое значение):");
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

    public int[] scanDataExercise4() {
        int[] outputData = new int[3];
        try {
            System.out.println("Введите первое натуральное число:");
            int a = in.nextInt();
            System.out.println("Введите второе натуральное число:");
            int b = in.nextInt();
            System.out.println("Введите третье натуральное число:");
            int c = in.nextInt();
            outputData[0] = a;
            outputData[1] = b;
            outputData[2] = c;

        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;


    }

    public int[] scanDataExercise14() {
        int[] outputData = new int[2];
        try {
            System.out.println("Введите первое число:");
            int a = in.nextInt();
            System.out.println("Введите второе число:");
            int b = in.nextInt();
            outputData[0] = a;
            outputData[1] = b;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    public int scanDataExercise19() {
        int n = 0;
        try {
            System.out.println("Введите n (время расчета увеличивается при n>7):");
            n = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return n;
    }
}
