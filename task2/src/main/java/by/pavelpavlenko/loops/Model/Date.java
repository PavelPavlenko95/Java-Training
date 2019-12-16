package by.pavelpavlenko.loops.Model;

import by.pavelpavlenko.loops.Controller.DataValidator;

public class Date {

    DataValidator dataValidator = new DataValidator();

    public boolean isLeap(int year){
        if (year%4 != 0) return false;
        else if (year%100 == 0 && year%400 != 0) return false;
        else return true;
    }

    public int[] nextDay(int day, int month, int year) {
        int[] date = {day, month, year};
        if (dataValidator.isDataValidExtraExercise1(day++, month, year)){
            date[0]++;
            return date;}
        else {
            if (dataValidator.isDataValidExtraExercise1(day--,month++, year)){
            date[0] = 1;
            date[1] = month++;
            return date;
        } else {
                date[0] = 1;
                date[1] = 1;
                year++;
                return date;
            }
    }}

    public void previousDay(int day, int month, int year) {
    }
}
