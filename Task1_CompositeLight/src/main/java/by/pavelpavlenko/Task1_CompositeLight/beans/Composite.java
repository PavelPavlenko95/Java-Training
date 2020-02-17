package by.pavelpavlenko.Task1_CompositeLight.beans;

import java.util.ArrayList;

public abstract class Composite implements Component {

    private ArrayList<Component> components = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String assemble() {
        return null;
    }

    @Override
    public int getSize() {
        int size = components.size();
        for (int i = 0; i < size; i++) {
            components.get(i).getSize();
        }
        return size;
    }
}
