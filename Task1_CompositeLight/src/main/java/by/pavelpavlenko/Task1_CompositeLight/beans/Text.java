package by.pavelpavlenko.Task1_CompositeLight.beans;

import java.util.List;

public class Text implements Component {

    private List<Component> paragraphs;

    public int getSize() {
        return paragraphs.size();
    }

    public Text(final String text)  {
    }

    public void remove(final Component component) {
        paragraphs.remove(component);
    }

    @Override
    public String assemble() {
        String str = "";
        for (Component paragraph : paragraphs) {
            str = str + "\n\t" + paragraph.assemble();
        }
        return str;
    }

    @Override
    public void addComponent(final Component component) {
        paragraphs.add(component);
    }

    @Override
    public Component getChild(final int i) {
        return paragraphs.get(i);
    }

    public void setParagraphs(final List<Component> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public int hashCode() {
        return paragraphs.hashCode();
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
        Text object = (Text) o;
        return (object.paragraphs.equals(paragraphs));
    }
}
