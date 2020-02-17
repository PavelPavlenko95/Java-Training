package by.pavelpavlenko.demoThreadsTask12.example3;

public class Runner extends Thread {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t);
    }

}
