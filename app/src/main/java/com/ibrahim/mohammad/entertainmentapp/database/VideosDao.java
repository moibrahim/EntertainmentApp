package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface VideosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVid(Videos Videos);

    @Query("select * from videos")
    public List<Videos> getAllvids();

    @Query("select * from Videos where id = :vidId")
    public List<Videos> getVid(long vidId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateVid(Videos Videos);

    @Query("delete from videos")
    void removeAllVids();
}
