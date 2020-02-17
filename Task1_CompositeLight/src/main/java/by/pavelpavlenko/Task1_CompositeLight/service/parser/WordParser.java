package by.pavelpavlenko.Task1_CompositeLight.service.parser;

import by.pavelpavlenko.Task1_CompositeLight.beans.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {

    private static final String DELIMITER = "[!?//.]|,|\\.\\.\\.";

    private static final String LEXEME = " ";

    private Parser nextParser;

    public WordParser(final Parser nextParser) {
        this.nextParser = nextParser;
    }

    public List handleRequest(String text) {
        ArrayList<Word> words = new ArrayList<>();

        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(text);
        ArrayList<Integer> position = new ArrayList<>();

        while (matcher.find()) {
            position.add(matcher.start());
        }

        for (int i = position.size() - 1; i >= 0; i--) {
            text = text.substring(0, position.get(i)) + " " + text.substring(position.get(i));
        }

        for (String s : text.split(LEXEME)) {
            Word word = new Word();
            word.setCharacters(nextParser.handleRequest(s));
            words.add(word);
        }

        LOGGER.debug("Sentence successfully parsed. " + words.size() + " words.");
        return words;
    }

}