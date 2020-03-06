package by.pavelpavlenko.multithreading.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixReentrantLockThread implements Runnable {

    private ReentrantLock locker;

//    private Condition condition = locker.newCondition();

    private Matrix matrix;

    private int value;

    private PosGenerator posGenerator;

    public MatrixReentrantLockThread(final ReentrantLock locker,
                                     final Matrix matrix,
                                     final int value, final PosGenerator posGenerator) {
        this.locker = locker;
        this.matrix = matrix;
        this.value = value;
        this.posGenerator = posGenerator;
    }

    @Override
    public void run() {
        locker.lock();

        matrix.setUnit(value, posGenerator.getNext());
//        condition.signal();

        locker.unlock();
    }
}