package by.pavelpavlenko.Task1_CompositeLight.service.parser;

import by.pavelpavlenko.Task1_CompositeLight.beans.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {

    private static final String DELIMITER = "\\.\\.\\.|[.!?]";

    private Parser nextParser;

    public SentenceParser(final Parser nextParser) {
        this.nextParser = nextParser;
    }

    public List handleRequest(final String text) {


        ArrayList<Sentence> sentences = new ArrayList<>();

        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(text);
        ArrayList<Integer> pos = new ArrayList<>();
        while (matcher.find()) pos.add(matcher.end());
        int pastPos = 0;
        int currentPos = 0;
        for (int i = 0; i < pos.size(); i++) {
            currentPos = pos.get(i);
            String s = text.substring(pastPos, currentPos).trim();
            Sentence sentence = new Sentence();
            sentence.setWords(nextParser.handleRequest(s));
            sentences.add(sentence);
            pastPos = currentPos;
        }
        LOGGER.debug("Paragraph successfully parsed. " + sentences.size() + " sentences.");

        return sentences;
    }




}