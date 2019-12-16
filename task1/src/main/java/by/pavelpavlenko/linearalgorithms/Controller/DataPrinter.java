package by.pavelpavlenko.linearalgorithms.Controller;

public class DataPrinter {

    public void printResultExercise9(float result) {
        System.out.println("Результат:" + result);
    }

    public void printDataIsIncorrect() {
        System.out.println("Введенные данные не позволяют решить задачу. Попробуйте снова.");
    }

    public void printResultExercise19(double heightOfTriangle, double squareOfTriangle, double radiusInscribedCircle, double radiusCircumscribedCircle) {
        System.out.println("Высота: " + heightOfTriangle + "\nПлощадь: " + squareOfTriangle + "\nРадиус вписанной окружности: " +
                radiusInscribedCircle + "\nРадиус описанной окружности: " + radiusCircumscribedCircle);
    }

    public void printResultExercise22(int time) {
        System.out.printf("%d ч, %d мин, %d с. %n", time / 3600, time / 60 - 60 * (time / 3600), time % 60);
    }

    public void printResultExercise32(int m, int n, int k, int p, int q, int r) {
        System.out.printf("%d ч, %d мин, %d с. %n", (m + p) % 24 + (n + q) / 60, (k + r) / 60 + (n + q) % 60, (k + r) % 60);
    }
}
