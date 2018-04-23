package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Profile {

    @PrimaryKey
    public final int id;
    public String rating;
    public String savedPost;
    public String savedPost2;


    public Profile(int id, String rating, String savedPost,String savedPost2) {
        this.id = id;
        this.rating = rating;
        this.savedPost = savedPost;
        this.savedPost2 = savedPost2;
    }

}