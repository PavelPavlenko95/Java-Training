package by.pavelpavlenko.Task1_CompositeLight.comparator;

import by.pavelpavlenko.Task1_CompositeLight.beans.Component;
import by.pavelpavlenko.Task1_CompositeLight.beans.Paragraph;

public class ParagraphComparator implements SizeComparator {

    @Override
    public int compare(final Component o1, final Component o2) {
        Paragraph paragraph1 = (Paragraph) o1;
        Paragraph paragraph2 = (Paragraph) o2;
        return paragraph1.getSize() - paragraph2.getSize();
    }

}
