package by.pavelpavlenko.multithreading.service.impl;

import by.pavelpavlenko.multithreading.dao.MatrixReader;
import by.pavelpavlenko.multithreading.dao.impl.MatrixReaderImpl;
import by.pavelpavlenko.multithreading.entity.*;
import by.pavelpavlenko.multithreading.exception.MatrixException;
import by.pavelpavlenko.multithreading.service.MatrixService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixServiceImpl implements MatrixService {

    private MatrixReader matrixReader;

    private Matrix matrix;

    public static final Logger LOGGER = LogManager.getLogger("by.pavelpavlenko.multithreading.service");

    ArrayList<Integer> dataForFill = new ArrayList<>();
    PosGenerator posGenerator = new PosGenerator();

    @Override
    public void readMatrix(final String path) {
        matrixReader = new MatrixReaderImpl();
        matrix = Matrix.getInstance();
        try {
            matrix.setMatrix(matrixReader.read(path));
        } catch (MatrixException e) {
            LOGGER.debug("Ошибка ввода");
        }
    }

    @Override
    public void fillMatrixLocker() {
        ReentrantLock locker = new ReentrantLock();
        getDataForFill();

        for (int j = 0; j < dataForFill.size(); j++) {
            new Thread(new MatrixReentrantLockThread(locker, matrix, dataForFill.get(j), posGenerator)).start();
        }
        LOGGER.debug("Диагональные элементы были заполнены при помощи ReentrantLock");
    }

    @Override
    public void fillMatrixCountDown() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        getDataForFill();

        for (int j = 0; j < dataForFill.size(); j++) {
            new Thread(new MatrixCountDownThread(countDownLatch, matrix, dataForFill.get(j), posGenerator)).start();
        }
        LOGGER.debug("Диагональные элементы были заполнены при помощи CountDownLatch");
    }

    @Override
    public void fillMatrixCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        getDataForFill();

        for (int j = 0; j < dataForFill.size(); j++) {
            new Thread(new MatrixCyclicBarrierThread(cyclicBarrier, matrix, dataForFill.get(j), posGenerator)).start();
        }
        LOGGER.debug("Диагональные элементы были заполнены при помощи CyclicBarrier");
    }

    @Override
    public void fillMatrixSemaphore() {
        Semaphore semaphore = new Semaphore(2);
        getDataForFill();

        for (int j = 0; j < dataForFill.size(); j++) {
            new Thread(new MatrixSemaphoreThread(semaphore, matrix, dataForFill.get(j), posGenerator)).start();
        }
        LOGGER.debug("Диагональные элементы были заполнены при помощи Semaphore");
    }

    @Override
    public boolean showMatrix() {
        return matrix.showMatrix();
    }

    private void getDataForFill() {
        for (int i : matrixReader.getThreadData()) {
            dataForFill.add(i);
        }

        if (matrix.getMatrix().length > matrixReader.getThreadData().length) {
            int difference = matrix.getMatrix().
                    length - matrixReader.getThreadData().length;
            for (int i = 0; i < difference; i++) {
                dataForFill.add(matrixReader.getThreadData()[i]);
            }
        }
    }
}