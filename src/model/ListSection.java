package model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection{
    List<String> elements;
    public ListSection(List<String> elements) {
        Objects.requireNonNull(elements, "Elements of list can't be null");
        this.elements=elements;
    }

    public List<String> getElements(){
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List Section:\n");
        for (String element : elements) {
            sb.append("- ").append(element).append("\n");
        }
        return  sb.toString();
    }
}
