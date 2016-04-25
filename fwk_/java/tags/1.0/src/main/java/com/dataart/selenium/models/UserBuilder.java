package com.dataart.selenium.models;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Oleg");
        user.setLname("Ignatyev");
        return user;
    }
}
