package by.pavelpavlenko.massives.Controller;

import by.pavelpavlenko.massives.Model.Exercises;
import by.pavelpavlenko.massives.View.DataScanner;

public class Runner {

    public static void main(String[] args) {
        DataScanner dataScanner = new DataScanner();
        Exercises exercises = new Exercises();
        boolean exit = false;
        do {
            switch (dataScanner.scanExerciseNumber()) {
                case 1:
                    exercises.makeExercise4();
                    break;
                case 2:
                    exercises.makeExercise9();
                    break;
                case 3:
                    exercises.makeExercise14();
                    break;
                case 4:
                    exercises.makeExercise19();
                    break;
                case 5:
                    exercises.makeExerciseExtra1();
                    break;
                default:
                    exit = true;
                    break;

            }
        } while (!exit);
    }
}
