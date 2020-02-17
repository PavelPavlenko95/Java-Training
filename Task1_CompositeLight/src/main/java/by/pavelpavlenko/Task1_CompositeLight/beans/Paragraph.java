package by.pavelpavlenko.Task1_CompositeLight.beans;

import java.util.List;

public class Paragraph implements Component {

    private List<Component> sentences;

    public int getSize() {
        return sentences.size();
    }

    public void remove(final Component component) {
        sentences.remove(component);
    }

    @Override
    public void addComponent(final Component component) {
        sentences.add(component);
    }

    @Override
    public Component getChild(final int i) {
        return sentences.get(i);
    }

    public void setSentences(final List<Component> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String assemble() {
        String str = "";
        for (Component sentence : sentences) {
            str += sentence.assemble();
        }
        str = str.trim();
        return str;
    }

    public int hashCode() {
        return sentences.hashCode();
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
        Paragraph object = (Paragraph) o;
        return (object.sentences.equals(sentences));
    }
}
