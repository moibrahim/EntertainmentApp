package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addProfile(Profile profile);

    @Query("select * from profile")
    public List<Profile> getAllProfile();

    @Query("select * from profile where id = :profileId")
    public List<Profile> getProfile(long profileId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateProfile(Profile profile);

    @Query("delete from profile")
    void removeAllProfiles();
}

