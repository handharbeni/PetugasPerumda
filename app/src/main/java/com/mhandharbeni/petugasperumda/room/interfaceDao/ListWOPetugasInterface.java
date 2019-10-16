package com.mhandharbeni.petugasperumda.room.interfaceDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mhandharbeni.petugasperumda.room.entity.data.ListWOPetugas;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface ListWOPetugasInterface {
    @Insert(onConflict = REPLACE)
    void insertAll(List<ListWOPetugas> list);

    @Insert(onConflict = REPLACE)
    void insert(ListWOPetugas pengaduanUnit);

    @Query("SELECT * FROM ListWOPetugas")
    LiveData<List<ListWOPetugas>> getLiveData();

    @Query("SELECT * FROM ListWOPetugas WHERE fnopengaduan = :fnopengaduan")
    LiveData<List<ListWOPetugas>> getLiveDataById(String fnopengaduan);
}
