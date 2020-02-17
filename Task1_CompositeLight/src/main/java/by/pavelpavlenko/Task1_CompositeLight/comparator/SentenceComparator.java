package by.pavelpavlenko.Task1_CompositeLight.comparator;

import by.pavelpavlenko.Task1_CompositeLight.beans.Component;
import by.pavelpavlenko.Task1_CompositeLight.beans.Sentence;

public class SentenceComparator implements SizeComparator {

    @Override
    public int compare(final Component o1, final Component o2) {
        Sentence sentence1 = (Sentence) o1;
        Sentence sentence2 = (Sentence) o2;
        return sentence1.getSize() - sentence2.getSize();
    }

}
