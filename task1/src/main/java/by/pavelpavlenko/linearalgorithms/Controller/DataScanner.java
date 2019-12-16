package by.pavelpavlenko.linearalgorithms.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {

    private Scanner in = new Scanner(System.in);


    public float[] scanDataExercise9() {
        float[] outputData = new float[4];
        try {
            System.out.println("Введите a:");
            float a = in.nextFloat();
            System.out.println("Введите b:");
            float b = in.nextFloat();
            System.out.println("Введите c:");
            float c = in.nextFloat();
            System.out.println("Введите d:");
            float d = in.nextFloat();
            outputData[0] = a;
            outputData[1] = b;
            outputData[2] = c;
            outputData[3] = d;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    public double scanDataExercise19() {

        double outputData = 0;
        try {
            System.out.println("Введите длину стороны:");
            outputData = in.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    int scanExerciseNumber() {

        int result = 0;
        System.out.println("Введите номер задачи(9,19,22,32, для выхода - любое другое значение):");
        try {
            do {
                switch (in.nextInt()) {
                    case 9:
                        result = 1;
                        break;
                    case 19:
                        result = 2;
                        break;
                    case 22:
                        result = 3;
                        break;
                    case 32:
                        result = 4;
                        break;
                    default:
                        break;
                }
            } while (result == 0);
        } catch (InputMismatchException e) {
        }

        return result;

    }

    public int scanDataExercise22() {
        int outputData = 0;
        try {
            System.out.println("Количество секунд:");
            outputData = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    public int[] scanDataExercise32() {
        int[] outputData = new int[6];
        try {
            System.out.println("Введите m:");
            int m = in.nextInt();
            System.out.println("Введите n:");
            int n = in.nextInt();
            System.out.println("Введите k:");
            int k = in.nextInt();
            System.out.println("Введите p:");
            int p = in.nextInt();
            System.out.println("Введите q:");
            int q = in.nextInt();
            System.out.println("Введите r:");
            int r = in.nextInt();
            outputData[0] = m;
            outputData[1] = n;
            outputData[2] = k;
            outputData[3] = p;
            outputData[4] = q;
            outputData[5] = r;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;

    }
}
