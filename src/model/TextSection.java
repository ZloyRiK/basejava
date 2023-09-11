package model;

public class TextSection extends Section <String>{

    public TextSection(String description) {
        super.description = description;
    }

    private String description;



    public String getDescription() {
        return description;
    }
}
