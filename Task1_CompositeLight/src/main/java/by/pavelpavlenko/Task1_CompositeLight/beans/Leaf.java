package by.pavelpavlenko.Task1_CompositeLight.beans;

public class Leaf implements Component {
    @Override
    public void addComponent(Component component) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public String assemble() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
