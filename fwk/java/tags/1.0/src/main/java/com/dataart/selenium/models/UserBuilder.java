package com.dataart.selenium.models;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        return user;
    }
    
    public static User userRegistration() {   
        User user = new User("user", "12345user");
        user.setFname("user");
        user.setLname("user");
        return user;
    }
    
    public static User newUserRegistration(){
    	User user = new User("newuser", "12345newuser");
        user.setFname("newuser");
        user.setLname("newuser");
        return user;
    }
    
    public static User newDeveloperRegistration() {   
        User user = new User("developer", "12345developer");
        user.setFname("dev");
        user.setLname("dev");
        return user;
    }
    
    public static User nextUserRegistration(){
    	User user = new User("nextuser", "12345nextuser");
        user.setFname("nextuser");
        user.setLname("nextuser");
        return user;
    }
}
