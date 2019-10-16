package com.mhandharbeni.petugasperumda.room.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;

import com.mhandharbeni.petugasperumda.room.entity.data.ListJenisAduan;
import com.mhandharbeni.petugasperumda.room.entity.data.ListKelasAduan;
import com.mhandharbeni.petugasperumda.room.entity.data.ListPegawaiUnit;
import com.mhandharbeni.petugasperumda.room.entity.data.ListPengaduanUnit;
import com.mhandharbeni.petugasperumda.room.entity.data.ListWOPetugas;
import com.mhandharbeni.petugasperumda.room.interfaceDao.ListJenisAduanInterface;
import com.mhandharbeni.petugasperumda.room.interfaceDao.ListKelasAduanInterface;
import com.mhandharbeni.petugasperumda.room.interfaceDao.ListPegawaiUnitInterface;
import com.mhandharbeni.petugasperumda.room.interfaceDao.ListPengaduanUnitInterface;
import com.mhandharbeni.petugasperumda.room.interfaceDao.ListWOPetugasInterface;
import com.mhandharbeni.petugasperumda.room.migration.Migrator;
import com.mhandharbeni.petugasperumda.room.utils.DateConverter;
import com.mhandharbeni.petugasperumda.utils.Constant;

@TypeConverters(DateConverter.class)
@Database(
        entities = {
                ListPengaduanUnit.class,
                ListJenisAduan.class,
                ListKelasAduan.class,
                ListPegawaiUnit.class,
                ListWOPetugas.class
        },
        version = Constant.versionDb,
        exportSchema = false
)
public abstract class AppDb extends RoomDatabase {
    public abstract ListJenisAduanInterface jenisAduan();
    public abstract ListKelasAduanInterface kelasAduan();
    public abstract ListPegawaiUnitInterface pegawaiUnit();
    public abstract ListPengaduanUnitInterface pengaduanUnit();
    public abstract ListWOPetugasInterface woPetugas();

    private static volatile AppDb INSTANCE;
    public static Migration[] migrations = new Migration[]{
            Migrator.MIGRATION_0_1,
            Migrator.MIGRATION_1_2,
            Migrator.MIGRATION_2_3,
            Migrator.MIGRATION_3_4,
            Migrator.MIGRATION_4_5
    };
    public static AppDb getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppDb.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDb.class,
                            Constant.nameDb
                    )
                            .allowMainThreadQueries()
                            .addMigrations(migrations)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
