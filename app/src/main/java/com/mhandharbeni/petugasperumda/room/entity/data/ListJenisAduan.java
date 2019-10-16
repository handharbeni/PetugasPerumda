package com.mhandharbeni.petugasperumda.room.entity.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class ListJenisAduan implements Serializable {
    @NonNull
    @PrimaryKey
    @SerializedName("kdjnsaduan")
    @Expose
    private String kdjnsaduan;
    @SerializedName("detail_jnsaduan")
    @Expose
    private String detailJnsaduan;

    public String getKdjnsaduan() {
        return kdjnsaduan;
    }

    public void setKdjnsaduan(String kdjnsaduan) {
        this.kdjnsaduan = kdjnsaduan;
    }

    public String getDetailJnsaduan() {
        return detailJnsaduan;
    }

    public void setDetailJnsaduan(String detailJnsaduan) {
        this.detailJnsaduan = detailJnsaduan;
    }
}
