package integrals;

import java.text.DecimalFormat;

public class Main {

    private static DecimalFormat formater = null;
    private static int a = 0;
    private static int b = 10;
    private static double width;
    private static int m = 1;
    private static double approxH = 0.001;

    public static void main(String[] args) {

        formater = new DecimalFormat();
        formater.setMinimumFractionDigits(9);
        formater.setMaximumFractionDigits(9);
        width = (double) (b - a) / m;
        integralCalculating();
        derivatives();
    }

    private static double originFunction(double x) {
         return 4 * x - 7 * Math.sin(x);
//        return 2 * x;
    }

    private static double firstDerivative(double x) {
        return 4 - 7 * Math.cos(x);
    }

    private static double secondDerivative(double x) {
        return 7 * Math.sin(x);
    }

    private static void integralCalculating() {
        double result = 0;
        double x = a + width / 2;
        for (int i = 1; i <= m; i++) {
            result += originFunction(x);
            x += width;
        }
        result *= width;
        System.out.println(String.format("Интеграл = %6.3f", result));
    }


    private static void derivatives() {
        System.out.println("| j |   y`pr   |    y`t   |  ypr-yt  |||  y``pr   |   y``t   |y``pr-y``t|");
        for (int j = 0; j <= 10; j++) {
            double x = getPoint(j);
            double y = originFunction(x);
            double y1 = firstDerivative(x);
            double y1a = firstDerivativeApprox(x);
            double y2 = secondDerivative(x);
            double y2a = secondDerivativeApprox(x);

            printResultRow(j, y1, y1a, y2, y2a);
        }
    }

    private static void printResultRow(int j, double y1, double y1a, double y2, double y2a) {
        System.out.println(String.format("|%3d|%6.10s|%6.10s|%6.10s|||%6.10s|%6.10s|%6.10s|", j,
                formater.format(y1), formater.format(y1a), formater.format(y1 - y1a),
                formater.format(y2), formater.format(y2a), formater.format(y2 - y2a)));
    }

    // Плучение очередной точки для вычисления производных
    private static double getPoint(int j) {
        return a + (double) j * (b - a) / 10;
    }

    // Получение точки в интервале длиной h для приближенного вычисления производной
    private static double getX1(double x) {
        return x - approxH;
    }

    // Получение точки в интервале длиной h для приближенного вычисления производной
    private static double getX2(double x) {
        return x + approxH;
    }

    // Приближенное вычисление первой производной
    private static double firstDerivativeApprox(double x) {
        double x1 = getX1(x);
        double x2 = getX2(x);
        double fi = originFunction(x1);
        double fii = originFunction(x2);

        return (fii - fi) / 2 / approxH;
    }

    // Приближенное вычисление второй производной
    public static double secondDerivativeApprox(double x) {
        double x1 = getX1(x);
        double x2 = getX2(x);
        double f = originFunction(x);
        double f1 = originFunction(x1);
        double f2 = originFunction(x2);

        return (f2 - 2 * f + f1) / approxH / approxH;
    }

    // Вывод на экран строки итоговой таблицы


}

