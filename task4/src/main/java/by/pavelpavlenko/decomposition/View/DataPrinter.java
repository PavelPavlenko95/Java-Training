package by.pavelpavlenko.decomposition.View;

public class DataPrinter {

    public void printDataIsIncorrect() {
        System.out.println("Введенные данные не позволяют решить задачу. Попробуйте снова.");
    }

    public void printResultExercise4(int result) {
        System.out.println("НОК: " + result);
    }

    public void printResultExercise9(boolean result) {
        System.out.println("3 числа взаимно простые: " + result);
    }

    public void printResultExercise14(boolean b) {
        System.out.println("В первом числе цифр больше: " + b);
    }

    public void printResultExercise19(long sum, int count) {
        System.out.println("Сумма n-значных чисел, содержащих только нечетные цифры: " + sum + "\nЧётных цифр: " + count);
    }
}
