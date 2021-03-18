package com.example.corona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[a-z0-9A-Z]{3,20}$"; //globalus kintamasis, matomas visur uz funkcjos ribu

    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z0-9.!@_]{5,20}$";

    public static boolean isPasswordValid(String password){
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean isPasswordValid = matcher.find();
        return isPasswordValid;
    }

    public static boolean isUsernameValid(String username){
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN); //sukuriamos username validacijai taisykles pagal nurodyta sablona
        Matcher matcher = pattern.matcher(username); //pagal anksciau sukurtas taisykles palyginimi vartotojo ivesti duomenys(username)
        boolean isUsernameValid = matcher.find(); //jeigu atitinka - grazins true, kitu atveju - false
        return isUsernameValid;
    }   // true (1) arba false (0)

}
