package by.pavelpavlenko.demoThreadsTask12.example5;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        try{
            if (isDaemon()){
                System.out.println("старт демона потока");
                Thread.sleep(1);
            }else {
                System.out.println("старт обычного потока");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if (!isDaemon()){
                System.out.println("завершение обычного потока");
            }
            else {
                System.out.println("завершение потока демона");
            }
        }
    }
}
