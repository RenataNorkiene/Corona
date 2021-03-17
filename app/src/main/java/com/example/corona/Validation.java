package com.example.corona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[a-z0-9A-Z]{3,20}$"; //globalus kintamasis, matomas visur uz funcijos ribu

    public static boolean isUsernameValid(String username){
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN); //sukuriamos username validacijai taisykles pagal nurodyta sablona
        Matcher matcher = pattern.matcher(username); //pagal anksciau sukurtas taisykles palyginimi vartotojo ivesti duomenys(username)
        boolean isUsernameValid = matcher.find(); //jeigu atitinka - grazins true, kitu atveju - false
        return isUsernameValid;
    }   // true (1) arba false (0)

}
