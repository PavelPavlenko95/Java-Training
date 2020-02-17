package by.pavelpavlenko.Task1_CompositeLight.comparator;

import by.pavelpavlenko.Task1_CompositeLight.beans.Component;
import by.pavelpavlenko.Task1_CompositeLight.beans.Word;

public class WordComparator implements SizeComparator {

    @Override
    public int compare(final Component o1, final Component o2) {
        Word word1 = (Word) o1;
        Word word2 = (Word) o2;
        return word1.getSize() - word2.getSize();
    }

}
