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

        EditText username = findViewById(R.id.username);//susiejamas kintamasis vaizde su kintamuoju kode
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        //kodas, susijes su mygtuko paspaudimu

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //onClick pradzia
                // cia rasomas kodas, kuris bus vykdomas kai paspausime mygtuka
                String usernameStr = username.getText().toString();  // String  vienintelis is didziosios raides
                String passwordStr = password.getText().toString();

                username.setError(null);
                password.setError(null);//issivalome klaidu zurnala (username ir password)

                if (Validation.isUsernameValid(usernameStr) && Validation.isPasswordValid(passwordStr)) { //jeigu bus validus duomenys pereisim is vieno lango i kita
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);  //pirmas is kur(this nes esam sitoje klaseje), o antras i kur (class)
                    startActivity(goToSearchActivity);
                } else if (!Validation.isUsernameValid(usernameStr)) { //jeigu nebus validus ismesime i ekrana klaida
                    username.setError(getResources().getString(R.string.login_invalid_username));
                    username.requestFocus();
                    // Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_username),  Toast.LENGTH_SHORT).show();
                } else {
                    password.setError(getResources().getString(R.string.login_invalid_password));
                    password.requestFocus();
                }

            } //onclick pabaiga

        }); //eina kartu jeigu tai yra baigiasi funkcija mygtuko paspaudimu

    } //funkcijos pabaiga

}//klases pabaiga


