package by.pavelpavlenko.loops.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {


    private Scanner in = new Scanner(System.in);

    int scanExerciseNumber() {

        int result = 0;
        System.out.println("Введите номер задачи(9,19,22,32,1(задача о дате), для выхода - любое другое значение):");
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

    public float[] scanDataExercise9() {

        float[] outputData = new float[3];
        try {
            System.out.println("Введите длину первой стороны:");
            float side1 = in.nextFloat();
            System.out.println("Введите длину второй стороны:");
            float side2 = in.nextFloat();
            System.out.println("Введите длину третьей стороны:");
            float side3 = in.nextFloat();
            outputData[0] = side1;
            outputData[1] = side2;
            outputData[2] = side3;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    public float[] scanDataExercise19() {
        float[] outputData = new float[3];
        try {
            System.out.println("Введите a:");
            float a = in.nextFloat();
            System.out.println("Введите b:");
            float b = in.nextFloat();
            System.out.println("Введите c:");
            float c = in.nextFloat();
            outputData[0] = a;
            outputData[1] = b;
            outputData[2] = c;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;

    }

    public float[] scanDataExercise22() {
        float[] outputData = new float[2];
        try {
            System.out.println("Введите x:");
            float x = in.nextFloat();
            System.out.println("Введите y:");
            float y = in.nextFloat();
            outputData[0] = x;
            outputData[1] = y;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    public int[] scanDataExtraExercise1() {
        int[] outputData = new int[3];
        try {
            System.out.println("Введите месяц:");
            int mounth = in.nextInt();
            System.out.println("Введите день:");
            int day = in.nextInt();
            System.out.println("Введите год:");
            int year = in.nextInt();
            outputData[0] = day;
            outputData[1] = mounth;
            outputData[2] = year;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }

    public int scanDataActionExtraExercise1() {
        int outputData = 0;
        System.out.println("Введите следующее действие (1-следующий день, 2-предыдущий день):");
        try {
            switch (in.nextInt()) {
                case 1:
                    outputData = 1;
                    break;
                case 2:
                    outputData = 2;
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
        }
        return outputData;
    }
}
