import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static DecimalFormat formater = null;

    public static void main(String[] args) throws IOException {
        formater = new DecimalFormat();
        formater.setMinimumFractionDigits(4);
        formater.setMaximumFractionDigits(4);

        Double a;
        Double b;
        Integer m;
        Scanner s = new Scanner(System.in);
        System.out.println("Введите а:");
        a = s.nextDouble();
        System.out.println("Введите в:");
        b = s.nextDouble();
        System.out.println("Введите количество точек:");
        m = s.nextInt();
        Integer n;
        System.out.println("Введите количество неизвестных:");
        n = s.nextInt();
        System.out.println("a = " +a+",b = "+b+",m = "+m+",n = "+n);
        calculate(a, b, m);

    }

    private static void calculate(double a, double b, int m) {
        Calculator calculator = new Calculator(a, b, m);

        printFormula();
        printHeader();

        for (int i = 0; i <= 20; i++) {
            double x = getNext(a, b, 20, i);
            double y = calculator.calculateY(x);
            double f = calculator.calculateF(x);
            double d = y - f;

            printResultRow(i + 1, x, y, f, d, formater);
        }
    }

    private static void printFormula() {
        System.out.println("f = Math.pow(x,3) + 6 * Math.pow(x,2) - 0.02 * Math.pow(2.7,x)");
    }

    private static void printHeader() {
        System.out.println(" --------------------------------------------");
        System.out.println("| # |    X    |    Y    |    F    |    D    |");
        System.out.println(" --------------------------------------------");
    }

    private static double getNext(double a, double b, double m, int i) {
        return a + i * (b - a) / m;
    }

    private static void printResultRow(int i, double x, double y, double f, double d, DecimalFormat formater) {
        System.out.println(" --------------------------------------------");
        System.out.println(String.format("|%3d|%9s|%9s|%9s|%9s|", i,
                formater.format(x),
                formater.format(y),
                formater.format(f),
                formater.format(d)));
    }
}
