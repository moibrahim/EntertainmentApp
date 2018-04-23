package com.ibrahim.mohammad.entertainmentapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ImagesListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addImages(ImagesList images);

    @Query("select * from ImagesList")
    public List<ImagesList> getAllImages();

    @Query("select * from ImagesList where id = :imagesId")
    public List<ImagesList> getImages(long imagesId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateImages(ImagesList images);

    @Query("delete from ImagesList")
    void removeAllImages();
}

