package com.ibrahim.mohammad.entertainmentapp.database;

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Profile.class,Settings.class}, version = 17, exportSchema = false)
public abstract class AppDatabaseRoom2 extends RoomDatabase {

    private static AppDatabaseRoom2 INSTANCE;

    public abstract ProfileDao profileDao();
    public abstract SettingsDao settingsDao();


    public static AppDatabaseRoom2 getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabaseRoom2.class, "userdatabase2")
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
