package by.pavelpavlenko.Task1_CompositeLight.beans;

public class Character implements Component {

    private String character;

    public Character(final String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public int getSize() {
        return 1;
    }

    @Override
    public void addComponent(final Component component) {
    }

    @Override
    public Component getChild(final int i) {
        return null;
    }

    @Override
    public String assemble() {
        return character;
    }

    public void remove(final Component component) {
    }

    public int hashCode() {
        return character.hashCode();
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
        Character object = (Character) o;
        return (object.character.equals(character));
    }
}
