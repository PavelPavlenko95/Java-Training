package by.pavelpavlenko.demoThreadsTask12.example5;

import by.pavelpavlenko.demoThreadsTask12.example3.PriorThread;


    public class Runner {
        public static void main(String[ ] args) {

            System.out.println("Главный поток начал работу...");

            PriorThread min = new PriorThread("Min");
            PriorThread max = new PriorThread("Max");
            PriorThread norm = new PriorThread("Norm");
            min.setPriority(Thread.MIN_PRIORITY); // 1
            max.setPriority(Thread.MAX_PRIORITY); // 10
            norm.setPriority(Thread.NORM_PRIORITY); // 5
            min.start();
            norm.start();
            max.start();

            System.out.println("Главный поток завершил работу...");
        }
    }



