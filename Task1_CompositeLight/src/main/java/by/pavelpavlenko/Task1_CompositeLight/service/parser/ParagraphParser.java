package by.pavelpavlenko.Task1_CompositeLight.service.parser;

import by.pavelpavlenko.Task1_CompositeLight.beans.Paragraph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends Parser {

    private static final String DELIMITER = "\\t";

    private Parser nextParser;

    public ParagraphParser(final Parser nextParser) {
        this.nextParser = nextParser;
    }

    public List handleRequest(final String text) {

        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        Pattern pattern = Pattern.compile(DELIMITER);
        Matcher matcher = pattern.matcher(text);
        ArrayList<Integer> pos = new ArrayList<>();
        while (matcher.find()) {
            pos.add(matcher.start());
        }
        int pastPos = 0;
        int currentPos = 0;
        for (int i = 1; i < pos.size(); i++) {
            currentPos = pos.get(i);
            String p = text.substring(pastPos, currentPos - 1);
            Paragraph paragraph = new Paragraph();
            paragraph.setSentences(nextParser.handleRequest(p));
            paragraphs.add(paragraph);
            pastPos = currentPos;
        }
        String p = text.substring(pastPos);
        Paragraph paragraph = new Paragraph();
        paragraph.setSentences(nextParser.handleRequest(p));
        paragraphs.add(paragraph);
        LOGGER.debug("Text successfully parsed.  " + paragraphs.size() + " paragraphs.");
        return paragraphs;
    }
}
