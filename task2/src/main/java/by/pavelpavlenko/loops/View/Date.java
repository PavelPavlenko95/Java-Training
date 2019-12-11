package by.pavelpavlenko.loops.View;

public class Date {

    public int day;
    public int month;
    public int year;

    public boolean isLeap(int year){
        if (year%4 != 0) return false;
        else if (year%100 == 0 && year%400 != 0) return false;
        else return true;
    }

    public void nextDay() {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(year) == true) daysInMonths[2] = 29;
        if (day < daysInMonths[month-1]){
            day ++;
        } else if (day == daysInMonths[month-1] && month <12){
            month++;
            day = 1;
        }
        else if (day == daysInMonths[month-1] && month == 12){
            year ++;
            month = 1;
            day = 1;
        }
        
    }
}
