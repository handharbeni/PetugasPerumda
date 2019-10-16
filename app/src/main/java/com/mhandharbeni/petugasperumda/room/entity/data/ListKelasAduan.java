package com.mhandharbeni.petugasperumda.room.entity.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class ListKelasAduan implements Serializable {
    @NonNull
    @PrimaryKey
    @SerializedName("idkelasaduan")
    @Expose
    private String idkelasaduan;
    @SerializedName("detail_kelasaduan")
    @Expose
    private String detailKelasaduan;

    public String getIdkelasaduan() {
        return idkelasaduan;
    }

    public void setIdkelasaduan(String idkelasaduan) {
        this.idkelasaduan = idkelasaduan;
    }

    public String getDetailKelasaduan() {
        return detailKelasaduan;
    }

    public void setDetailKelasaduan(String detailKelasaduan) {
        this.detailKelasaduan = detailKelasaduan;
    }
}
