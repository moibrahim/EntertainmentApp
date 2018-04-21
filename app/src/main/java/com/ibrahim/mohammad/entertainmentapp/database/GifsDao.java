package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;



@Dao
public interface GifsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addGif(Gifs gifs);

    @Query("select * from gifs")
    public List<Gifs> getAllgifs();

    @Query("select * from gifs where id = :gifId")
    public List<Gifs> getGif(long gifId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateGif(Gifs gifs);

    @Query("delete from gifs")
    void removeAllGifs();
}