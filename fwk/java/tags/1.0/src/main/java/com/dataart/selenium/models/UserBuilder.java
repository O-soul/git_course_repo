package com.dataart.selenium.models;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        return user;
    }
    
    public static User newUserRegistration() {   // my method
        User user = new User("new user", "password");
        user.setFname("Oleg");
        user.setLname("Ignatyev");
        return user;
    }
}
