package by.pavelpavlenko.loops.Model;

import by.pavelpavlenko.loops.Controller.DataPrinter;
import by.pavelpavlenko.loops.Controller.DataScanner;
import by.pavelpavlenko.loops.Controller.DataValidator;

public class Exercises {

    public void makeExercise9() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();

        float[] outputData = dataScanner.scanDataExercise9();
        float side1 = outputData[0];
        float side2 = outputData[1];
        float side3 = outputData[2];
        if (dataValidator.isDataValidExercise9(side1, side2, side3)) {
            if (side1 == side2 && side2 == side3)
                dataPrinter.printResultExercise9true();
            else dataPrinter.printResultExercise9false();
        } else dataPrinter.printDataIsIncorrect();

    }


    public void makeExercise19() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();

        int result = 0;
        float[] outputData = dataScanner.scanDataExercise19();
        float a = outputData[0];
        float b = outputData[1];
        float c = outputData[2];
        if (a > 0) result++;
        if (b > 0) result++;
        if (c > 0) result++;
        dataPrinter.printResultExercise19(result);
    }

    public void makeExercise22() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();

        float buffer;
        float[] outputData = dataScanner.scanDataExercise22();
        float x = outputData[0];
        float y = outputData[1];
        if (x < y) {
            buffer = x;
            x = y;
            y = buffer;
        }
        dataPrinter.printResultExercise22(x, y);
    }

    public void makeExercise32() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();

        boolean result = false;
        float[] outputData = dataScanner.scanDataExercise19();
        float a = outputData[0];
        float b = outputData[1];
        float c = outputData[2];
        if (a + b > 0) result = true;
        if (b + c > 0) result = true;
        if (a + c > 0) result = true;
        dataPrinter.printResultExercise32(result);


    }

    public  void makeExtraExercise1(){

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();
        Date date = new Date();

        int[] outputData = dataScanner.scanDataExtraExercise1();
        int day = outputData[1];
        int month = outputData[0];
        int year = outputData[2];

        if (dataValidator.isDataValidExtraExercise1(day, month, year)){
            int actionData = dataScanner.scanDataActionExtraExercise1();
            if (actionData == 1) {
                outputData = date.nextDay(day, month, year);
                dataPrinter.printResultDate(outputData);
            }
            else date.previousDay(day, month, year);
        } else dataPrinter.printDataIsIncorrect();



    }
}
