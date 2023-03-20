package ru.sevsu.kirillrudnikov.crud.entity;

public enum UserRole {
    GUEST("Guest"),
    USER("User"),
    ADMINISTRATOR("Administrator");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}