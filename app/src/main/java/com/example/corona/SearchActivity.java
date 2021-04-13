package com.example.corona;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

public class SearchActivity extends AppCompatActivity {
    public static final String COVID_API = "https://covid19-api.weedmark.systems/api/v1/stats";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //new thread(gija) starts (to read JSON from API)
        AsyncFetch asyncFetch = new AsyncFetch();
        asyncFetch.execute();
    }


    private class AsyncFetch extends AsyncTask<String, String, JSONObject> {
        ProgressDialog progressDialog = new ProgressDialog(SearchActivity.this);

        @Override
        protected void onPreExecute() { //method implemented before doInBackground, user waits till gets info from API
            super.onPreExecute();
            progressDialog.setMessage(getResources().getString(R.string.search_loading_data));
            progressDialog.setCancelable(false); //user has to wait, can't to cancel
            progressDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... strings) { //will be executed while user waits (see progressDialog), gets JSON from API
            try {
                JSONObject jsonObject = JSON.readJsonFromUrl(COVID_API);
                return jsonObject;
            } catch (IOException e) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getString(R.string.search_error_reading_data) + e.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            } catch (JSONException e) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getString(R.string.search_error_reading_data) + e.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            } //catch ends
            return null;
        }//doIn Background ends

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            progressDialog.dismiss();

            int statusCode = 0;
            try {
                statusCode = jsonObject.getInt("statusCode");
            } catch (JSONException e) {
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getString(R.string.search_error_reading_data) + e.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }//catch ends
            if(statusCode == HttpURLConnection.HTTP_OK) {
                System.err.println(jsonObject.toString());
                Toast.makeText(SearchActivity.this, jsonObject.toString(),
                        Toast.LENGTH_LONG
                ).show();
            } else { //if something is wrong, not ok(200 code)
                String message = null;
                try {
                    message = jsonObject.getString("message");
                } catch (JSONException e) {
                    Toast.makeText(
                            SearchActivity.this,
                            getResources().getString(R.string.search_error_reading_data) + e.getMessage(),
                            Toast.LENGTH_LONG
                    ).show();
                } //catch ends
                Toast.makeText(
                        SearchActivity.this,
                        getResources().getString(R.string.search_error_reading_data) + message,
                        Toast.LENGTH_LONG
                ).show();
            } //else ends
        } //onPostExecute ends
    } //AsyncFetch class ends
    //jeigu reiks dar kokiu metodu, rasysime cia
} //SearchActivity class ends

