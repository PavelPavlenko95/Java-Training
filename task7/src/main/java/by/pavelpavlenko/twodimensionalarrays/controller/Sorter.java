package by.pavelpavlenko.twodimensionalarrays.controller;

import by.pavelpavlenko.twodimensionalarrays.entity.Matrix;
import by.pavelpavlenko.twodimensionalarrays.exceptions.MatrixException;

public class Sorter {

    public Matrix sort(Matrix p) throws MatrixException {
        int v = p.getVerticalSize();
        int h = p.getHorizontalSize();
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    for (int k = j; k>0 && (p.getElement(i,k-1) > p.getElement(i,k)); k--){
                        int temp = p.getElement(i,k-1);
                        p.setElement(i, k-1, p.getElement(i,k));
                        p.setElement(i, k, temp);
                    }
                }
            }
        } catch (MatrixException e) {
        }
        return p;
    }
}
