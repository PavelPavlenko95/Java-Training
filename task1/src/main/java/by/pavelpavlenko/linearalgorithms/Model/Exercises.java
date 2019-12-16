package by.pavelpavlenko.linearalgorithms.Model;

import by.pavelpavlenko.linearalgorithms.Controller.DataPrinter;
import by.pavelpavlenko.linearalgorithms.Controller.DataScanner;
import by.pavelpavlenko.linearalgorithms.Controller.DataValidator;

public class Exercises {

    public void makeExercise9() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();

        float result;
        float[] outputData = dataScanner.scanDataExercise9();
        float a = outputData[0];
        float b = outputData[1];
        float c = outputData[2];
        float d = outputData[3];
        if (dataValidator.isDataValidExercise9(c, d)) {
            result = a * b / c / d - (a * b - c) / (c * d);
            dataPrinter.printResultExercise9(result);
        } else dataPrinter.printDataIsIncorrect();

    }

    public void makeExercise19() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();

        double sideOfTriangle = dataScanner.scanDataExercise19();
        double squareOfTriangle;
        double heightOfTriangle;
        double radiusInscribedCircle;
        double radiusCircumscribedCircle;

        if (dataValidator.isDataValidExercise19(sideOfTriangle)) {
            heightOfTriangle = sideOfTriangle * Math.sqrt(3) / 2;
            squareOfTriangle = 0.5 * sideOfTriangle * heightOfTriangle;
            radiusInscribedCircle = (float) sideOfTriangle / 2 * Math.sqrt(3);
            radiusCircumscribedCircle = sideOfTriangle / Math.sqrt(3);
            dataPrinter.printResultExercise19(heightOfTriangle, squareOfTriangle, radiusInscribedCircle, radiusCircumscribedCircle);
        } else dataPrinter.printDataIsIncorrect();


    }


    public void makeExercise22() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();

        int time = dataScanner.scanDataExercise22();
        if (dataValidator.isDataValidExercise22(time)) {
            dataPrinter.printResultExercise22(time);
        } else dataPrinter.printDataIsIncorrect();

    }

    public void makeExercise32() {

        DataScanner dataScanner = new DataScanner();
        DataPrinter dataPrinter = new DataPrinter();
        DataValidator dataValidator = new DataValidator();

        int[] outputData = dataScanner.scanDataExercise32();
        int m = outputData[0];
        int n = outputData[1];
        int k = outputData[2];
        int p = outputData[3];
        int q = outputData[4];
        int r = outputData[5];
        if (dataValidator.isDataValidExercise32(m,n,k,p,q,r)){
            dataPrinter.printResultExercise32(m,n,k,p,q,r);
        }else dataPrinter.printDataIsIncorrect();
    }
}
