package com.mhandharbeni.petugasperumda.room.interfaceDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mhandharbeni.petugasperumda.room.entity.data.ListPegawaiUnit;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface ListPegawaiUnitInterface {
    @Insert(onConflict = REPLACE)
    void insertAll(List<ListPegawaiUnit> list);

    @Insert(onConflict = REPLACE)
    void insert(ListPegawaiUnit pengaduanUnit);

    @Query("SELECT * FROM ListPegawaiUnit")
    LiveData<List<ListPegawaiUnit>> getLiveData();

    @Query("SELECT * FROM ListPegawaiUnit WHERE np = :np")
    LiveData<List<ListPegawaiUnit>> getLiveDataById(String np);
}
