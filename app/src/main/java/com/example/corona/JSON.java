package com.example.corona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    } //readAll end

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }//readJsonFromUrl end
// trys metodai svarbus norint issitraukti norimus duomenis is JSON
    public static ArrayList<Coctails> getList(JSONArray jsonArray) throws JSONException{
        ArrayList<Coctails> coctailsList = new ArrayList<Coctails>(); //created list with all counties
        //extract data from JSON and save it in Corona Objects List(coronaList)
        for (int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Coctails coctails = new Coctails( //constructor for one object
                    // public Coctails(string id, String name, String tags, String category, String glass)
                    jsonObject.getString("idDrink"),
                    jsonObject.getString("strDrink"),
                    jsonObject.getString("strTags"),
                    jsonObject.getString("strCategory"),
                    jsonObject.getString("strGlass")
            );
            coctailsList.add(coctails); //every objects of JSON goes true cycle and extracts data (country, lastUpdate etc.)
        }


        return coctailsList;
    }
    public static JSONArray getJSONArray(JSONObject jsonObject) throws JSONException{ //from array extract list
       //remove from JSON all info, which is not needed, exept covid19Stats Array
//        int jsonLength = jsonObject.toString().length();
//        String covid19Stats = "{" + jsonObject.toString().substring(96, jsonLength) + "}"; //substring delete some symbols from string (starts from 96 till the end)
//
//        //string convert to JSONObject
           //JSONObject jsonObject1 = new JSONObject(covid19Stats);
//        //JSONObject convert to JSONArray
        JSONArray jsonArray = jsonObject.getJSONArray("drinks");
        return jsonArray; //sita jsonArray paims aukstesnis metodas getList ir grazins mums sarasa
    }

    public static ArrayList<Coctails> getCoctailsList(ArrayList<Coctails> coctailsArrayList, String coctailName){
        ArrayList<Coctails> coctailsList = new ArrayList<Coctails>();
        for (Coctails coctails : coctailsArrayList) { //kaireje bus sukuriamas tos klases objektas, per kurios sarasa iteruojame (desineje)
            if(coctails.getName().contains(coctailName)){ //contains method (string method)  search part of string/word (country)
                coctailsList.add(coctails);
            }
        }
        return coctailsList;
    }



}//json end