package by.pavelpavlenko.demoThreadsTask12.example1;

import org.apache.log4j.Logger;

public class HelloWorld extends Thread {

    private static final Logger log = Logger.getLogger(HelloWorld.class);

    public void run(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.start();
        log.info("info");
    }

}
