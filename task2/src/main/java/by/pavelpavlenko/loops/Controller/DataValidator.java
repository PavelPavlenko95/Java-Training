package by.pavelpavlenko.loops.Controller;

import by.pavelpavlenko.loops.Model.Date;

public class DataValidator {

    public boolean isDataValidExercise9(float side1, float side2, float side3) {
        return (side1 > 0 && side2 > 0 && side3 > 0);
    }

    public boolean isDataValidExtraExercise1(int day, int month, int year) {

        Date date = new Date();
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (date.isLeap(year)) daysInMonths[1] = 29;

        return  (month> 0 && month<13 && day>0 && (day<=daysInMonths[month-1]) && year>0 && year<2021);

    }
}
