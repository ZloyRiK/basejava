package model;

public class TextSection extends AbstractSection{


    private String value;

    public TextSection(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}
