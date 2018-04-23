package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface SettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addSettings(Settings settings);

    @Query("select * from settings")
    public List<Settings> getAllSettings();

    @Query("select * from settings where id = :settingsId")
    public List<Settings> getSettings(long settingsId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateSettings(Settings settings);

    @Query("delete from settings")
    void removeAllSettings();
}

