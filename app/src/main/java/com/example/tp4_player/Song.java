package com.example.tp4_player;

public class Song {

    private String titre;
    private String image;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Song(){

    }
    public Song(String titre, String image) {
        this.titre = titre;
        this.image = image;
    }
}
