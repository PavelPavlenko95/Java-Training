package by.pavelpavlenko.multithreading.dao;

import by.pavelpavlenko.multithreading.exception.MatrixException;

public interface MatrixReader {

    int[] getThreadData();

    int[][] read(String str) throws MatrixException;
}
