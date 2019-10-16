package com.mhandharbeni.petugasperumda.room.interfaceDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mhandharbeni.petugasperumda.room.entity.data.ListKelasAduan;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface ListKelasAduanInterface {
    @Insert(onConflict = REPLACE)
    void insertAll(List<ListKelasAduan> list);

    @Insert(onConflict = REPLACE)
    void insert(ListKelasAduan pengaduanUnit);

    @Query("SELECT * FROM ListKelasAduan")
    LiveData<List<ListKelasAduan>> getLiveData();

    @Query("SELECT * FROM ListKelasAduan WHERE idkelasaduan = :idkelasaduan")
    LiveData<List<ListKelasAduan>> getLiveDataById(String idkelasaduan);
}
