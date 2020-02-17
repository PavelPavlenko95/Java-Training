package by.pavelpavlenko.demoThreadsTask12.example5;

public class DaemonRunner {

    public static void main(String[] args) {
        SimpleThread usual = new SimpleThread();
        SimpleThread daemon = new SimpleThread();
        daemon.setDaemon(true);
        usual.start();
        System.out.println("последний main");
    }
}
