package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Settings {

    @PrimaryKey
    public final int id;
    public String sound;
    public String notifications;
    public String other;


    public Settings(int id, String sound, String notifications,String other) {
        this.id = id;
        this.sound = sound;
        this.notifications = notifications;
        this.other = other;
    }

}