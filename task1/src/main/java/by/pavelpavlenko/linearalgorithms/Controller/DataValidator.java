package by.pavelpavlenko.linearalgorithms.Controller;

public class DataValidator {

    public boolean isDataValidExercise9(float c, float d) {
        return (c != 0 && d != 0);
    }

    public boolean isDataValidExercise19(double sideOfTriangle) {
        return (sideOfTriangle > 0);
    }

    public boolean isDataValidExercise22(int time) {
        return (time > 0);
    }

    public boolean isDataValidExercise32(int m, int n, int k, int p, int q, int r) {
        return (m > 0 && m < 24 && n > 0 && n < 61 && k > 0 && k < 61 && p > 0 && q > 0 && r > 0);
    }
}
