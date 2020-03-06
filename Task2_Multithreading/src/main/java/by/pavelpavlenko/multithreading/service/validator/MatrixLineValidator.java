package by.pavelpavlenko.multithreading.service.validator;

import by.pavelpavlenko.multithreading.exception.MatrixException;

public final class MatrixLineValidator {

    private MatrixLineValidator() {
    }

    public static boolean validateLine(final String line) {
        if ("".equals(line)) {
            return false;
        }
        String[] arrString = line.split(" ");

        for (String s : arrString) {

            try {
                int i = Integer.parseInt(s);
                if (i < 0) {
                    throw new MatrixException();
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

}