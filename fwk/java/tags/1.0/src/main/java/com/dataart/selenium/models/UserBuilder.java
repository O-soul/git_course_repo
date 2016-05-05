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
        user.setFname("userFname");
        user.setLname("userLname");
        return user;
    }
    
    public static User newUserRegistration(){
    	User user = new User("newuser", "12345newuser");
        user.setFname("newUserFname");
        user.setLname("newUserLname");
        return user;
    }
    
    public static User newDeveloperRegistration() {   
        User user = new User("developer", "12345developer");
        user.setFname("devFname");
        user.setLname("devLname");
        return user;
    }
    
    public static User nextUserRegistration(){
    	User user = new User("nextuser", "12345nextuser");
        user.setFname("nextUserFname");
        user.setLname("nextUserLname");
        return user;
    }
}
