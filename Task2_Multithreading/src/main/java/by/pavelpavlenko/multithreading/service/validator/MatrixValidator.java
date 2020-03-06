package by.pavelpavlenko.multithreading.service.validator;

import by.pavelpavlenko.multithreading.exception.MatrixException;

import java.util.List;

public class MatrixValidator {

    public static void validate(final List<String> lines) throws MatrixException {
        int numberOfLines = lines.size();

        if ((numberOfLines - 1) < 8 || (numberOfLines - 1) > 12) {
            throw new MatrixException();
        }

        for (int i = 1; i < numberOfLines; i++) {
            if (lines.get(i).split(" ").length != numberOfLines - 1) {
                throw new MatrixException();
            }
        }

        int numberOfThreads = lines.get(0).split(" ").length;
        if (numberOfThreads < 4 || numberOfThreads > 6) {
            throw new MatrixException();
        }

    }

}
