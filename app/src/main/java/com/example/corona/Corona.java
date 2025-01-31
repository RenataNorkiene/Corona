package com.example.corona;

public class Corona {
//variables:

   private String country;
   private String lastUpdate;
   private String keyId;
   private int confirmed;
   private int deaths;

    public Corona(String country, String lastUpdate, String keyId, int confirmed, int deaths) {
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.keyId = keyId;
        this.confirmed = confirmed;
        this.deaths = deaths;
    }//constructor end

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;

    } //getters and setters end

    @Override
    public String toString() {
        return "Corona{" +
                "country='" + country + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", keyId='" + keyId + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                '}';
    } //toString end



}//class end
