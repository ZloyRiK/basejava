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

    public TextSection(String titleOfBlock, String subTitle) {
        Objects.requireNonNull(titleOfBlock, "Title value can't be null");
        this.titleOfBlock = titleOfBlock;
        this.subTitle = subTitle;
    }

    public TextSection(String titleOfBlock, String subTitle, String description) {
        Objects.requireNonNull(titleOfBlock, "Title value can't be null");
        this.titleOfBlock = titleOfBlock;
        this.subTitle = subTitle;
        this.description = description;
    }

    public String getTitleOfBlock() {
        return titleOfBlock;
    }

    public void setTitleOfBlock(String titleOfBlock) {
        Objects.requireNonNull(titleOfBlock, "Title value can't be null");
        this.titleOfBlock = titleOfBlock;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        StringBuilder sb = new StringBuilder();
        if (titleOfBlock != null) {
            sb.append(titleOfBlock).append("\n");
        }
        if (subTitle != null) {
            sb.append(subTitle).append("\n");
        }
        sb.append(description);
        return sb.toString() +"\n";
    }
}
