package com.example.nda;

import com.google.gson.annotations.SerializedName;



public class RetroUser {



// Dale al campo un nombre personalizado //


    @SerializedName("name")
    private String name;

    public RetroUser(String name) {
        this.name = name;

    }


// Recupere los datos usando métodos setter / getter //

public String getUser() {
        return name;
        }

public void setUser(String name) {
        this.name = name;
        }

        }

