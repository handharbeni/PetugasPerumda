package com.mhandharbeni.petugasperumda.room.entity.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class ListPegawaiUnit implements Serializable {
    @NonNull
    @PrimaryKey
    @SerializedName("np")
    @Expose
    private String np;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("kdjabatan")
    @Expose
    private String kdjabatan;

    public String getNp() {
        return np;
    }

    public void setNp(String np) {
        this.np = np;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKdjabatan() {
        return kdjabatan;
    }

    public void setKdjabatan(String kdjabatan) {
        this.kdjabatan = kdjabatan;
    }
}
