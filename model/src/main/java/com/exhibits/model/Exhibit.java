package com.exhibits.model;

/**
 * Created by Tourdyiev Roman on 4/21/19.
 */
public class Exhibit {

    String title;
    String[] images;

    public Exhibit(String title, String[] images) {
        this.title = title;
        this.images = images;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
