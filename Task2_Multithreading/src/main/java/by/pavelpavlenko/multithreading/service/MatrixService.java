package by.pavelpavlenko.multithreading.service;

public interface MatrixService {

    void readMatrix(String path);

    void fillMatrixLocker();

    void fillMatrixCountDown();

    void fillMatrixCyclicBarrier();

    void fillMatrixSemaphore();

    boolean showMatrix();

}