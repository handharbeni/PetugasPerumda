package com.mhandharbeni.petugasperumda.room.interfaceDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mhandharbeni.petugasperumda.room.entity.data.ListPengaduanUnit;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ListPengaduanUnitInterface {
    @Insert(onConflict = REPLACE)
    void insertAll(List<ListPengaduanUnit> list);

    @Insert(onConflict = REPLACE)
    void insert(ListPengaduanUnit pengaduanUnit);

    @Query("SELECT * FROM ListPengaduanUnit")
    LiveData<List<ListPengaduanUnit>> getLiveData();

    @Query("SELECT * FROM ListPengaduanUnit WHERE fnopengaduan = :nopengaduan")
    LiveData<List<ListPengaduanUnit>> getLiveDataById(String nopengaduan);
}
