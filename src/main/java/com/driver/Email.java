package com.driver;

public class Email {

    private String emailId;
    private String password;

    
    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(password) && isPasswordValid(newPassword)) {
            password = newPassword;
            return true;
        }
        return false;
    }

    private boolean isPasswordValid(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    

}
}
