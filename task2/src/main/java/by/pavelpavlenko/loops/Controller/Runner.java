package by.pavelpavlenko.loops.Controller;

import by.pavelpavlenko.loops.View.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        //Задача 9
//        float side1;
//        float side2;
//        float side3;
//
//        Scanner in = new Scanner(System.in);
//        try {
//            System.out.println("Введите длину первой стороны:");
//            side1 = in.nextFloat();
//            System.out.println("Введите длину второй стороны:");
//            side2 = in.nextFloat();
//            System.out.println("Введите длину третьей стороны:");
//            side3 = in.nextFloat();
//
//            if (side1 == side2 && side2 == side3){
//                System.out.println("Треугольник равносторонний.");
//            } else System.out.println("Треугольник не равносторонний.");
//        }catch (InputMismatchException e){
//            System.out.println("Введите данные корректно!");
//        }

        //Задача 19

//        int a;
//        int b;
//        int c;
//        int plusCounter = 0;
//
//        Scanner in = new Scanner(System.in);
//        try {
//            System.out.println("Введите a:");
//            a = in.nextInt();
//            System.out.println("Введите b:");
//            b = in.nextInt();
//            System.out.println("Введите c:");
//            c = in.nextInt();
//            if (a>0) plusCounter++;
//            if (b>0) plusCounter++;
//            if (c>0) plusCounter++;
//            System.out.println("Количество положительных: " + plusCounter);
//        }catch (InputMismatchException e){
//            System.out.println("Введите данные корректно!");
//        }

        //Задача 22
//        int x;
//        int y;
//        int buffer;
//
//        Scanner in = new Scanner(System.in);
//        try {
//            System.out.println("Введите x:");
//            x = in.nextInt();
//            System.out.println("Введите y:");
//            y = in.nextInt();
//            if (x<y) {
//                buffer = x;
//                x = y;
//                y = buffer;
//            }
//            System.out.println("x: " + x + "\ny: " + y);
//        }catch (InputMismatchException e){
//            System.out.println("Введите данные корректно!");
//        }

        //Задача 32
//        int a;
//        int b;
//        int c;
//        int plusCounter = 0;
//
//        Scanner in = new Scanner(System.in);
//        try {
//            System.out.println("Введите a:");
//            a = in.nextInt();
//            System.out.println("Введите b:");
//            b = in.nextInt();
//            System.out.println("Введите c:");
//            c = in.nextInt();
//            if (a>0) plusCounter++;
//            if (b>0) plusCounter++;
//            if (c>0) plusCounter++;
//            System.out.println("Количество положительных: " + plusCounter);
//        }catch (InputMismatchException e){
//            System.out.println("Введите данные корректно!");
//        }

        Date date = new Date();

        Scanner in = new Scanner(System.in);

        System.out.println("1. Ввести дату \n2. Следующий день");
        while (true)
        switch (in.nextInt()){
            case 1:
                try{
                    do {
                        System.out.println("Введите день: ");
                        date.day = in.nextInt();
                    }while (0>date.day || date.day>32);
                    do {
                        System.out.println("Введите месяц: ");
                        date.month = in.nextInt();
                    }while (0>date.month || date.month>12);
                    do {
                        System.out.println("Введите год: ");
                        date.year = in.nextInt();
                    }while (0>date.year);
                    System.out.println("День: " + date.day + "\nМесяц: " + date.month + "\nГод: " + date.year);
                }catch (InputMismatchException e){
                    System.out.println("Введите данные корректно!");
                }
                break;
            case 2:
                date.nextDay();
                System.out.println("День: " + date.day + "\nМесяц: " + date.month + "\nГод: " + date.year);
                break;

        }




    }

}
