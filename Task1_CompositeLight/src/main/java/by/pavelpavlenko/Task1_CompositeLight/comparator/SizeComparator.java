package by.pavelpavlenko.Task1_CompositeLight.comparator;

import by.pavelpavlenko.Task1_CompositeLight.beans.Component;

import java.util.Comparator;

public interface SizeComparator extends Comparator<Component> {

    @Override
    int compare(Component o1, Component o2);

}
