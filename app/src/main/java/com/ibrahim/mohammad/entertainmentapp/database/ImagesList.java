package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ImagesList {

    @PrimaryKey
    public final int id;
    public String imageTitle;
    public String imageUrl;


    public ImagesList(int id, String imageTitle, String imageUrl) {
        this.id = id;
        this.imageTitle = imageTitle;
        this.imageUrl = imageUrl;
    }

}