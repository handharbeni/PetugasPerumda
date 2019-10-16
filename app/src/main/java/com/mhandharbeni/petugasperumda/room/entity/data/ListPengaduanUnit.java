package com.mhandharbeni.petugasperumda.room.entity.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class ListPengaduanUnit implements Serializable {
    @NonNull
    @PrimaryKey
    @SerializedName("fnopengaduan")
    @Expose
    private String fnopengaduan;
    @SerializedName("fkdunit")
    @Expose
    private String fkdunit;
    @SerializedName("fnonapel")
    @Expose
    private String fnonapel;
    @SerializedName("fnama")
    @Expose
    private String fnama;
    @SerializedName("falamat")
    @Expose
    private String falamat;
    @SerializedName("fkdjenis")
    @Expose
    private String fkdjenis;
    @SerializedName("fnpadmin")
    @Expose
    private String fnpadmin;
    @SerializedName("funit_admin")
    @Expose
    private String funitAdmin;
    @SerializedName("ftgl_pengaduan")
    @Expose
    private String ftglPengaduan;
    @SerializedName("fjam_pengaduan")
    @Expose
    private String fjamPengaduan;
    @SerializedName("femail")
    @Expose
    private String femail;
    @SerializedName("fnotlpn")
    @Expose
    private String fnotlpn;
    @SerializedName("fkdkondisi")
    @Expose
    private String fkdkondisi;
    @SerializedName("fkdmedia")
    @Expose
    private String fkdmedia;
    @SerializedName("fstatus_pelapor")
    @Expose
    private String fstatusPelapor;
    @SerializedName("fstatus")
    @Expose
    private String fstatus;
    @SerializedName("fketerangan")
    @Expose
    private String fketerangan;
    @SerializedName("fdesa")
    @Expose
    private String fdesa;
    @SerializedName("fgolongan")
    @Expose
    private String fgolongan;
    @SerializedName("fnotiket")
    @Expose
    private String fnotiket;
    @SerializedName("faktif")
    @Expose
    private String faktif;
    @SerializedName("fkdjenisdetail")
    @Expose
    private String fkdjenisdetail;
    @SerializedName("foto1")
    @Expose
    private String foto1;
    @SerializedName("gps1")
    @Expose
    private String gps1;
    @SerializedName("foto2")
    @Expose
    private String foto2;
    @SerializedName("gps2")
    @Expose
    private String gps2;
    @SerializedName("iduserapp")
    @Expose
    private String iduserapp;
    @SerializedName("fblnthn")
    @Expose
    private String fblnthn;
    @SerializedName("ftindakan")
    @Expose
    private String ftindakan;
    @SerializedName("ftgl_penanganan")
    @Expose
    private String ftglPenanganan;
    @SerializedName("fjam_penanganan")
    @Expose
    private String fjamPenanganan;
    @SerializedName("fpelapor")
    @Expose
    private String fpelapor;
    @SerializedName("fnppetugas")
    @Expose
    private String fnppetugas;
    @SerializedName("fkelasaduan")
    @Expose
    private String fkelasaduan;
    @SerializedName("frencanatindakanperbaikan")
    @Expose
    private String frencanatindakanperbaikan;
    @SerializedName("fket_hapuspengaduan")
    @Expose
    private String fketHapuspengaduan;
    @SerializedName("fsurattugas")
    @Expose
    private String fsurattugas;

    public String getFnopengaduan() {
        return fnopengaduan;
    }

    public void setFnopengaduan(String fnopengaduan) {
        this.fnopengaduan = fnopengaduan;
    }

    public String getFkdunit() {
        return fkdunit;
    }

    public void setFkdunit(String fkdunit) {
        this.fkdunit = fkdunit;
    }

    public String getFnonapel() {
        return fnonapel;
    }

    public void setFnonapel(String fnonapel) {
        this.fnonapel = fnonapel;
    }

    public String getFnama() {
        return fnama;
    }

    public void setFnama(String fnama) {
        this.fnama = fnama;
    }

    public String getFalamat() {
        return falamat;
    }

    public void setFalamat(String falamat) {
        this.falamat = falamat;
    }

    public String getFkdjenis() {
        return fkdjenis;
    }

    public void setFkdjenis(String fkdjenis) {
        this.fkdjenis = fkdjenis;
    }

    public String getFnpadmin() {
        return fnpadmin;
    }

    public void setFnpadmin(String fnpadmin) {
        this.fnpadmin = fnpadmin;
    }

    public String getFunitAdmin() {
        return funitAdmin;
    }

    public void setFunitAdmin(String funitAdmin) {
        this.funitAdmin = funitAdmin;
    }

    public String getFtglPengaduan() {
        return ftglPengaduan;
    }

    public void setFtglPengaduan(String ftglPengaduan) {
        this.ftglPengaduan = ftglPengaduan;
    }

    public String getFjamPengaduan() {
        return fjamPengaduan;
    }

    public void setFjamPengaduan(String fjamPengaduan) {
        this.fjamPengaduan = fjamPengaduan;
    }

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail;
    }

    public String getFnotlpn() {
        return fnotlpn;
    }

    public void setFnotlpn(String fnotlpn) {
        this.fnotlpn = fnotlpn;
    }

    public String getFkdkondisi() {
        return fkdkondisi;
    }

    public void setFkdkondisi(String fkdkondisi) {
        this.fkdkondisi = fkdkondisi;
    }

    public String getFkdmedia() {
        return fkdmedia;
    }

    public void setFkdmedia(String fkdmedia) {
        this.fkdmedia = fkdmedia;
    }

    public String getFstatusPelapor() {
        return fstatusPelapor;
    }

    public void setFstatusPelapor(String fstatusPelapor) {
        this.fstatusPelapor = fstatusPelapor;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }

    public String getFketerangan() {
        return fketerangan;
    }

    public void setFketerangan(String fketerangan) {
        this.fketerangan = fketerangan;
    }

    public String getFdesa() {
        return fdesa;
    }

    public void setFdesa(String fdesa) {
        this.fdesa = fdesa;
    }

    public String getFgolongan() {
        return fgolongan;
    }

    public void setFgolongan(String fgolongan) {
        this.fgolongan = fgolongan;
    }

    public String getFnotiket() {
        return fnotiket;
    }

    public void setFnotiket(String fnotiket) {
        this.fnotiket = fnotiket;
    }

    public String getFaktif() {
        return faktif;
    }

    public void setFaktif(String faktif) {
        this.faktif = faktif;
    }

    public String getFkdjenisdetail() {
        return fkdjenisdetail;
    }

    public void setFkdjenisdetail(String fkdjenisdetail) {
        this.fkdjenisdetail = fkdjenisdetail;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getGps1() {
        return gps1;
    }

    public void setGps1(String gps1) {
        this.gps1 = gps1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getGps2() {
        return gps2;
    }

    public void setGps2(String gps2) {
        this.gps2 = gps2;
    }

    public String getIduserapp() {
        return iduserapp;
    }

    public void setIduserapp(String iduserapp) {
        this.iduserapp = iduserapp;
    }

    public String getFblnthn() {
        return fblnthn;
    }

    public void setFblnthn(String fblnthn) {
        this.fblnthn = fblnthn;
    }

    public String getFtindakan() {
        return ftindakan;
    }

    public void setFtindakan(String ftindakan) {
        this.ftindakan = ftindakan;
    }

    public String getFtglPenanganan() {
        return ftglPenanganan;
    }

    public void setFtglPenanganan(String ftglPenanganan) {
        this.ftglPenanganan = ftglPenanganan;
    }

    public String getFjamPenanganan() {
        return fjamPenanganan;
    }

    public void setFjamPenanganan(String fjamPenanganan) {
        this.fjamPenanganan = fjamPenanganan;
    }

    public String getFpelapor() {
        return fpelapor;
    }

    public void setFpelapor(String fpelapor) {
        this.fpelapor = fpelapor;
    }

    public String getFnppetugas() {
        return fnppetugas;
    }

    public void setFnppetugas(String fnppetugas) {
        this.fnppetugas = fnppetugas;
    }

    public String getFkelasaduan() {
        return fkelasaduan;
    }

    public void setFkelasaduan(String fkelasaduan) {
        this.fkelasaduan = fkelasaduan;
    }

    public String getFrencanatindakanperbaikan() {
        return frencanatindakanperbaikan;
    }

    public void setFrencanatindakanperbaikan(String frencanatindakanperbaikan) {
        this.frencanatindakanperbaikan = frencanatindakanperbaikan;
    }

    public String getFketHapuspengaduan() {
        return fketHapuspengaduan;
    }

    public void setFketHapuspengaduan(String fketHapuspengaduan) {
        this.fketHapuspengaduan = fketHapuspengaduan;
    }

    public String getFsurattugas() {
        return fsurattugas;
    }

    public void setFsurattugas(String fsurattugas) {
        this.fsurattugas = fsurattugas;
    }
}
