package by.pavelpavlenko.linearalgorithms.Controller;

import by.pavelpavlenko.linearalgorithms.Model.Exercises;

public class Runner {

    public static void main(String[] args) {

        DataScanner dataScanner = new DataScanner();
        Exercises exercises = new Exercises();
        boolean exit = false;

        do {
            switch (dataScanner.scanExerciseNumber()) {
                case 1:
                    exercises.makeExercise9();
                    break;
                case 2:
                    exercises.makeExercise19();
                    break;
                case 3:
                    exercises.makeExercise22();
                    break;
                case 4:
                    exercises.makeExercise32();
                    break;
                default:
                    exit = true;
                    break;

            }
        } while (!exit);

    }
}
