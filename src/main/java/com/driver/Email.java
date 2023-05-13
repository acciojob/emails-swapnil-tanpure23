package com.driver;

public class Email {

    private String emailId;
    private String password;

    
    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        
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
