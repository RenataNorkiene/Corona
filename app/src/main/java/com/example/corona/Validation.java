package com.example.corona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[a-zA-Z0-9]{3,20}$";
    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z0-9.!@_]{5,20}$";
    public static final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";


    public static boolean isUsernameValid(String username) {
        return isCredentialsValid(username, USERNAME_REGEX_PATTERN);
    }

    public static boolean isPasswordValid(String password) {
        return isCredentialsValid(password, PASSWORD_REGEX_PATTERN);
    }

    public static boolean isEmailValid(String email) {
        return isCredentialsValid(email, EMAIL_REGEX_PATTERN);
    }

    private static boolean isCredentialsValid(String string, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern); //sukuriamos taisyklės, pagal kurias vyks validacija
        Matcher matcher = pattern.matcher(string);  //matcher yra svarstyklės,
        return matcher.find();  //jei tinka, grąžins true
    }
}




