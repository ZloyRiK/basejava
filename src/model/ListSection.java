package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection{
    private static final long serialVersionUID = 1L;
    private List<String> list;

    public ListSection() {
    }

    public ListSection(List<String> elements) {
        Objects.requireNonNull(elements, "Elements of list can't be null");
        this.list = elements;
    }

    public ListSection(String... elements) {
        Objects.requireNonNull(elements, "Elements of list can't be null");
        this.list = Arrays.asList(elements);
    }

    public List<String> getList(){
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List Section:\n");
        for (String element : list) {
            sb.append("- ").append(element).append("\n");
        }
        return  sb.toString();
    }
}
