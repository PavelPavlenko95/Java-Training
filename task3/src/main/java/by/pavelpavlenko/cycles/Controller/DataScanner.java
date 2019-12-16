package by.pavelpavlenko.cycles.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {

    private Scanner in = new Scanner(System.in);

    int scanExerciseNumber() {


        int result = 0;
        System.out.println("Введите номер задачи(9,19,22,32 для выхода - любое другое значение):");
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

    public double scanDataExercise19() {
        double outputData = 0;
        try {
            System.out.println("Введите число e");
            outputData = in.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;
    }


    public int[] scanDataExercise22() {
        int[] outputData = new int[3];
        try {
            System.out.println("Введите a:");
            int a = in.nextInt();
            System.out.println("Введите b:");
            int b = in.nextInt();
            System.out.println("Введите h:");
            int h = in.nextInt();
            outputData[0] = a;
            outputData[1] = b;
            outputData[2] = h;
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
        return outputData;

    }

    public String scanDataExercise32(){
        System.out.println("Введите строку(первый символ-буква или знак подчеркивания, остальные- буквы, цифры, знаки подчеркивания: ");
        String inputString = in.next();
        return inputString;
    }
}
