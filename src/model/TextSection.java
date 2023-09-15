package model;

import java.util.Objects;

public class TextSection extends AbstractSection {

    private String titleOfBlock;
    private String subTitle;
    private String description;

    public TextSection(String description) {
        Objects.requireNonNull(description, "Text value can't be null");
        this.description = description;
    }

    public TextSection(String subTitle, String description) {
        this.subTitle = subTitle;
        this.description = description;
    }

    public TextSection(String titleOfBlock, String subTitle, String description) {
        this.titleOfBlock = titleOfBlock;
        this.subTitle = subTitle;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return subTitle.equals(that.subTitle) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subTitle, description);
    }

    @Override
    public String toString() {
        return subTitle + "\n" + description;
    }
}
