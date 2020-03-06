package by.pavelpavlenko.multithreading.entity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatrixCyclicBarrierThread implements Runnable{

    private CyclicBarrier cyclicBarrier;

    private Matrix matrix;

    private int value;

    private PosGenerator posGenerator;

    public MatrixCyclicBarrierThread(final CyclicBarrier cyclicBarrier,
                                 final Matrix matrix,
                                 final int value, final PosGenerator posGenerator) {
        this.cyclicBarrier = cyclicBarrier;
        this.matrix = matrix;
        this.value = value;
        this.posGenerator = posGenerator;
    }

    @Override
    public void run() {

        try {
            this.cyclicBarrier.await();
            matrix.setUnit(value, posGenerator.getNext());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
