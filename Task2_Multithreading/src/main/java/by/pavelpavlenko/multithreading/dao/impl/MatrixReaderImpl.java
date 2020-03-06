package by.pavelpavlenko.multithreading.dao.impl;

import by.pavelpavlenko.multithreading.dao.MatrixReader;
import by.pavelpavlenko.multithreading.service.validator.MatrixLineValidator;
import by.pavelpavlenko.multithreading.exception.MatrixException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import by.pavelpavlenko.multithreading.service.validator.MatrixValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixReaderImpl implements MatrixReader {

    public static final Logger LOGGER = LogManager.getLogger("by.pavelpavlenko.multithreading.dao");

    private int[] threadData;

    public int[] getThreadData() {
        return threadData;
    }

    public int[][] read(final String str) throws MatrixException {

        Path path = Paths.get(str);
        List<String> list = null;
        try (Stream<String> lineStream = Files.lines(path)) {
            list = lineStream.filter(MatrixLineValidator::validateLine).
                    collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.debug("Ошибка чтения");
        }

        LOGGER.debug("Матрица прочитана");

        MatrixValidator.validate(list);

        LOGGER.debug("Валидация успешна");

        int[][] matrix = new int[list.size() - 1][list.size() - 1];

        String[] threadDataString = list.get(0).split(" ");

        threadData = new int[threadDataString.length];
        for (int i = 0; i < threadDataString.length; i++) {
            threadData[i] = Integer.parseInt(threadDataString[i]);
        }

        for (int i = 1; i < list.size(); i++) {
            int j = 0;
            for (String s : list.get(i).split(" ")) {
                matrix[i - 1][j] = Integer.parseInt(s);
                j++;
            }
        }
        return matrix;
    }
}
