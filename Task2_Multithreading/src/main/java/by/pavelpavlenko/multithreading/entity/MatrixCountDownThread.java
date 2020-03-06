package by.pavelpavlenko.multithreading.entity;

import java.util.concurrent.CountDownLatch;

public class MatrixCountDownThread implements Runnable {

    private CountDownLatch countDownLatch;

    private Matrix matrix;

    private int value;

    private PosGenerator posGenerator;

    public MatrixCountDownThread(final CountDownLatch countDownLatch,
                                     final Matrix matrix,
                                     final int value, final PosGenerator posGenerator) {
        this.countDownLatch = countDownLatch;
        this.matrix = matrix;
        this.value = value;
        this.posGenerator = posGenerator;
    }

    @Override
    public void run() {

        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        matrix.setUnit(value, posGenerator.getNext());

    }
}
