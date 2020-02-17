package by.pavelpavlenko.Task1_CompositeLight.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public String readFile(final String p) {
        String text = "";

        List<String> lines = new ArrayList<>();
        Path path = Paths.get(p);
        try (Stream<String> lineStream = Files.lines(path)) {
            lines =  lineStream.map(str -> str + '\n').collect(Collectors.toList());
        } catch (IOException ignored) {
        }
        for (String line : lines) {
            text += line;
        }
        return text;
    }


}