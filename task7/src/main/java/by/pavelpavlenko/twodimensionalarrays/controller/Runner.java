package by.pavelpavlenko.twodimensionalarrays.controller;

import by.pavelpavlenko.twodimensionalarrays.creator.MatrixCreator;
import by.pavelpavlenko.twodimensionalarrays.entity.Matrix;
import by.pavelpavlenko.twodimensionalarrays.exceptions.MatrixException;

public class Runner {

    public static void main(String[ ] args) {
        try {
            Matrix simple =  new Matrix(6,6);
            MatrixCreator.fillRandomized(simple, 1, 10);
            System.out.println(simple);
            System.out.println("Элементы по диагонали:");
            MatrixCreator.showDiagonal(simple);
            Matrix second = new Matrix(6,6);
            MatrixCreator.fillFromSample(second);
            System.out.println(second);
            Matrix third = new Matrix(6,6);
            MatrixCreator.fillFromSampleN(third);
            System.out.println(third);
            Sorter sorter = new Sorter();
            System.out.println(sorter.sort(simple));
        } catch (MatrixException ex) {
            System.err.println("Error of creating matrix " + ex);
        }
    }

}
