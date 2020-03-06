package by.pavelpavlenko.multithreading.entity;

public final class Matrix {

    private int[][] matrixInt;

    private static Matrix matrix = null;

    private int pos = 0;

    private Matrix() {
    }

    public static Matrix getInstance() {
        if (matrix == null) {
            matrix = new Matrix();
        }
        return matrix;
    }

    public boolean showMatrix() {
        if (matrixInt == null) {
            return false;
        }

        for (int[] ints : matrixInt) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return true;
    }

    public int[][] getMatrix() {
        return matrixInt;
    }

    public void setMatrix(final int[][] matrix) {
        this.matrixInt = matrix;
    }

    public void setUnit(final int value, final int pos) {
        matrixInt[pos][pos] = value;
    }

    public void setNext(final int value) {
        if (pos < matrixInt.length) {
            matrixInt[pos][pos] = value;
            pos++;
        }
    }
}
