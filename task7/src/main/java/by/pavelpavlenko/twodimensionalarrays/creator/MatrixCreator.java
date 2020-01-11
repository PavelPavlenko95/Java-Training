package by.pavelpavlenko.twodimensionalarrays.creator;

import by.pavelpavlenko.twodimensionalarrays.entity.Matrix;
import by.pavelpavlenko.twodimensionalarrays.exceptions.MatrixException;

public class MatrixCreator {
    public static void fillRandomized(Matrix t, int start, int end) {
        int v = t.getVerticalSize();
        int h = t.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                try {
                    int value = (int) (Math.random() * (end - start) + start);
                    t.setElement(i, j, value);
                } catch (MatrixException e) {
                }
            }
        }
    }

    public static void fillFromSample(Matrix t) {
        int v = t.getVerticalSize();
        int h = t.getHorizontalSize();
        int value = 0;
        for (int i = 0; i < v / 2; i++) {
            for (int j = i; j < h / 2; j++) {
                try {
                    value = 1;
                    t.setElement(i, j, value);
                } catch (MatrixException e) {
                }
            }
        }
        for (int i = v-1; i >= v/2; i--) {
            for (int j = i; j >= h/2; j--) {
                try {
                    value = 1;
                    t.setElement(i, j, value);
                } catch (MatrixException e) {
                }
            }
        }
    }

    public static void fillFromSampleN(Matrix t) {
        int v = t.getVerticalSize();
        int h = t.getHorizontalSize();
        int value = 0;
        for (int i = 0; i < v ; i++) {
            for (int j = 0; j < h -i; j++) {
                try {
                    value = j+ i +1;
                    t.setElement(i, j, value);
                } catch (MatrixException e) {
                }
            }
        }
    }

    public static void showDiagonal(Matrix t){
        int v = t.getVerticalSize();
        int h = t.getHorizontalSize();
        int value = 0;
        for (int i = 0; i < v ; i++) {
            for (int j = 0; j < h; j++) {
                try {
                    if (i == j)
                        System.out.println(t.getElement(i,j));
                } catch (MatrixException e) {
                }
            }
        }
    }


// public void fillFromFile(Matrix t, File f) { /* код*/ }
// public void fillFromStream(Matrix t, InputStream input) { /* код*/ }
// public void fillFromDataBase(Matrix t, Connection conn) { /* код*/ }
}