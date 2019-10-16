package com.mhandharbeni.petugasperumda.room.entity.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class ListWOPetugas implements Serializable {

    @NonNull
    @PrimaryKey
    @SerializedName("fnopengaduan")
    @Expose
    private String fnopengaduan;
    @SerializedName("fnppetugas")
    @Expose
    private String fnppetugas;
    @SerializedName("fnpadmin")
    @Expose
    private String fnpadmin;
    @SerializedName("frnctindakan")
    @Expose
    private String frnctindakan;
    @SerializedName("ftgl_rnctindakan")
    @Expose
    private String ftglRnctindakan;
    @SerializedName("fjam_rnctindakan")
    @Expose
    private String fjamRnctindakan;
    @SerializedName("fid")
    @Expose
    private String fid;
    @SerializedName("fstatus")
    @Expose
    private String fstatus;
    @SerializedName("fbagian")
    @Expose
    private String fbagian;
    @SerializedName("fket_selesai")
    @Expose
    private String fketSelesai;
    @SerializedName("fdokumentasi1")
    @Expose
    private String fdokumentasi1;
    @SerializedName("fdokumentasi2")
    @Expose
    private String fdokumentasi2;

    public String getFnopengaduan() {
        return fnopengaduan;
    }

    public void setFnopengaduan(String fnopengaduan) {
        this.fnopengaduan = fnopengaduan;
    }

    public String getFnppetugas() {
        return fnppetugas;
    }

    public void setFnppetugas(String fnppetugas) {
        this.fnppetugas = fnppetugas;
    }

    public String getFnpadmin() {
        return fnpadmin;
    }

    public void setFnpadmin(String fnpadmin) {
        this.fnpadmin = fnpadmin;
    }

    public String getFrnctindakan() {
        return frnctindakan;
    }

    public void setFrnctindakan(String frnctindakan) {
        this.frnctindakan = frnctindakan;
    }

    public String getFtglRnctindakan() {
        return ftglRnctindakan;
    }

    public void setFtglRnctindakan(String ftglRnctindakan) {
        this.ftglRnctindakan = ftglRnctindakan;
    }

    public String getFjamRnctindakan() {
        return fjamRnctindakan;
    }

    public void setFjamRnctindakan(String fjamRnctindakan) {
        this.fjamRnctindakan = fjamRnctindakan;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }

    public String getFbagian() {
        return fbagian;
    }

    public void setFbagian(String fbagian) {
        this.fbagian = fbagian;
    }

    public String getFketSelesai() {
        return fketSelesai;
    }

    public void setFketSelesai(String fketSelesai) {
        this.fketSelesai = fketSelesai;
    }

    public String getFdokumentasi1() {
        return fdokumentasi1;
    }

    public void setFdokumentasi1(String fdokumentasi1) {
        this.fdokumentasi1 = fdokumentasi1;
    }

    public String getFdokumentasi2() {
        return fdokumentasi2;
    }

    public void setFdokumentasi2(String fdokumentasi2) {
        this.fdokumentasi2 = fdokumentasi2;
    }
}
