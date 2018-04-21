package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Gifs {

        @PrimaryKey
        public final int id;
        public String gifTitle;
        public String gifUrl;


        public Gifs(int id, String gifTitle, String gifUrl) {
            this.id = id;
            this.gifTitle = gifTitle;
            this.gifUrl = gifUrl;
        }

    }
