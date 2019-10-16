package com.mhandharbeni.petugasperumda.room.entity.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPegawai {
    @SerializedName("np")
    @Expose
    private String np;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("tgllahir")
    @Expose
    private String tgllahir;
    @SerializedName("kdunit")
    @Expose
    private String kdunit;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("kdbagian")
    @Expose
    private String kdbagian;
    @SerializedName("kdjabatan")
    @Expose
    private String kdjabatan;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getKdunit() {
        return kdunit;
    }

    public void setKdunit(String kdunit) {
        this.kdunit = kdunit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKdbagian() {
        return kdbagian;
    }

    public void setKdbagian(String kdbagian) {
        this.kdbagian = kdbagian;
    }

    public String getKdjabatan() {
        return kdjabatan;
    }

    public void setKdjabatan(String kdjabatan) {
        this.kdjabatan = kdjabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
