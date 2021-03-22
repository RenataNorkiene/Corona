package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText email = findViewById(R.id.email);
        Button register = findViewById(R.id.register);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();
                String emailStr = email.getText().toString();

                username.setError(null);
                password.setError(null);
                email.setError(null);

                if (Validation.isUsernameValid(usernameStr) && Validation.isPasswordValid(passwordStr) && Validation.isEmailValid(emailStr)) {
                    Toast.makeText(RegisterActivity.this, "Username: " +
                            usernameStr + "\n" + "Email: " + emailStr + "\n" + "Password: " + passwordStr, Toast.LENGTH_LONG).show();

                    Intent goToLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(goToLoginActivity);

                } else {
                    username.setError(getResources().getString(R.string.register_invalid_credentials));
                    username.requestFocus();
                }

            }

        });

    }
}
