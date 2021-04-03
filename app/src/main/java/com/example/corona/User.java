package com.example.corona;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    //1. class variables, arguments
    private String username;
    private String email;
    private String password;

    private SharedPreferences sharedPreferences;
    private static final String PREFERENCES_PACKAGE_NAME = "com.example.corona";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "rememberMe";

    //2. constructor name the same as class name
    public User() {} // constructor without name, it is created automatic, we don't have to create it
    public User(Context context) { //this constructor will be used in LoginActivity
        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME, Context.MODE_PRIVATE);
    }

    public User(String username, String email, String password) { //this constructor will be used in RegisterActivity
        this.username = username; //kaireje pozymis, desineje - parametras paduodamas per konstruktoriu
        this.email = email;
        this.password = password;
    }

    // 3.get'er/set'er - methods
    // get is function without parameters, returns
    public String getUsernameForRegistration() {
        return username;
    }

    public String getPasswordForRegistration() {
        return password;
    }

    public String getEmailForRegistration() {
        return email;
    }

    // set doesn't return anything, it has parameters

    public void setUsernameForRegistration(String username) {
        this.username = username;
    }

    public void setPasswordForRegistration(String password) {
        this.password = password;
    }

    public void setEmailForRegistration(String email) {
        this.email = email;
    }

    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY, "");
    }

    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY, username).commit();
    }

    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY, "");
    }

    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY, password).commit();
    }

    public boolean isRememberedForLogin(){
        return this.sharedPreferences.getBoolean(REMEMBER_ME_KEY, false);
    }

    public void setRemembermeKeyForLogin(boolean remembermeKey) {
        this.sharedPreferences.edit().putBoolean(REMEMBER_ME_KEY, remembermeKey).commit();
    }


}



