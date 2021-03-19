package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity { //klases pradzia

    @Override
    protected void onCreate(Bundle savedInstanceState) { //funkcijos pradzia
        super.onCreate(savedInstanceState); // tuscio lango sukurimas
        setContentView(R.layout.activity_login); //suteik siam langui si vaizda (kodas siejamas su vaizdu)

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();

                if (Validation.isUsernameValid(usernameStr) && Validation.isUsernameValid(passwordStr)) {
                    Toast.makeText(LoginActivity.this, "Username: " + usernameStr + "\n" + "Password: " + passwordStr, Toast.LENGTH_LONG).show();
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class); //parametrai: iš kur (visad su this, nes šita klasė), į kur (visad su class)
                    startActivity(goToSearchActivity);
                } else {
                    username.setError(getResources().getString(R.string.login_invalid_credentials));
                    username.requestFocus();

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);


            }
        });
    }
}
