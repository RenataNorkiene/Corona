package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity { //klases pradzia

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate funkcijos pradzia
        super.onCreate(savedInstanceState); // tuscio lango sukurimas
        setContentView(R.layout.activity_login); // kodas siejamas su vaizdu

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);
        CheckBox rememberMe = findViewById(R.id.rememberMe);

        //created object - class name, object name, new, constructor name, parameters
        User user = new User(LoginActivity.this); //has info, it is connected with SharedPreferences

        rememberMe.setChecked(user.isRememberedForLogin()); // returns true or false if it was checked the last time
        //only shows in login
        if (rememberMe.isChecked()) {
            username.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE);
            password.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
        }
        else {
            username.setText("", TextView.BufferType.EDITABLE);  //take from SharedPreferences, editable means that you can change username/password
            password.setText("", TextView.BufferType.EDITABLE);
        }

//        System.out.println("I KITM istojo Jonas, kuris uzpilde tokius duomenis i sistema:");
//        //sukuriamas Jono objektas
//        User user = new User("Jonas", "nykstukas");
//        System.out.println(user.getUsername() + " suvede si slaptazodi i sistema: " + user.getPassword());
//        System.out.println(user.getUsername() + " pasikeite slaptazodi is " + user.getPassword() + " i");
//        user.setPassword("undinele");
//        System.out.println("nuo siol " + user.getUsername() + " slaptazodis yra " + user.getPassword());



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //kodas paspaudus mygtuka login

                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();

                if (Validation.isUsernameValid(usernameStr) && Validation.isUsernameValid(passwordStr)) {

                    user.setUsernameForLogin(usernameStr);
                    user.setPasswordForLogin(passwordStr);

                    //patikrinti ar pazymetas checkbox ar ne:

                    if (rememberMe.isChecked()) {
                        user.setRemembermeKeyForLogin(true); //pasakome kad norime ji irasyti i sharedpreferences
                    }
                    else {
                        user.setRemembermeKeyForLogin(false); //next time it should be empty
                    }

//                    Toast.makeText(LoginActivity.this,"username: " + user.getUsername() + "\n" + "password: " + user.getPassword(), Toast.LENGTH_LONG).show();

                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class); //parametrai: iš kur (visad su this, nes šita klasė), į kur (visad su class)
                    startActivity(goToSearchActivity);

                } else {
                    username.setError(getResources().getString(R.string.login_invalid_credentials));
                    username.requestFocus();

                }

            }

        });

        register.setOnClickListener(new View.OnClickListener() { //kodas paspaudus mygtuka register
            @Override
            public void onClick(View v) {

                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);


            } // event pabaiga

        }); //  event listener pabaiga

    } // onCreate funkcijos pabaiga

} //klases pabaiga



