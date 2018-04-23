package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Videos {

    @PrimaryKey
    public final int id;
    public String vidTitle;
    public String vidUrl;


    public Videos(int id, String vidTitle, String vidUrl) {
        this.id = id;
        this.vidTitle = vidTitle;
        this.vidUrl = vidUrl;
    }

}