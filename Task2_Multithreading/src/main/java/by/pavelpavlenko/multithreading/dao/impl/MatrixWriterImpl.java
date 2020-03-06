package by.pavelpavlenko.multithreading.dao.impl;

import by.pavelpavlenko.multithreading.entity.Matrix;
import by.pavelpavlenko.multithreading.dao.MatrixWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MatrixWriterImpl implements MatrixWriter {

    public static final Logger LOGGER = LogManager.getLogger("by.pavelpavlenko.multithreading.view");

    public void write(final String str, final Matrix matrixBean) {

        Path path = Paths.get(str);
        List<String> lines = new ArrayList<>();

        for (int[] ints : matrixBean.getMatrix()) {
            String s = "";
            for (int anInt : ints) {
                s += anInt + " ";
            }
            lines.add(s);
        }

        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.debug("Ошибка записи");
        }

        LOGGER.debug("Матрица записана в файл");

    }
}
