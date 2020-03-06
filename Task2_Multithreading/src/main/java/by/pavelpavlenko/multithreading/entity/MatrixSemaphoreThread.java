package by.pavelpavlenko.multithreading.entity;

import java.util.concurrent.Semaphore;

public class MatrixSemaphoreThread implements Runnable{

    private Semaphore semaphore;

    private Matrix matrix;

    private int value;

    private PosGenerator posGenerator;

    public MatrixSemaphoreThread(final Semaphore semaphore,
                                     final Matrix matrix,
                                     final int value, final PosGenerator posGenerator) {
        this.semaphore = semaphore;
        this.matrix = matrix;
        this.value = value;
        this.posGenerator = posGenerator;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();

            matrix.setUnit(value, posGenerator.getNext());
        }
        catch (InterruptedException e){

        }
        finally {
            semaphore.release();
        }
    }
}
