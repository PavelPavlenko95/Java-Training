package by.pavelpavlenko.Task1_CompositeLight.beans;

public interface Component {

    public void addComponent(Component component);

    Component getChild(int i);

    void remove(Component component);

    String assemble();

    int getSize();

}