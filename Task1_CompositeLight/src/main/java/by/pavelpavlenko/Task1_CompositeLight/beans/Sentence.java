package by.pavelpavlenko.Task1_CompositeLight.beans;

import java.util.List;

public class Sentence implements Component {

    private List<Component> words;

    public int getSize() {
        return words.size();
    }

    @Override
    public void addComponent(final Component component) {
        words.add(component);
    }

    @Override
    public Component getChild(final int i) {
        return words.get(i);
    }

    public void setWords(final List<Component> words) {
        this.words = words;
    }

    public void remove(final Component component) {
        words.remove(component);
    }

    @Override
    public String assemble() {
        String str = "";
        String temp;
        for (Component word : words) {
            temp = word.assemble();
            if (",".equals(temp) || ".".equals(temp) || "?".equals(temp) || "!".equals(temp) || "...".equals(temp)) {
                str = str + temp;
            } else {
                str = str + " " + temp;
            }
        }
        return str;
    }

    public int hashCode() {
        return words.hashCode();
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
        Sentence object = (Sentence) o;
        return (object.words.equals(words));
    }
}