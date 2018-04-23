package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ImagesList.class}, version = 17, exportSchema = false)
public abstract class AppDatabaseRoom3 extends RoomDatabase {

    private static AppDatabaseRoom3 INSTANCE;

    public abstract ImagesListDao imagesDao();


    public static AppDatabaseRoom3 getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabaseRoom3.class, "userdatabase3")
//Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
