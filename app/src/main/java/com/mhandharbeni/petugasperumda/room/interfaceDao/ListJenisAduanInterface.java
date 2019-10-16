package com.mhandharbeni.petugasperumda.room.interfaceDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mhandharbeni.petugasperumda.room.entity.data.ListJenisAduan;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ListJenisAduanInterface {
    @Insert(onConflict = REPLACE)
    void insertAll(List<ListJenisAduan> list);

    @Insert(onConflict = REPLACE)
    void insert(ListJenisAduan pengaduanUnit);

    @Query("SELECT * FROM ListJenisAduan")
    LiveData<List<ListJenisAduan>> getLiveData();

    @Query("SELECT * FROM ListJenisAduan WHERE kdjnsaduan = :kdjnsaduan")
    LiveData<List<ListJenisAduan>> getLiveDataById(String kdjnsaduan);
}
