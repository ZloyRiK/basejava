package model;

public enum SectionType{
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Навыки"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private String title;
}
