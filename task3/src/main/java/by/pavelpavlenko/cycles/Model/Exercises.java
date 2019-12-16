package by.pavelpavlenko.cycles.Model;

import by.pavelpavlenko.cycles.Controller.DataPrinter;
import by.pavelpavlenko.cycles.Controller.DataScanner;
import by.pavelpavlenko.cycles.Controller.DataValidator;

import java.util.Random;

public class Exercises {

    public void makeExercise9() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();
        Random random = new Random();
        int sum = 0;
        int[] outputdata = new int[100];
        for (int i = 0; i < 100; i++) {
            outputdata[i] = random.nextInt(10);
            dataPrinter.printResultExercise9(outputdata[i]);
            sum += outputdata[i] * outputdata[i];
        }
        System.out.println("Сумма квадратов элементов: ");
        dataPrinter.printResultExercise9(sum);
    }


    public void makeExercise19() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        double[] numberSeries = new double[100];
        double e = dataScanner.scanDataExercise19();
        double sum = 0;

        for (int i=0; i<100; i++){
            numberSeries[i] = 1/Math.pow(2, i) + 1/Math.pow(3,i);
            dataPrinter.printResultExercise19(numberSeries[i]);
            if (Math.abs(numberSeries[i]) >= e) sum+= numberSeries[i];
        }
        System.out.println("Сумма членов ряда по модулю > e:");
        dataPrinter.printResultExercise19(sum);
    }

    public void makeExercise22() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();

        int[] outputData = dataScanner.scanDataExercise22();
        int a = outputData[0];
        int b = outputData[1];
        int h = outputData[2];
        double[] function = new double[(b-a)/h +1];

        for (int i=0; i<=((b-a)/h); i++){
            function[i] = Math.sin(i);
            dataPrinter.printResultExercise22(i*h +a, function[i]);
        }
    }

    public void makeExercise32() {

//        DataScanner dataScanner = new DataScanner();
//        DataPrinter dataPrinter = new DataPrinter();
//        DataValidator dataValidator = new DataValidator();
//
//        String inputString = dataScanner.scanDataExercise32();
//        char[] stringToArray = inputString.toCharArray();
//        for (int i=0; i<stringToArray.length;i++){
//            if (stringToArray[0] == U+005F)
//
//        }

    }
}
