package model;

public enum ContactType {
    PHONE("Телефон"),
    MESSENGER("Мессенджер"),
    MAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private String title;
}
