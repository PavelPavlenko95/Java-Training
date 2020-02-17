package by.pavelpavlenko.Task1_CompositeLight.controller;

import by.pavelpavlenko.Task1_CompositeLight.beans.Paragraph;
import by.pavelpavlenko.Task1_CompositeLight.beans.Sentence;
import by.pavelpavlenko.Task1_CompositeLight.beans.Text;
import by.pavelpavlenko.Task1_CompositeLight.service.parser.CharacterParser;
import by.pavelpavlenko.Task1_CompositeLight.service.parser.ParagraphParser;
import by.pavelpavlenko.Task1_CompositeLight.service.parser.SentenceParser;
import by.pavelpavlenko.Task1_CompositeLight.service.parser.WordParser;
import by.pavelpavlenko.Task1_CompositeLight.dao.FileReader;
import by.pavelpavlenko.Task1_CompositeLight.service.sorter.Sorter;

public class Runner {

    public static void main(String[] args) {

        String text = new FileReader().readFile("src/main/resources/input.txt");

        CharacterParser characterParser = new CharacterParser();
        WordParser wordParser = new WordParser(characterParser);
        SentenceParser sentenceParser = new SentenceParser(wordParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);


        try {
            Text textComposite = new Text(text);
            textComposite.setParagraphs(paragraphParser.handleRequest(text));
            System.out.println(textComposite.assemble());
            textComposite.setParagraphs(Sorter.sortParagraphs(textComposite));
            System.out.println(textComposite.assemble());

            Sentence sentence = new Sentence();
            sentence.setWords(Sorter.sortWords(textComposite, 2, 0));
            System.out.println(sentence.assemble());

            Paragraph paragraph = new Paragraph();
            paragraph.setSentences(Sorter.sortSentences(textComposite, 2));
            System.out.println(paragraph.assemble());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
