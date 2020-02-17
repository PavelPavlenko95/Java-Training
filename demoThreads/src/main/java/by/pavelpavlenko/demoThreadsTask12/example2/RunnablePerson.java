package by.pavelpavlenko.demoThreadsTask12.example2;

public class RunnablePerson extends Person implements Runnable {
    public RunnablePerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());
        for (int i = 0; i<10; i++){
            System.out.println(getName() + "Hello World");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        RunnablePerson p1 = new RunnablePerson("Alice");
        Thread t1 = new Thread(p1 , "AliceThread");
        t1.start();
        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread t2 = new Thread(p2, "BobThread");
        t2.start();
        t1.setPriority(3);
        t2.setPriority(7);

        t1.join();
        t2.join();


        System.out.println("main stopped");
    }
}
