package by.pavelpavlenko.loops.Controller;

import by.pavelpavlenko.loops.Model.Exercises;

public class Runner {


    public static void main(String[] args) {

        DataScanner dataScanner = new DataScanner();
        Exercises exercises = new Exercises();
        boolean exit = false;

        do {
            switch (dataScanner.scanExerciseNumber()) {
                case 1:
                    exercises.makeExercise9();
                    break;
                case 2:
                    exercises.makeExercise19();
                    break;
                case 3:
                    exercises.makeExercise22();
                    break;
                case 4:
                    exercises.makeExercise32();
                    break;
                case 5:
                    exercises.makeExtraExercise1();
                default:
                    exit = true;
                    break;

            }
        } while (!exit);

    }


    //    enum Seasons{
//
//
//
//    }

//    enum Seasons {
//
//        Winter("Winter"),
//        Spring("Spring"),
//        Summer("Summer"),
//        Autumn("Autumn");
//        private String name;
//
//        Seasons(String name){
//            this.name = name;
//        }
//
//    }


//        var month = JUN;
//        var value = switch(month) {
//            case JAN, JUN, JUL -> 3;
//            case FEB, SEP, OCT, NOV, DEC -> 1;
//            case MAR, MAY, APR, AUG -> 2;
//        };
//
//        System.out.println(value);3


//        Задача 32
//


    //Задача с пз 1
//        Date date = new Date();
//
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("1. Ввести дату \n2. Следующий день \n3. Выход");
//        boolean outOfLoop = true;
//        while (outOfLoop)
//        switch (in.nextInt()){
//            case 1:
//                try{
//                    do {
//                        System.out.println("Введите день: ");
//                        date.day = in.nextInt();
//                    }while (0>date.day || date.day>32);
//                    do {
//                        System.out.println("Введите месяц: ");
//                        date.month = in.nextInt();
//                    }while (0>date.month || date.month>12);
//                    do {
//                        System.out.println("Введите год: ");
//                        date.year = in.nextInt();
//                    }while (0>date.year);
//                    System.out.println("День: " + date.day + "\nМесяц: " + date.month + "\nГод: " + date.year);
//                }catch (InputMismatchException e){
//                    System.out.println("Введите данные корректно!");
//                }
//                break;
//            case 2:
//                date.nextDay();
//                System.out.println("День: " + date.day + "\nМесяц: " + date.month + "\nГод: " + date.year);
//                break;
//            case 3:
//                outOfLoop = false;
//                break;
//                default:
//                    break;
//        }

    // Задача с пз 2

//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите номер месяца:");
//        String result;

//        String[] mounths = new String[]{"Зима", "Весна", "Лето", "Осень"};
//
//        switch (in.nextInt()) {
//            case 12:
//            case 1:
//            case 2:
//                result = mounths[0];
//                break;
//            case 3:
//            case 4:
//            case 5:
//                result = mounths[1];
//                break;
//            case 6:
//            case 7:
//            case 8:
//                result = mounths[2];
//                break;
//            case 9:
//            case 10:
//            case 11:
//                result = mounths[3];
//                break;
//            default:
//                throw new IllegalArgumentException("Month number is incorrect");
//        }
//
//        System.out.println("Период года: " + result);

//        switch (in.nextInt()){
//            case 12:
//            case 1:
//            case 2:
//                result = Seasons.Winter.name;
//                break;
//            case 3:
//            case 4:
//            case 5:
//                result = Seasons.Spring.name;
//                break;
//            case 6:
//            case 7:
//            case 8:
//                result = Seasons.Summer.name;
//                break;
//            case 9:
//            case 10:
//            case 11:
//                result = Seasons.Autumn.name;
//                break;
//            default:
//                throw new IllegalArgumentException("Month number is incorrect");
//        }
//              System.out.println("Период года: " + result);


    //1237рублей <10000
    //одна тысяча двести тридцать семь

    //сумму элементов массива рекрсия
//        int mas[] = new int[100];
//
//        Random randomGenerator = new Random();
//        for (int i=0;i<100;i++)
//        {
//            mas[i] = randomGenerator.nextInt(100);
//            System.out.println(mas[i] + " ");
//            System.out.println();
//
//        }
//        int sum = Sum(99, mas);
//        System.out.println(sum);


    //быстрая сортировка/ сортировка слиянием


//    public static int Sum(int N, int mas[])
//    {
//        if (N==0) return mas[0]; else return mas[N]+Sum(N-1, mas);
//    }

//    private static int Sign(int x){
//        return (x<0) ? -1 : (x>0) ? 1 : 0;
//    }
}
