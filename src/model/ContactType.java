package model;

public enum ContactType {
    PHONE("Телефон"),
    MESSENGER("Мессенджер"),
    MAIL("Почта"),
    lINKS("Ссылки");

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private String title;
}
