package com.driver;

public class Email {

    private String emailId;
    private String password;

    
    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void changePassword(String oldPassword, String newPassword) {
    if (oldPassword.equals(password) && isValidPassword(newPassword)) {
        password = newPassword;
    }
}

private boolean isValidPassword(String password) {
    if (password.length() < 8) {
        return false;
    }
    boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecial = false;
    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) {
            hasUpperCase = true;
        } else if (Character.isLowerCase(c)) {
            hasLowerCase = true;
        } else if (Character.isDigit(c)) {
            hasDigit = true;
        } else {
            hasSpecial = true;
        }
    }
    return hasUpperCase && hasLowerCase && hasDigit && hasSpecial;
}
}
}
