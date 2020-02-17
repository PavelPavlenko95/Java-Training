package by.pavelpavlenko.Task1_CompositeLight.service.sorter;

import by.pavelpavlenko.Task1_CompositeLight.comparator.ParagraphComparator;
import by.pavelpavlenko.Task1_CompositeLight.comparator.SentenceComparator;
import by.pavelpavlenko.Task1_CompositeLight.comparator.WordComparator;
import by.pavelpavlenko.Task1_CompositeLight.beans.Component;
import by.pavelpavlenko.Task1_CompositeLight.beans.Paragraph;
import by.pavelpavlenko.Task1_CompositeLight.beans.Sentence;
import by.pavelpavlenko.Task1_CompositeLight.beans.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public final class Sorter {

    public Sorter() {
    }

    public static final Logger LOGGER = LogManager.getLogger("by.pavelpavlenko.Task1_CompositeLight.Sorter");

    public static List<Component> sortParagraphs(final Text text) {
        ArrayList<Component> arrayList = new ArrayList<>();

        for (int i = 0; i < text.getSize(); i++) {
            arrayList.add(text.getChild(i));
        }
        arrayList.sort(new ParagraphComparator());
        LOGGER.debug("Sorting paragraph.");
        return arrayList;
    }

    public static List<Component> sortSentences(final Text text, final int numberOfParagraph) {
        Paragraph paragraph = (Paragraph) text.getChild(numberOfParagraph);

        ArrayList<Component> arrayList = new ArrayList<>();
        for (int i = 0; i < paragraph.getSize(); i++) {
            arrayList.add(paragraph.getChild(i));
        }
        arrayList.sort(new SentenceComparator());
        LOGGER.debug("Sorting sentence.");
        return arrayList;
    }

    public static List<Component> sortWords(final Text text, final int numberOfParagraph, final int numberOfSentence) {
        Paragraph paragraph = (Paragraph) text.getChild(numberOfParagraph);
        Sentence sentence = (Sentence) paragraph.getChild(numberOfSentence);

        ArrayList<Component> arrayList = new ArrayList<>();
        for (int i = 0; i < sentence.getSize(); i++) {
            arrayList.add(sentence.getChild(i));
        }
        arrayList.sort(new WordComparator());
        LOGGER.debug("Sorting words.");
        return arrayList;
    }
}