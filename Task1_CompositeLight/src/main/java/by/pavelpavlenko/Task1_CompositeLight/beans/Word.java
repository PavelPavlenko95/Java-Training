package by.pavelpavlenko.Task1_CompositeLight.beans;

import java.util.List;

public class Word implements Component {

    private List<Component> characters;

    public int getSize() {
        return characters.size();
    }

    @Override
    public void addComponent(final Component component) {
        characters.add(component);
    }

    @Override
    public Component getChild(final int i) {
        return characters.get(i);
    }

    public void setCharacters(final List<Component> characters) {
        this.characters = characters;
    }

    public void remove(final Component component) {
        characters.remove(component);
    }

    @Override
    public String assemble() {
        String str = "";
        for (Component character : characters) {
            str += character.assemble();
        }
        return str;
    }

    public int hashCode() {
        return characters.hashCode();
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Word object = (Word) o;
        return (object.characters.equals(characters));
    }
}
