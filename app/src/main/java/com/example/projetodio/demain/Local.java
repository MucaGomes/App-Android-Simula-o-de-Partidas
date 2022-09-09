package com.example.projetodio.demain;

import com.google.gson.annotations.SerializedName;

public class Local {

    @SerializedName("nomes")
    private String name;

    @SerializedName("imagem")
    private String image;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
