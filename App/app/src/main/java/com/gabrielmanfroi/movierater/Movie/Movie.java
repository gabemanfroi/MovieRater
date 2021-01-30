package com.gabrielmanfroi.movierater.Movie;

import android.media.Rating;

public class Movie {

    private String title;
    private int img;
    //private int estrelas;
    private String genre;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
