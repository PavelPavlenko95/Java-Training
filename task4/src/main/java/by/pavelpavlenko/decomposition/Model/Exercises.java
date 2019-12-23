package by.pavelpavlenko.decomposition.Model;

import by.pavelpavlenko.decomposition.View.DataPrinter;
import by.pavelpavlenko.decomposition.View.DataScanner;
import by.pavelpavlenko.decomposition.Controller.DataValidator;

public class Exercises  extends Methods {
    public void makeExercise4() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();
        int result;

        int[] outputData = dataScanner.scanDataExercise4();
        int a = outputData[0];
        int b = outputData[1];
        int c = outputData[2];
        if (dataValidator.isDataValidExercise4(a, b, c)) {
            result = nok(a,b,c);
            dataPrinter.printResultExercise4(result);
        } else dataPrinter.printDataIsIncorrect();


    }

    public void makeExercise9() {
        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();
        boolean result = false;

        int[] outputData = dataScanner.scanDataExercise4();
        int a = outputData[0];
        int b = outputData[1];
        int c = outputData[2];
        if (dataValidator.isDataValidExercise4(a, b, c)) {
            if (nod(a,b) + nod(a,c) + nod(b,c) == 3){
                result = true;
                dataPrinter.printResultExercise9(result);
            } else
            dataPrinter.printResultExercise9(result);
        } else dataPrinter.printDataIsIncorrect();

    }

    public void makeExercise14() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        boolean result = false;
        int[] outputData = dataScanner.scanDataExercise14();
        int a = outputData[0];
        int b = outputData[1];

        if (digitsInNumber(a)>digitsInNumber(b)){
            dataPrinter.printResultExercise14(true);
        } else dataPrinter.printResultExercise14(false);
    }

    public void makeExercise19() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();
        int n = dataScanner.scanDataExercise19();
        if (dataValidator.isDataValidExercise19(n)) {
            long sum = oddDigitsCount(n);
            int count = countEvenDigits(sum);
            dataPrinter.printResultExercise19(sum, count);
        }else dataPrinter.printDataIsIncorrect();

    }
}
