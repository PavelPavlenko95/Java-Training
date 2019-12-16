package by.pavelpavlenko.loops.Controller;

public class DataPrinter {

    public void printResultExercise9true() {
        System.out.println("Треугольник равносторонний.");
    }

    public void printResultExercise9false() {
        System.out.println("Треугольник не равносторонний.");
    }

    public void printDataIsIncorrect() {
        System.out.println("Введенные данные не позволяют решить задачу. Попробуйте снова.");
    }

    public void printResultExercise19(int result) {
        System.out.println("Количество положительных чисел:" + result);
    }

    public void printResultExercise22(float x, float y) {
        System.out.println("x: " + x + "\ny: " + y);
    }

    public void printResultExercise32(boolean result) {
        System.out.println("Сумма любых двух чисел положительна: " + result);
    }

    public void printResultDate(int[] outputDate){
        System.out.println("День: " + outputDate[0] + "\nМесяц: " + outputDate[1] + "\nГод: " + outputDate[2]);
    }

    public void printResultDateIncorrect(){
        System.out.println("Дата введена некорректно.");
    }
}
