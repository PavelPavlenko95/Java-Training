package by.pavelpavlenko.aggregationcomposition.ex2.view;

import java.util.Scanner;

public class PrintReader {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public int inputChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант:");
        System.out.println("1 - ехать");
        System.out.println("2 - заправиться");
        System.out.println("3 - поменять колесо");
        System.out.println("4 - вывести информацию о машине");
        System.out.println("0 - выход");

        return scanner.nextInt();
    }

    public static int inputEngineType() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип двигателя:");
        System.out.println("1 - Бензиновый");
        System.out.println("2 - Дизельный");
        System.out.println("3 - Газовый");

        return scanner.nextInt();
    }

    public int inputWheelType() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип колеса:");
        System.out.println("1 - Зимняя резина");
        System.out.println("2 - Летняя резина");

        return scanner.nextInt();
    }

    public String inputCarModel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите марку автомобиля.");

        return scanner.nextLine();
    }


}